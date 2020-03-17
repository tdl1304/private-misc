package Oblig2.memberships;

import Oblig2.BonusMember;
import Oblig2.Personals;

import java.time.LocalDate;

public class BasicMember extends BonusMember {

    public BasicMember(int memberNo, LocalDate enrolledDate, Personals personals, int points) {
        super(memberNo, enrolledDate, personals);
        super.setPoints(points);
    }
}
