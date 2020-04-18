package IntegrationTesting;


import AddressBookTest.AddressBook;
import AddressBookTest.Person;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.internal.util.reflection.FieldSetter.*;

import static org.mockito.Mockito.*;

public class AddressBookIT {
    private AddressBook addressBookObj = new AddressBook();

    private Person person1;
    private Person person2;
    private Person person3;

    @Mock
    private List<Person> persons;

    @Before
    public void create() throws NoSuchFieldException{
        person1 = mock(Person.class);
        person2 = mock(Person.class);
        person3 = mock(Person.class);

        MockitoAnnotations.initMocks(this);

        FieldSetter setter = new FieldSetter(addressBookObj, addressBookObj.getClass().getDeclaredField("persons"));

        setter.set(persons);
    }

    @Test
    public void testGetPersons() {
        persons.add(person1);
        addressBookObj.getPersons();

        verify(persons).toArray(new Person[persons.size()]);
    }

    @Test
    public void testAdd(){
        addressBookObj.add(person1);

        verify(persons).add(person1);
    }

    @Test
    public void testSet(){
        addressBookObj.set(0, person1);

        verify(persons).set(0, person1);
    }

    @Test
    public void testRemove(){
        persons.add(person1);
        addressBookObj.remove(0);

        verify(persons).remove(0);
    }

    @Test
    public void testGet(){
        persons.add(person1);
        addressBookObj.get(0);

        verify(persons).get(0);
    }

    @Test
    public void testClear() {
        addressBookObj.clear();

        when(persons.size()).thenReturn(1);

        addressBookObj.clear();

        verify(persons, times(1)).clear();
    }

    @Test
    public void testGetRowCount() {
        addressBookObj.getRowCount();

        verify(persons).size();
    }


}
