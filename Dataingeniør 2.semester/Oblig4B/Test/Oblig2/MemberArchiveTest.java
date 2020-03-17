package Oblig2;

import Oblig2.memberships.BasicMember;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MemberArchiveTest {
    MemberArchive archive = new MemberArchive();

    @Test
    public void testEmptyFindMember() {
        try {
            archive.findMember(-1);
            fail();
        } catch (NoSuchElementException e) {
            //Do not need to add anything here, since if the Exception is thrown, the
            //test is an success
        }
    }

    @Test
    public void testIllegalParameterNewMember() {
        try {
            archive.newMember(null);
            fail();
        } catch (IllegalArgumentException e) {
            //Do not need to add anything here, since if the Exception is thrown, the
            //test is an success
        }
    }


}