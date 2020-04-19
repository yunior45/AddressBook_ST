package AddressBook;

/***********************************************
 * Subject: AddressBook FileSystem test class
 * Course: CEN 4072 Software Testing
 * Author: Yunior Rivera
 * *********************************************/

import AddressBookTest.AddressBook;
import AddressBookTest.FileSystem;
import AddressBookTest.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;

import static org.junit.Assert.*;

public class FileSystemTest {

    @Test
    public void readFile() throws SQLException, FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        File testFile = new File("Resources/testAddressBook");
        Assert.assertNotNull(testFile);
        new FileSystem().readFile(addressBook, testFile);
        addressBook.fireTableDataChanged();
        Assert.assertNotNull(addressBook);
    }

    @Test (expected=FileNotFoundException.class)
    public void readFileNotFoundException() throws SQLException, FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        File testFile = new File("");
        new FileSystem().readFile(addressBook, testFile);
        Assert.assertTrue(!testFile.exists() || !testFile.canRead());
        addressBook.fireTableDataChanged();
        Assert.assertNull(addressBook);
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
        Assert.assertNotNull(addressBook);
        File testFile = new File("Resources/testAddressBook2");
        Assert.assertNotNull(testFile);
        new FileSystem().saveFile(addressBook, testFile);
        addressBook.add(p);
        new FileSystem().saveFile(addressBook, testFile);
    }
}