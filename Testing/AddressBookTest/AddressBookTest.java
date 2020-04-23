package AddressBookTest;

import AddressBookTest.AddressBook;
import AddressBookTest.Person;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class AddressBookTest {

  private AddressBook addressBook;

  private Person person1;
  private Person person2;
  private Person person3;

  /**
   * Method: setUp()
   * Summary: The setUp() method is responsible for creating the different objects that will
   *          be used throughout the different test methods.
   */
  @Before
  public void setUp() {
    addressBook = new AddressBook();
    person1 = new Person("Greg", "Lozada", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
    person2 = new Person("Kamp", "Duong", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
    person3 = new Person("Yunior", "Rivera", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
  }

  /**
   * Method: testAddPerson()
   * Summary: The testAddPerson() method tests the functionalities of adding a person to the
   *          address book directly. A Person Object is inputted into the addressbook and then
   *          retrieved using the get() method within the AddressBook class. The results are
   *          then asserted to equal the person object that was created. Exception handling is
   *          also tested where if an attempt to enter an invalid person, a NullPointerException
   *          is thrown.
   */
  @Test
  public void testAddPerson() {
    addressBook.add(person1);
    Assert.assertEquals(person1, addressBook.get(0));

    Assert.assertThrows(NullPointerException.class, () -> {
      addressBook.add(null);
    });
  }

  /**
   * Method: testSet()
   * Summary: The testSet() method tests the functionalities of setting a person within
   *          the addressbook. A person object is added to the addressbook then asserted
   *          that the person object set at the index specified is the same as the person
   *          object created. Exception handling is also done by testing an index input
   *          of 0 when there is no one, -1 as an invalid index, 2 when there is a different
   *          person stored there, and 1 with a null object.
   */
  @Test
  public void testSet() {
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.set(0, person1);
    });

    addressBook.add(person1);
    addressBook.add(person2);

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.set(-1, person1);
    });

    addressBook.set(1, person3);
    Assert.assertEquals(person3, addressBook.get(1));

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.set(2, person1);
    });

    Assert.assertThrows(NullPointerException.class, () -> {
      addressBook.set(1, null);
    });
  }

  /**
   * Method: testRemove()
   * Summary: The testRemove() method tests the remove functionalities of the addressbook
   *          application. 3 person objects are added to the addressbook, then person
   *          at index 1 is removed. The person is retrieved through the get() method within
   *          the addressbook class and compared with an addressbook created to assert that
   *          both are equal. Exception handling testing is done by testing removing an object
   *          from an empty addressbook, removing an invalid index from addressbook. and removing
   *          an empty index from a addressbook containin people.
   */
  @Test
  public void testRemove() {
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.remove(0);
    });

    addressBook.add(person1);
    addressBook.add(person2);
    addressBook.add(person3);

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.remove(-1);
    });

    addressBook.remove(1);
    Assert.assertEquals(person3, addressBook.get(1));

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.remove(2);
    });
  }
  /**
   * Method: testGet()
   * Summary: The testGet() method tests the functionalities to retieve a person object.
   *          3 person objects are added to the addressbook then retrieved using the get() function.
   *          the results are then asserted to equal the person objects created. Exception handling
   *          is tested by testing get() from an index on an empty addressbook, testing get() from an
   *          invalid index, and testing get() at an index that is larger then the number of objects in
   *          the addressbook.
   */
  @Test
  public void testGet() {
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.get(0);
    });

    addressBook.add(person1);
    addressBook.add(person2);
    addressBook.add(person3);

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.get(-1);
    });

    Assert.assertEquals(person1, addressBook.get(0));
    Assert.assertEquals(person2, addressBook.get(1));
    Assert.assertEquals(person3, addressBook.get(2));

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.get(3);
    });
  }

  /**
   * Method: testClear()
   * Summary: The clear() method tests the clear functionalities of the addressbook
   *          application. 3 person objects are added to the addressbook through
   *          the addressbookcontroller and is asserted that there are 3 people within
   *          the addressbook. The addressbook is then cleared and then asserted that
   *          there are no people within the addressbook.
   */
  @Test
  public void testClear() {
    Assert.assertEquals(0, addressBook.getPersons().length);

    addressBook.add(person1);
    addressBook.add(person2);
    addressBook.add(person3);

    Assert.assertEquals(3, addressBook.getPersons().length);

    addressBook.clear();
    Assert.assertEquals(0, addressBook.getPersons().length);

    addressBook.clear();
    Assert.assertEquals(0, addressBook.getPersons().length);
  }

  /**
   * Method: testRowCount()
   * Summary: The testRowCount() tests the functionalities of returning a number of rows
   *          from the addressbook. Person objects are added into the addressbook and
   *          then asserted that the number of objects added is the same as the asserted
   *          value.
   */
  @Test
  public void testRowCount() {
    Assert.assertEquals(0, addressBook.getRowCount());

    addressBook.add(person1);
    Assert.assertEquals(1, addressBook.getRowCount());

    addressBook.add(person2);
    Assert.assertEquals(2, addressBook.getRowCount());

    addressBook.remove(0);
    Assert.assertEquals(1, addressBook.getRowCount());
  }

  /**
   * Method: testColumnCount()
   * Summary: the TestColumnCount() method test the functionalities of returning the number
   *          of columns witin the addressbook. it is asserted that the number of columns
   *          in the addressbook.
   */
  @Test
  public void testColumnCount() {
    Assert.assertEquals(7, addressBook.getColumnCount());
  }

  /**
   * Method: testColumnName()
   * Summary: The testColumnName() method tests the functionalities of returning the different
   *          column names from the addresssbook. it is asserted that each column name returned
   *          matches the given value.
   */
  @Test
  public void testColumnName() {
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.getColumnName(-1);
    });

    Assert.assertEquals("Last Name", addressBook.getColumnName(0));
    Assert.assertEquals("First Name", addressBook.getColumnName(1));
    Assert.assertEquals("Address", addressBook.getColumnName(2));
    Assert.assertEquals("City", addressBook.getColumnName(3));
    Assert.assertEquals("State", addressBook.getColumnName(4));
    Assert.assertEquals("ZIP", addressBook.getColumnName(5));
    Assert.assertEquals("Phone", addressBook.getColumnName(6));

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.getColumnName(7);
    });
  }

  /**
   * Method: testGetValue()
   * Summary: The testGetValue() method tests the functionalities of returning a value from an
   *          addressbook. Person objects are added to the addressbook and then asserted that they
   *          equal the given value. Exception handling is tested as well for invalid row and columns.
   */
  @Test
  public void testGetValue() {
    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.getValueAt(0, 0);
    });

    addressBook.add(person1);
    addressBook.add(person2);
    addressBook.add(person3);

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.getValueAt(-1, 0);
    });

    Assert.assertThrows(IllegalArgumentException.class, () -> {
      addressBook.getValueAt(0, -1);
    });

    Assert.assertEquals("Lozada", addressBook.getValueAt(0, 0));
    Assert.assertEquals("Greg", addressBook.getValueAt(0, 1));
    Assert.assertEquals("1234 Name Ln", addressBook.getValueAt(0, 2));
    Assert.assertEquals("Naples", addressBook.getValueAt(0, 3));
    Assert.assertEquals("FL", addressBook.getValueAt(0, 4));
    Assert.assertEquals("34109", addressBook.getValueAt(0, 5));
    Assert.assertEquals("1234567890", addressBook.getValueAt(0, 6));

    Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
      addressBook.getValueAt(3, 0);
    });

    Assert.assertThrows(IllegalArgumentException.class, () -> {
      addressBook.getValueAt(0, 7);
    });
  }
}