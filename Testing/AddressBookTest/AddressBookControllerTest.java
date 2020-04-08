import static org.junit.Assert.*;

import AddressBookTest.AddressBook;
import AddressBookTest.AddressBookController;
import AddressBookTest.Person;
import org.junit.Test;

public class AddressBookControllerTest {
  private Person testPersonA;
  private Person testPersonB;
  private AddressBook testAddressBook;
  private AddressBookController testAddressBookController;

  private void buildTestData(){
    // Building test data.
    testPersonA = new Person("John","Doe","123 Main St",
        "Atlanta","GA","12345","555-555-5555");
    testPersonB = new Person("Gary","Oak","456 Blvd",
        "Pallet Town","Kanto","09876","098-765-4321");
    testAddressBook = new AddressBook();
    testAddressBookController = new AddressBookController(testAddressBook);
  }

  @Test
  public void add() {
    buildTestData();

    // Running the target method.
    testAddressBookController.add(testPersonA);

    // Creating result.
    Person result = testAddressBookController.getModel().get(0);

    // Testing results.
    assertEquals(testPersonA, result);
  }


  @Test
  public void get() {
    buildTestData();
    testAddressBookController.add(testPersonA);

    // Testing method.
    Person result = testAddressBookController.get(0);

    // Test for equivalence.
    assertEquals(testPersonA, result);
  }

  @Test
  public void getModel() {
    buildTestData();
    testAddressBookController.add(testPersonA);

    // Testing method.
    AddressBook result = testAddressBookController.getModel();

    // Creating expected result.
    testAddressBook.add(testPersonA);

    // Test for equivalence.
    assertEquals(testAddressBook, result);
  }

  @Test
  public void set() {
    buildTestData();
    testAddressBookController.add(testPersonA);

    // Testing method.
    testAddressBookController.set(0, testPersonB);

    // Creating expected result.
    Person result = testAddressBookController.get(0);

    // Test for equivalence.
    assertEquals(testPersonB, result);
  }

  @Test
  public void remove() {
    buildTestData();
    testAddressBook.add(testPersonB);
    testAddressBookController.add(testPersonA);
    testAddressBookController.add(testPersonB);

    // Testing method.
    testAddressBookController.remove(0);

    // Creating expected result.
    AddressBook result = testAddressBookController.getModel();

    // Test for equivalence.
    assertEquals(testAddressBook, result);
  }

  @Test
  public void clear() {
    buildTestData();
    testAddressBookController.add(testPersonA);
    testAddressBookController.add(testPersonB);

    assertEquals(2, testAddressBookController.getModel().getRowCount());

    // Testing method.
    testAddressBookController.clear();

    // Test for equivalence.
    assertEquals(0, testAddressBookController.getModel().getRowCount());


    testAddressBookController.clear();
    assertEquals(0, testAddressBookController.getModel().getRowCount());
  }
}