package Oblig4B;

import Oblig4B.memberships.BasicMember;
import Oblig4B.memberships.GoldMember;
import Oblig4B.memberships.SilverMember;
import com.sun.media.jfxmedia.logging.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class MemberArchive {
    public static final int SILVER_LIMIT = 25000;
    public static final int GOLD_LIMIT = 75000;
    private static final int MAX_TRY = 10;
    private static final Random RANDOM_NUMBER = new Random();
    private ArrayList<BonusMember> memberList = new ArrayList<BonusMember>();

    public ArrayList<BonusMember> getMemberList() {
        return memberList;
    }

    public int findPoints(int memberNo, String password) {
        return findMember(memberNo).getPoints();
    }

    public void registerPoints(int memberNo, int points) {
        findMember(memberNo).registerPoints(points);
    }

    /**
     * Exception kastes når man søker på et medlem som ikke eksisterer. Da kastes NoSuchElementException.
     *
     * @param memberNo
     * @return
     * @throws NoSuchElementException
     */
    public BonusMember findMember(int memberNo) throws NoSuchElementException {
        Optional<BonusMember> member = memberList.stream()
                .filter(x -> x.getMemberNo() == memberNo).findFirst();
        return member.get();
    }

    public BonusMember findMember(Personals personals) {
        Optional<BonusMember> member = memberList.stream()
                .filter(x -> x.getPersonals().equals(personals)).findFirst();
        return member.get();
    }

    public void addToList(BonusMember member) {
        if (!memberList.contains(member)) {
            memberList.add(member);
        }
    }

    public void deleteMember(BonusMember member) throws IOException {
        BonusMember.deleteMemberData(member);
    }


    /**
     * Basic member arver av Oblig4B.BonusMember, dermed kastes IllegalArgumentException ifølge super konstruktør
     *
     * @param personals
     * @return
     * @throws IllegalArgumentException
     */
    public int newMember(Personals personals) throws IllegalArgumentException {
        BasicMember newMember = new BasicMember(findAvailableNo(), LocalDate.now(), personals, 0);
        if (!memberList.contains(newMember)) {
            addToList(newMember);
            return newMember.getMemberNo();
        } else return -1;
    }

    private int findAvailableNo() {
        int randomInt = Math.abs(RANDOM_NUMBER.nextInt());
        if (memberList.stream().anyMatch(x -> x.getMemberNo() == randomInt)) {
            findAvailableNo();
        } else {
            return randomInt;
        }
        return -1;
    }


    public int checkMembers() {
        AtomicInteger count = new AtomicInteger();

        List<BonusMember> basicAndSilverMembers = memberList.stream()
                .filter(x -> x instanceof BasicMember || x instanceof SilverMember)
                .collect(Collectors.toList());

        basicAndSilverMembers.forEach(x -> {
            if (x instanceof BasicMember && x.findQualificationPoints(LocalDate.now()) >= SILVER_LIMIT) {
                try {
                    count.getAndIncrement();
                    memberList.remove(x);
                    deleteMember(x);
                    SilverMember upgradedSilverMember = new SilverMember(x.getMemberNo(), x.getEnrolledDate(), x.getPersonals(), x.getPoints());
                    BonusMember.savePersonals(upgradedSilverMember);
                    memberList.add(upgradedSilverMember);
                } catch (IOException e) {
                    MemberUI.log(Level.WARNING, e.getStackTrace().toString());
                }
            } else if (x instanceof SilverMember && x.findQualificationPoints(LocalDate.now()) >= GOLD_LIMIT) {
                try {
                    count.getAndIncrement();
                    memberList.remove(x);
                    deleteMember(x);
                    GoldMember upgradedGoldMember = new GoldMember(x.getMemberNo(), x.getEnrolledDate(), x.getPersonals(), x.getPoints());
                    BonusMember.savePersonals(upgradedGoldMember);
                    memberList.add(upgradedGoldMember);
                } catch (IOException e) {
                    MemberUI.log(Level.WARNING, e.getStackTrace().toString());
                }
            }
        });

        return count.get();
    }

}

