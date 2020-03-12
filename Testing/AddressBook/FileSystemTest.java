package AddressBook;

/***********************************************
 * Subject: AddressBook FileSystem test class
 * Course: CEN 4072 Software Testing
 * Author: Yunior Rivera
 * *********************************************/

import AddressBookTest.AddressBook;
import AddressBookTest.FileSystem;
import AddressBookTest.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;

import static org.junit.Assert.*;

public class FileSystemTest {

    @Test
    public void readFile() throws SQLException, FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        assertNotNull(addressBook);
        File testFile = new File("Resources/testAddressBook");
        assertNotNull(testFile);
        new FileSystem().readFile(addressBook, testFile);
        addressBook.fireTableDataChanged();
    }

    @Test (expected=FileNotFoundException.class)
    public void readFileNotFoundException() throws SQLException, FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        assertNotNull(addressBook);
        File testFile = new File("");
        new FileSystem().readFile(addressBook, testFile);
        assertTrue(!testFile.exists() || !testFile.canRead());
        addressBook.fireTableDataChanged();
    }

    @Test
    public void saveFile() throws SQLException {
        Person p = new Person(
                "Joe",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "33024",
                "3056952200"
        );
        AddressBook addressBook = new AddressBook();
        assertNotNull(addressBook);
        File testFile = new File("Resources/testAddressBook2");
        assertNotNull(testFile);
        new FileSystem().saveFile(addressBook, testFile);
        addressBook.add(p);
        new FileSystem().saveFile(addressBook, testFile);
    }
}