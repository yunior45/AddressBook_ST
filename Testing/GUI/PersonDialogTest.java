package GUI;

import AddressBookTest.Person;
import GUI.PersonDialog.Result;
import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonDialogTest {

    private PersonDialog testPersonDialog1;
    private PersonDialog testPersonDialog2;
    private PersonDialog testPersonDialog3;
    private JFrame testJFrame;
    private Person testPerson;
    private Person testPersonEmpty;

    @Before
    public void setUp() {
        testJFrame = new JFrame();
        testPerson = new Person(
            "fName",
            "lName",
            "address",
            "city",
            "state",
            "zip",
            "123456798");
        testPerson = new Person("","","","","","","");
        testPersonDialog1 = new PersonDialog(testJFrame, testPerson);
        testPersonDialog2 = new PersonDialog(testJFrame, testPersonEmpty);
        testPersonDialog3 = new PersonDialog(testJFrame);
    }

    // This method tests the PersonDialog's showDialog() method.
    @Test
    public void testShowDialog() {
        // Creating the expected results.
        Result wrongResult = Result.OK;
        Result expectedResult = Result.CANCEL;

        // Testing for matching expecting result.
        Assert.assertEquals(expectedResult, testPersonDialog1.showDialog());
        Assert.assertEquals(expectedResult, testPersonDialog2.showDialog());
        Assert.assertEquals(expectedResult, testPersonDialog3.showDialog());

        // Testing for incorrect result.
        Assert.assertNotEquals(wrongResult, testPersonDialog1.showDialog());
        Assert.assertNotEquals(wrongResult, testPersonDialog2.showDialog());
        Assert.assertNotEquals(wrongResult, testPersonDialog3.showDialog());
    }

    // This method tests the PersonDialog's getPerson() method.
    @Test
    public void testGetPerson() {
        // Testing for matching Expected Results
        Assert.assertEquals(testPerson, testPersonDialog1.getPerson());
        Assert.assertEquals(null, testPersonDialog2.getPerson());
        Assert.assertEquals(null, testPersonDialog3.getPerson());

        // Testing for not matching Expecting Results
        Assert.assertNotEquals(null, testPersonDialog1.getPerson());
        Assert.assertNotEquals(testPerson, testPersonDialog2.getPerson());
        Assert.assertNotEquals(testPerson, testPersonDialog3.getPerson());
    }
}