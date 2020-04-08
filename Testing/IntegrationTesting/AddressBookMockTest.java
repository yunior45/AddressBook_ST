package IntegrationTesting;


import AddressBookTest.AddressBook;
import AddressBookTest.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class AddressBookMockTest {
    AddressBook addressBookObj = new AddressBook();
    Person person1;
    Person person2;
    Person person3;

    @Before
    public void create(){
        person1 = mock(Person.class);
        person2 = mock(Person.class);
        person3 = mock(Person.class);
    }

    @Test
    public void testAdd(){

        //Error handling to ensure person objects have been implemented.
        doThrow(new RuntimeException("Person1 not implemented"))
                .when(person1).getField(0);
        doThrow(new RuntimeException("Person2 not implemented"))
                .when(person2).getField(1);
        doThrow(new RuntimeException("Person3 not implemented"))
                .when(person3).getField(0);

        /*
            Adding person1, Person2, and person 3 object into the address book then ensuring that
            the object was added correctly as well as the object is valid.
         */
        addressBookObj.add(person1);
        Assert.assertEquals(person1, addressBookObj.get(0));
        when(person1.getField(1)).thenReturn("First Name Test");
        addressBookObj.add(person2);
        Assert.assertEquals(person2, addressBookObj.get(1));
        when(person2.getField(0)).thenReturn("First Name Test");
        addressBookObj.add(person3);
        Assert.assertEquals(person3, addressBookObj.get(2));
        when(person3.getField(2)).thenReturn("address Test");

        //Ensuring that all three person objects were correctly added to the addressbook object.
        Assert.assertEquals(3,addressBookObj.getRowCount());
    }




}
