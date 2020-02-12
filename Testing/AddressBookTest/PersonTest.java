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
        assertEquals("33024", person.getState());
    }

    @Test
    public void getPhone() {
        assertEquals("3056952200", person.getState());
    }

    @Test
    public void testToString() {
        assertEquals("Gonzalez, Joe", person.toString());
    }

    @Test
    public void containsString() {

    }

    @Test
    public void getField() {
    }
}