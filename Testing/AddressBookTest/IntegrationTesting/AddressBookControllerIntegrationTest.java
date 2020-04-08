package IntegrationTesting;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.isA;

import AddressBookTest.AddressBookController;
import AddressBookTest.AddressBook;
import AddressBookTest.Person;
import AddressBookTest.FileSystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class AddressBookControllerIntegrationTest {
  private AddressBookController addressBookController;

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

  @Test
  public void testAdd() {
    addressBookController.add(person);

    verify(addressBook).add(person);
  }

  @Test
  public void testSet() {
    addressBookController.set(1, person);

    verify(addressBook).set(1, person);
  }

  @Test
  public void testRemove(){
    addressBookController.remove(0);

    verify(addressBook).remove(0);
  }

  @Test
  public void testGet(){
    Assert.assertEquals(person, addressBookController.get(0));
  }

  @Test
  public void testClear(){
    addressBookController.clear();

    verify(addressBook).clear();
  }

  @Test(expected=FileNotFoundException.class)
  public void testOpenInvalidFile() throws FileNotFoundException, SQLException {
    addressBookController.open(invalidFile);
  }

  @Test
  public void testOpenValidFile() throws FileNotFoundException, SQLException {
    addressBookController.open(validFile);

    verify(addressBook).fireTableDataChanged();
  }

  @Test (expected = NullPointerException.class)
  public void testSave() throws SQLException, NullPointerException {
    addressBookController.save(validFile);
  }

  @Test
  public void testGetModel() {
    AddressBook testAddressBook;
    testAddressBook = addressBookController.getModel();

    assertEquals(testAddressBook, addressBook);
  }
}
