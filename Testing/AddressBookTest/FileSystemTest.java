/***********************************************
 * Subject: AddressBook FileSystem test class
 * Course: CEN 4072 Software Testing
 * Author: Yunior Rivera
 * *********************************************/

package Testing.AddressBookTest;


import AddressBook.AddressBook;
import AddressBook.FileSystem;
import AddressBook.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;

import static org.junit.Assert.*;

public class FileSystemTest {

    /**
     * Method: readFile()
     * Summary: The readFile() method tests the functionalities of an addressbook to be
     *          loaded within the addressbook program. An addressbook with a valid file
     *          path is attempted to be opened and asserted that it opens.
     *
     * @throws SQLException
     * @throws FileNotFoundException
     */
    @Test
    public void readFile() throws SQLException, FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        assertNotNull(addressBook);
        File testFile = new File("Resources/testAddressBook");
        assertNotNull(testFile);
        new FileSystem().readFile(addressBook, testFile);
        addressBook.fireTableDataChanged();
    }

    /**
     * Method: readFileNotFoundException()
     * Summary: The readFileNotFoundException() method tests exception handling for reading an
     *          invalid file path. An addressbook with an invalid path is attempted to be open
     *          and is expected to throw a FileNotFoundException.
     *
     * @throws SQLException
     * @throws FileNotFoundException
     */
    @Test(expected = FileNotFoundException.class)
    public void readFileNotFoundException() throws SQLException, FileNotFoundException {
        AddressBook addressBook = new AddressBook();
        assertNotNull(addressBook);
        File testFile = new File("");
        assertTrue(!testFile.exists() || !testFile.canRead());
        new FileSystem().readFile(addressBook, testFile);
        addressBook.fireTableDataChanged();
    }

    /**
     * Method: saveFile()
     * Summary: The saveFile() method tests the functionalities of saving an addressbook in the
     *          application. A person object is added to an addressbook then it is saved. that address
     *          book is then asserted that it contains data.
     *
     * @throws SQLException
     */
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