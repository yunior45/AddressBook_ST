import AddressBookTest.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private final Person person = new Person(
            "Joe",
            "Gonzalez",
            "711 Hope St",
            "Hollywood",
            "FL",
            "33024",
            "3056952200"
    );

    @Test
    public void testPersonException(){
        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person(null, null, "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person(null, "", "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person(null, "Lozada", "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person("", null, "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person("", "", "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person("", "Lozada", "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person("Greg", null, "", "", "", "", "");
        });

        assertThrows(IllegalArgumentException.class, () ->{
            Person person_test = new Person("Greg", "", "", "", "", "", "");
        });
    }

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

        assertTrue(person.containsString("Joe"));
        assertTrue(person.containsString("joe"));
        assertFalse(person.containsString("123"));
        assertThrows(NullPointerException.class, () ->{
            person.containsString(null);
        });
    }

    @Test
    public void getField() {
        assertEquals("Gonzalez", person.getField(0));
        assertEquals("Joe", person.getField(1));
        assertEquals("711 Hope St", person.getField(2));
        assertEquals("Hollywood", person.getField(3));
        assertEquals("FL", person.getField(4));
        assertEquals("33024", person.getField(5));
        assertEquals("3056952200", person.getField(6));
    }

    @Test
    public void getFieldException(){
        assertThrows(IllegalArgumentException.class, () -> {
            person.getField(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            person.getField(7);
        });
    }
}