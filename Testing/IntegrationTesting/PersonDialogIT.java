package Testing.IntegrationTesting;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import AddressBookTest.Person;
import GUI.PersonDialog;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;

public class PersonDialogIT {

  private PersonDialog personDialog;
  private JFrame jframe;
  private Person person;

  @Before
  public void setUp() {
    person = mock(Person.class);

    jframe = new JFrame();
    personDialog = new PersonDialog(jframe, person);
  }

  /**
   *  This method tests the integration between
   *  this class and the person class by testing
   *  the getPerson() method.
   */
  @Test
  public void testGetPerson() {
    personDialog.getPerson();

    verify(person).getFirstName();
    verify(person).getLastName();
    verify(person).getAddress();
    verify(person).getCity();
    verify(person).getState();
    verify(person).getZip();
    verify(person).getPhone();
  }
}
