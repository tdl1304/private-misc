package Oblig4B.memberships;

import Oblig4B.Personals;
import Oblig4B.BonusMember;

import java.time.LocalDate;

public class SilverMember extends BonusMember {

    public SilverMember(int memberNo, LocalDate enrolledDate, Personals personals, int points) {
        super(memberNo, enrolledDate, personals);
        super.setPoints(points);
    }

    public void registerPoints(int points) {
        super.registerPoints((int) (points * SILVER_FACTOR));
    }
    @Override
    public String toString() {
        return "Silver Member\n"+getPersonals().toString()+"\nMember No: "+getMemberNo()+"\nEnrolled date: "+getEnrolledDate().toString()+"\nPoints: "+getPoints()+"\n";
    }
}
