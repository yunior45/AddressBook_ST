package IntegrationTesting;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import AddressBookTest.AddressBookController;
import AddressBookTest.FileSystem;
import AddressBookTest.AddressBook;
import AddressBookTest.Person;

public class AddressBookControllerIT {

  private AddressBookController testAddressBookController;
  private AddressBook addressBookMock;

  private Person personAMock;
  private Person personBMock;
  private Person personCMock;

  private FileSystem fileSystemMock;
  private File fileMock;

  @Before
  public void init() {
    personAMock = mock(Person.class);
    personBMock = mock(Person.class);
    personCMock = mock(Person.class);

    fileSystemMock = mock(FileSystem.class);
    fileMock = mock(File.class);

    addressBookMock = mock(AddressBook.class);
    // Creating Stubs
    when(addressBookMock.get(0)).thenReturn(personAMock);
    when(addressBookMock.get(1)).thenReturn(personBMock);
    when(addressBookMock.get(2)).thenReturn(personCMock);

    testAddressBookController =
        new AddressBookController(addressBookMock);
  }

  @Test
  public void testAddMethod() {
    testAddressBookController.add(personAMock);
    assertEquals(personAMock, testAddressBookController.get(0));

    verify(addressBookMock).add(personAMock);
  }

  @Test
  public void testSetMethod() {
    testAddressBookController.add(personCMock);
    testAddressBookController.set(1, personBMock);

    assertNotEquals(personCMock, testAddressBookController.get(1));
    assertEquals(personBMock, testAddressBookController.get(1));

    verify(addressBookMock).set(1, personBMock);
  }

  @Test
  public void testSaveMethod() throws SQLException, NullPointerException, FileNotFoundException {
    doThrow(new NullPointerException())
        .when(fileSystemMock).saveFile(addressBookMock, fileMock);

    try {
      testAddressBookController.save(fileMock);
    } catch (NullPointerException e) {}
  }

  @Test
  public void testGetModelMethod() {
    AddressBook testAddressBook;
    testAddressBook = testAddressBookController.getModel();

    assertEquals(testAddressBook, addressBookMock);
  }
}
