package Oblig2;

import Oblig2.memberships.BasicMember;
import Oblig2.memberships.GoldMember;
import Oblig2.memberships.SilverMember;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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

    public void addToList(BonusMember member) {
        if (!memberList.contains(member)) {
            memberList.add(member);
        }
    }


    /**
     * Basic member arver av BonusMember, dermed kastes IllegalArgumentException ifølge super konstruktør
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
                count.getAndIncrement();
                memberList.remove(x);
                memberList.add(new SilverMember(x.getMemberNo(), x.getEnrolledDate(), x.getPersonals(), x.getPoints()));
            } else if (x instanceof SilverMember && x.findQualificationPoints(LocalDate.now()) >= GOLD_LIMIT) {
                count.getAndIncrement();
                memberList.remove(x);
                memberList.add(new GoldMember(x.getMemberNo(), x.getEnrolledDate(), x.getPersonals(), x.getPoints()));
            }
        });
        return count.get();
    }

}

