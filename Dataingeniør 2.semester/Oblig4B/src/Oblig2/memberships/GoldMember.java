package Oblig2.memberships;

import Oblig2.Personals;
import Oblig2.BonusMember;

import java.time.LocalDate;

public class GoldMember extends BonusMember {

    public GoldMember(int memberNo, LocalDate enrolledDate, Personals personals, int points) {
        super(memberNo, enrolledDate, personals);
        super.setPoints(points);
    }

    public void registerPoints(int points) {
        super.registerPoints((int)(points*GOLD_FACTOR));
    }
}
