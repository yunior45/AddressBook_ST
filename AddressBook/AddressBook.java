package AddressBook;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AddressBook extends AbstractTableModel {
    // Variables
    private List<Person> persons = new ArrayList<>();

    // Methods

    /**
     * Returns the list of Persons in the address book.
     *
     * @return Array of Persons in this address book.
     */
    public Person[] getPersons() {
        return persons.toArray(new Person[persons.size()]);
    }

    /**
     * Adds a Person to the Address Book
     *
     * @param p Person to add.
     */
    public void add(Person p) {
        int newIndex = persons.size();
        persons.add(p);
        fireTableRowsInserted(newIndex, newIndex);
    }

    /**
     * Sets the person at the given index to the Person specified.
     *
     * @param index  Index to update.
     * @param person Person to replace the item with.
     */
    public void set(int index, Person person) {
        persons.set(index, person);
        fireTableRowsUpdated(index, index);
    }

    /**
     * Removes a person from the address book.
     *
     * @param index  Index of Person to remove.
     */
    public void remove(int index) {
        persons.remove(index);
        fireTableRowsDeleted(index, index);
    }

    /**
     * Returns a specific Person from the Address Book.
     *
     * @return Person of this AddressBook.
     * @param index  Index of Person to get.
     */
    public Person get(int index) {
        return persons.get(index);
    }

    /**
     * Clears this address book.
     */
    public void clear() {
        // If the address book is already empty, do nothing.
        if (persons == null || persons.size() == 0) {
            return;
        }
        fireTableRowsDeleted(0, persons.size() - 1);
        persons.clear();
    }

    /**
     * Gets number of rows in the address book table.
     *
     * @return Integer number of rows.
     */
    @Override
    public int getRowCount() {
        return persons.size();
    }

    /**
     * Gets number of columns in the address book table.
     *
     * @return Integer number of columns.
     */
    public int getColumnCount() {
        return Person.fields.length;
    }

    /**
     * Gets the value of the field at the specific row and column
     * of the address book table.
     *
     * @return Object field value of Person.
     * @param row Integer for row in the address book table.
     * @param column Integer for column in the address book table.
     */
    @Override
    public Object getValueAt(int row, int column) {
        return persons.get(row).getField(column);
    }

    /**
     * Returns the name of the column of the address book table.
     *
     * @return Name of the column.
     * @param column Integer for column in the address book table.
     */
    @Override
    public String getColumnName(int column) {
        return Person.fields[column];
    }
}