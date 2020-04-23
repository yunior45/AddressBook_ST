package AddressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class AddressBookController {
    // Variables
    AddressBook addressBook;

    // Methods

    /**
     * Class Constructor
     *
     * @param addressBook AddressBook to assign as the address book.
     */
    public AddressBookController(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a Person to the Address Book
     *
     * @param p Person to add.
     */
    public void add(Person p) {
        addressBook.add(p);
    }

    /**
     * Sets the person at the given index to the Person specified.
     *
     * @param index  Index to update.
     * @param person Person to replace the item with.
     */
    public void set(int index, Person person) {
        addressBook.set(index, person);
    }

    /**
     * Removes a person from the address book.
     *
     * @param index  Index of Person to remove.
     */
    public void remove(int index) {
        addressBook.remove(index);
    }

    /**
     * Returns a specific Person from the Address Book.
     *
     * @return Person of this AddressBook.
     * @param index  Index of Person to get.
     */
    public Person get(int index) {
        return addressBook.get(index);
    }

    /**
     * Clears this address book.
     */
    public void clear() {
        addressBook.clear();
    }

    /**
     * Loads a saved address book from the database.
     *
     * @param file File of the Database to read.
     */
    public void open(File file) throws FileNotFoundException, SQLException {
        new FileSystem().readFile(addressBook, file);
        addressBook.fireTableDataChanged();
    }

    /**
     * Save the address book to the database.
     *
     * @param file File of the Database to save to.
     */
    public void save(File file) throws SQLException {
        new FileSystem().saveFile(addressBook, file);
    }


    /**
     * Gets the Address Book.
     *
     * @return AddressBook of this class.
     */
    public AddressBook getModel() {
        return addressBook;
    }
}