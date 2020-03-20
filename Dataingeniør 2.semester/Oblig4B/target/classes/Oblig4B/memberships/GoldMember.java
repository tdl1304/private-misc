package Oblig4B.memberships;

import Oblig4B.BonusMember;
import Oblig4B.Personals;

import java.time.LocalDate;

public class GoldMember extends BonusMember {

    public GoldMember(int memberNo, LocalDate enrolledDate, Personals personals, int points) {
        super(memberNo, enrolledDate, personals);
        super.setPoints(points);
    }

    public void registerPoints(int points) {
        super.registerPoints((int)(points*GOLD_FACTOR));
    }
    @Override
    public String toString() {
        return "Gold Member\n"+getPersonals().toString()+"\nMember No: "+getMemberNo()+"\nEnrolled date: "+getEnrolledDate().toString()+"\nPoints: "+getPoints()+"\n";
    }
}
