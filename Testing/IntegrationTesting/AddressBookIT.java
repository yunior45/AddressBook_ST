package IntegrationTesting;


import AddressBook.AddressBook;
import AddressBook.Person;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;

import static org.mockito.Mockito.*;

public class AddressBookIT {
    // Test Variables
    private AddressBook addressBookObj = new AddressBook();

    private Person person1;
    private Person person2;
    private Person person3;

    // Mocks
    @Mock
    private List<Person> persons;

    // Test Method

    /**
     * Setup method to create dependencies and objects needed for tests.
     */
    @Before
    public void create() throws NoSuchFieldException{
        person1 = mock(Person.class);
        person2 = mock(Person.class);
        person3 = mock(Person.class);

        MockitoAnnotations.initMocks(this);

        FieldSetter setter = new FieldSetter(addressBookObj, addressBookObj.getClass().getDeclaredField("persons"));

        setter.set(persons);
    }

    /**
     * Test for getPersons() method.
     *
     * 1. Add a person
     * 2. Call getPersons()
     * 3. Verify the method run.
     */
    @Test
    public void testGetPersons() {
        persons.add(person1);
        addressBookObj.getPersons();

        verify(persons).toArray(new Person[persons.size()]);
    }

    /**
     * Test for add() method.
     *
     * 1. Call add()
     * 2. Verify the method was called once.
     */
    @Test
    public void testAdd(){
        addressBookObj.add(person1);

        verify(persons).add(person1);
    }

    /**
     * Test for set() method.
     *
     * 1. Call set()
     * 2. Verify the method was called once.
     */
    @Test
    public void testSet(){
        addressBookObj.set(0, person1);

        verify(persons).set(0, person1);
    }

    /**
     * Test for remove() method.
     *
     * 1. Call remove()
     * 2. Verify the method was called once.
     */
    @Test
    public void testRemove(){
        persons.add(person1);
        addressBookObj.remove(0);

        verify(persons).remove(0);
    }

    /**
     * Test for get() method.
     *
     * 1. Call get()
     * 2. Verify the method was called once.
     */
    @Test
    public void testGet(){
        persons.add(person1);
        addressBookObj.get(0);

        verify(persons).get(0);
    }

    /**
     * Test for clear() method.
     *
     * 1. Call clear()
     * 2. Check size of persons array list.
     * 3. Call clear() again.
     * 4. Verify the method was called once.
     */
    @Test
    public void testClear() {
        addressBookObj.clear();

        when(persons.size()).thenReturn(1);

        addressBookObj.clear();

        verify(persons, times(1)).clear();
    }

    /**
     * Test for getRowCount() method.
     * Number of rows is the same as
     *      number of persons in the address book.
     *
     * 1. Call getRowCount()
     * 2. Verify the size of the person array list.
     */
    @Test
    public void testGetRowCount() {
        addressBookObj.getRowCount();

        verify(persons).size();
    }
}