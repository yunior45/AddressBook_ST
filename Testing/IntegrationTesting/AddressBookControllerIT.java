package Testing.IntegrationTesting;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import AddressBookTest.AddressBook;
import AddressBookTest.AddressBookController;
import AddressBookTest.FileSystem;
import AddressBookTest.Person;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AddressBookControllerIT {
  private AddressBookController addressBookController;

  // Mocks to be used throughout the AddressBookControllerIT class for integration testing
  @Mock
  AddressBook addressBook;
  @Mock
  Person person;
  @Mock
  FileSystem fileSystem;
  @Mock
  File invalidFile;
  @Mock
  File validFile;

  /**
   * Method: init()
   * Summary: The init() method initializes the individual mocks that are used throughout the AddressBookControllerIT
   *          class. Objects are also initialized throughout the test class.
   */
  @Before
  public void init() {
    addressBook = mock(AddressBook.class);
    fileSystem = mock(FileSystem.class);
    person = mock(Person.class);
    invalidFile = mock(File.class);
    validFile = mock(File.class);

    when(addressBook.get(0)).thenReturn(person);
    when(validFile.exists()).thenReturn(true);
    when(validFile.canRead()).thenReturn(true);

    addressBookController = new AddressBookController(addressBook);
  }

  /**
   * Method: testAdd()
   * Summary: The testAdd() method tests the integration of the addressbookcontroller and the addressbook class
   *          for adding a person object within a certain index within an addressbook.
   */
  @Test
  public void testAdd() {
    addressBookController.add(person);

    verify(addressBook).add(person);
  }

  /**
   * Method: testSet()
   * Summary: The testSet() method tests the integration of the addressbookcontroller and the addressbook class
   *          for setting a person object within a certain index within an addressbook.
   */
  @Test
  public void testSet() {
    addressBookController.set(1, person);

    verify(addressBook).set(1, person);
  }

  /**
   * Method: testRemove()
   * Summary: The testRemove() method tests the integration of the addressbookcontroller and the addressbook class
   *          for removing a person from the addressbook.
   */
  @Test
  public void testRemove(){
    addressBookController.remove(0);

    verify(addressBook).remove(0);
  }

  /**
   * Method:  testGet()
   * Summary: The testGet() method tests the integration of the addressbookcontroller and the person class
   *          to retrieve a person object from the addressbook.
   */
  @Test
  public void testGet(){
    Assert.assertEquals(person, addressBookController.get(0));
  }

  /**
   * Method: testClear()
   * Summary: The testClear() method tests the integration of the addressbookcontroller and addressbook class
   *          for clearing the addressbook.
   */
  @Test
  public void testClear(){
    addressBookController.clear();

    verify(addressBook).clear();
  }

  /**
   * Method: testOpenInvalidFileDoesNotExist()
   * Summary: The testOpenInvalidFileDoesNotExist() method tests the integration of the addressbookcontroller and
   *          FileSystem class for attempting for opening an invalid file.
   */
  @Test(expected=FileNotFoundException.class)
  public void testOpenInvalidFileDoesNotExist() throws FileNotFoundException, SQLException {
    addressBookController.open(invalidFile);
  }

  /**
   * Method: testOpenInvalidFileCannotRead()
   * Summary: The testOpenInvalidFileCannotRead() method tests the integration of the addressbookcontroller and
   *          FileSystem class for attempting for reading an invalid file.
   */
  @Test(expected=FileNotFoundException.class)
  public void testOpenInvalidFileCannotRead() throws FileNotFoundException, SQLException {
    when(invalidFile.exists()).thenReturn(true);

    addressBookController.open(invalidFile);
  }

  /**
   * Method: testOpenValidFile()
   * Summary: The testOpenValidFile() method tests the integration of the addressbookcontroller and
   *          FileSystem class for opening a valid file.
   */
  @Test
  public void testOpenValidFile() throws FileNotFoundException, SQLException {
    addressBookController.open(validFile);

    verify(addressBook).fireTableDataChanged();
  }

  /**
   * Method: testSave()
   * Summary: The testSave() method tests the integration of the addressbookcontroller and
   *          addressbook class of saving an addressbook.
   */
  @Test (expected = NullPointerException.class)
  public void testSave() throws SQLException, NullPointerException {
    addressBookController.save(validFile);
  }

  /**
   * Method: testGetModel()
   * Summary: The testGetModel() method tests the integration between the addressbookcontroller and
   *          addressbook class of retrieving an addressbook.
   */
  @Test
  public void testGetModel() {
    AddressBook testAddressBook;
    testAddressBook = addressBookController.getModel();

    assertEquals(testAddressBook, addressBook);
  }
}
