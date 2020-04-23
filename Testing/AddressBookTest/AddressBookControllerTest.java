package AddressBookTest;

import static org.junit.Assert.*;

import AddressBookTest.AddressBook;
import AddressBookTest.AddressBookController;
import AddressBookTest.Person;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookControllerTest {
  private Person testPersonA;
  private Person testPersonB;
  private AddressBook testAddressBook;
  private AddressBookController testAddressBookController;

  /**
   * Method: BuildTestData()
   * Summary: The BuildTestData() method prepares the objects that are to be used
   *          with the tests within the AddressBookControllerTest class.
   */
  private void buildTestData(){
    // Building test data.
    testPersonA = new Person("John","Doe","123 Main St",
        "Atlanta","GA","12345","555-555-5555");
    testPersonB = new Person("Gary","Oak","456 Blvd",
        "Pallet Town","Kanto","09876","098-765-4321");
    testAddressBook = new AddressBook();
    testAddressBookController = new AddressBookController(testAddressBook);
  }

  /**
   * Method: Add()
   * Summary: The add() method tests the functionalities of adding a person to the
   *          address book through the addressbookcontroller. A Person Object is inputted
   *          into the addressbookcontroller and then retrieved using the getModel() method
   *          within the AddressBookController class. The results are then asserted to equal
   *          the person object that was created.
   */
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

  /**
   * Method: get()
   * Summary: The get() method tests the functionalities to retieve a person object.
   *          a person is added to the addressbook then retrieved using the get() function.
   *          the results are then asserted to equal the person object created.
   */
  @Test
  public void get() {
    buildTestData();
    testAddressBookController.add(testPersonA);

    // Testing method.
    Person result = testAddressBookController.get(0);

    // Test for equivalence.
    assertEquals(testPersonA, result);


  }

  /**
   * Method: getModel()
   * Summary: The getModel() method tests the functionalities of retrieving an
   *          an addressbook. a Person is added to the addressbook then getModel()
   *          is called by the addressbook controller to retrieve the addressbook.
   *          the results are then compared with the addressbook object created to
   *          assert that they are equal.
   */
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

  /**
   * Method: set()
   * Summary: The set() method tests the functionalities of setting a person within
   *          the addressbook. A person object is added to the addressbook through
   *          an addressbookcontroller. Another person object is set at index 0 then
   *          retrieved from that index from the addressbook. The person object retrieved
   *          is then compared to the person object created.
   */
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

  /**
   * Method: remove()
   * Summary: The remove() method tests the remove functionalities of the addressbook
   *          application. 3 person objects are added to the addressbook, then person
   *          at index 0 is removed. The addressbook is retrieved through the controller
   *          and then compared with an addressbook created to assert that both are equal.
   */
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

  /**
   * Method: clear()
   * Summary: The clear() method tests the clear functionalities of the addressbook
   *          application. Two person objects are added to the addressbook through
   *          the addressbookcontroller and is asserted that there are 2 people within
   *          the addressbook. The addressbook is then cleared and then asserted that
   *          there are no people within the addressbook.
   */
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

  /**
   * Method: open()
   * Summary: The open() method tests the file open functionalities for the addressbook
   *          application. The method tests the Exception handling the opening a file.
   *          first, it is asserted that when a null file is opened, a NullPointerException
   *          is thrown. Then, an empty file path is opened, a FileNotFoundException is
   *          thrown.
   */
  @Test
  public void open() {
    buildTestData();

    Assert.assertThrows(NullPointerException.class, () -> {
      testAddressBookController.open(null);
    });

    Assert.assertThrows(FileNotFoundException.class, () -> {
      testAddressBookController.open(new File(""));
    });
  }
}