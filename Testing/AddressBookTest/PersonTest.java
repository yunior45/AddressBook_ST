package AddressBookTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    public final Person person = new Person(
            "Joe",
            "Gonzalez",
            "711 Hope St",
            "Hollywood",
            "FL",
            "33024",
            "3056952200"
    );

    @Test
    public void getFirstName() {
        assertEquals("Joe", person.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Gonzalez", person.getLastName());
    }

    @Test
    public void getAddress() {
        assertEquals("711 Hope St", person.getAddress());
    }

    @Test
    public void getCity() {
        assertEquals("Hollywood", person.getCity());
    }

    @Test
    public void getState() {
        assertEquals("FL", person.getState());
    }

    @Test
    public void getZip() {
        assertEquals("33024", person.getZip());
    }

    @Test
    public void getPhone() {
        assertEquals("3056952200", person.getPhone());
    }

    @Test
    public void testToString() {
        assertEquals("Gonzalez, Joe", person.toString());
    }

    @Test
    public void containsString() {
        String[] personArray = new String[]{
                "Joe",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "33024",
                "3056952200"
        };

    }

    @Test
    public void getField() {
        assertTrue(person.getField(0)=="Gonzalez");
        assertTrue(person.getField(1)=="Joe");
        assertTrue(person.getField(2)=="711 Hope St");
        assertTrue(person.getField(3)=="Hollywood");
        assertTrue(person.getField(4)=="FL");
        assertTrue(person.getField(5)=="33024");
        assertTrue(person.getField(6)=="3056952200");
    }

    @Test(expected=IllegalArgumentException.class)
    public void getFieldException(){
        assertTrue(person.getField(-1)=="Field number out of bounds");
        assertTrue(person.getField(7)=="Field number out of bounds");
    }
}