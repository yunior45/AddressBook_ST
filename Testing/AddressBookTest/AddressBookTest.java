package AddressBookTest;

import AddressBookTest.AddressBook;
import AddressBookTest.Person;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

  private AddressBook addressBook;

  private Person person1;
  private Person person2;
  private Person person3;

  @Before
  public void setUp() {
    addressBook = new AddressBook();
    person1 = new Person("Greg", "Lozada", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
    person2 = new Person("Kamp", "Duong", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
    person3 = new Person("Yunior", "Rivera", "1234 Name Ln", "Naples", "FL", "34109", "1234567890");
  }

  @Test
  public void testAddPerson() {
    Assert.assertEquals(0, addressBook.getPersons().length);
    addressBook.add(person1);
    Assert.assertEquals(1, addressBook.getPersons().length);
    addressBook.add(null);
    Assert.assertEquals(2, addressBook.getPersons().length);
  }

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
  }

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

  @Test
  public void testGet() {
    Assert.assertThrows(Exception.class, () -> {
      addressBook.get(0);
    });

    addressBook.add(person1);
    addressBook.add(person2);
    addressBook.add(person3);

    Assert.assertThrows(Exception.class, () -> {
      addressBook.get(-1);
    });

    Assert.assertEquals(person1, addressBook.get(0));
    Assert.assertEquals(person2, addressBook.get(1));
    Assert.assertEquals(person3, addressBook.get(2));

    Assert.assertThrows(Exception.class, () -> {
      addressBook.get(3);
    });
  }

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

  @Test
  public void testColumnCount() {
    Assert.assertEquals(7, addressBook.getColumnCount());
  }

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

  @Test
  public void testGetValue() {
    Assert.assertThrows(Exception.class, () -> {
      addressBook.getValueAt(0, 0);
    });

    addressBook.add(person1);
    addressBook.add(person2);
    addressBook.add(person3);

    Assert.assertThrows(Exception.class, () -> {
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

    Assert.assertThrows(Exception.class, () -> {
      addressBook.getValueAt(3, 0);
    });

    Assert.assertThrows(IllegalArgumentException.class, () -> {
      addressBook.getValueAt(0, 7);
    });
  }
}