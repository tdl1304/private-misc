package Oblig2;

import static org.junit.jupiter.api.Assertions.*;
import Oblig2.BonusMember;
import Oblig2.memberships.BasicMember;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class BonusMemberTest {
    Personals ole = new Personals("Olsen", "Ole", "ole.olsen@dot.com", "ole");
    BasicMember b1 = new BasicMember(100, LocalDate.of(2006, 2, 15),ole, 0);

    @Test
    public void testInvalidParametersInConstructor() {
        try {
            BonusMember bm = new BasicMember(12, null, null, 0); // Should throw exception
            fail(); // If I get to this line, the test has failed
        } catch (IllegalArgumentException e) {
            //Do not need to add anything here, since if the Exception is thrown, the
            //test is an success
        }

    }

    @Test
    public void testEmptyParametersFindQualificationPoints() {
        try {
            b1.findQualificationPoints(null);
            fail(); //Test failed
        } catch (NullPointerException exception) {
            //Test succeed
        }
    }

    @Test
    public void testEmptyParametersOkPassword() {
        try {
            b1.okPassword("");
            fail(); //Test failed
        } catch (NullPointerException exception) {
            //Test succeed
        }
    }

    protected void fail() {
        assert false : "Test failed";
    }
}