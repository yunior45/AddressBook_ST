package Testing.IntegrationTesting;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import AddressBookTest.Person;
import GUI.PersonDialog;
import javax.swing.JFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonDialogIT {

  private PersonDialog personDialogA;
  private PersonDialog personDialogB;
  private JFrame jframe;
  private Person person;
  private Person testPerson;


  @Before
  public void setUp() {
    person = mock(Person.class);
    jframe = new JFrame();
    personDialogA = new PersonDialog(jframe, person);

    testPerson = new Person(
        "John",
        "Smith",
        "123 Corona Virus",
        "Fort Myers",
        "FL",
        "12345",
        "123456789");
    personDialogB = new PersonDialog(jframe, testPerson);
  }

  /**
   *  This method tests the integration between
   *  this class and the person class by testing
   *  the getPerson() method.
   */
  @Test
  public void testGetPerson() {
    personDialogA.getPerson();

    verify(person).getFirstName();
    verify(person).getLastName();
    verify(person).getAddress();
    verify(person).getCity();
    verify(person).getState();
    verify(person).getZip();
    verify(person).getPhone();
  }

  @Test
  public void testGetPersonWithData() {
    Assert.assertEquals(testPerson, personDialogB.getPerson());
  }
}
