package Oblig4B.memberships;

import Oblig4B.BonusMember;
import Oblig4B.Personals;

import java.time.LocalDate;

public class BasicMember extends BonusMember {

    public BasicMember(int memberNo, LocalDate enrolledDate, Personals personals, int points) {
        super(memberNo, enrolledDate, personals);
        super.setPoints(points);
    }

    @Override
    public String toString() {
        return "Basic Member\n"+getPersonals().toString()+"\nMember No: "+getMemberNo()+"\nEnrolled date: "+getEnrolledDate().toString()+"\nPoints: "+getPoints()+"\n";
    }
}
