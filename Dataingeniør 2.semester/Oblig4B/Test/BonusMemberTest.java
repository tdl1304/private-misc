import Oblig4B.BonusMember;
import Oblig4B.Personals;
import Oblig4B.memberships.BasicMember;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class BonusMemberTest {
    Personals ole = new Personals("Olsen", "Ole", "ole.olsen@dot.com", "ole");
    BasicMember b1 = new BasicMember(100, LocalDate.of(2006, 2, 15),ole, 0);

    @Test
    public void testInvalidParametersInConstructor() {
        try {
            BonusMember bm = new BasicMember(12, null, null, 0); // Should throw exception
            fail("some arguments are bad input"); // If I get to this line, the test has failed
        } catch (IllegalArgumentException e) {
            //Do not need to add anything here, since if the Exception is thrown, the
            //test is an success
        }

    }

    @Test
    public void testEmptyParametersFindQualificationPoints() {
        try {
            b1.findQualificationPoints(null);
            fail("date is null"); //Test failed
        } catch (NullPointerException exception) {
            //Test succeed
        }
    }

    @Test
    public void testEmptyParametersOkPassword() {
        try {
            b1.okPassword(null);
            fail("password nullexception not caught"); //Test failed
        } catch (IllegalArgumentException exception) {
            //Test succeed
        }
    }

    @Test
    public void testReadBonusMembers() {
        try {
            BonusMember.readMembers().stream().forEach(x->BonusMember.readFormattedSaveData(x));
        } catch (FileNotFoundException e) {
            fail(e.getLocalizedMessage());
        } catch (IOException e) {
            fail(e.getLocalizedMessage());
        }
    }

    protected void fail(String message) {
        assert false : message;
    }
}