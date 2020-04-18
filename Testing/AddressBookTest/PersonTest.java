package AddressBookTest;

/***********************************************
 * Subject: AddressBook FileSystem test class
 * Course: CEN 4072 Software Testing
 * Author: Yunior Rivera
 * *********************************************/


import AddressBookTest.AddressBook;
    import AddressBookTest.Person;
import org.junit.Assert;
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
    public void PersonFirstNameException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                "",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "33024",
                "3056952200"
            );
        });

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                null,
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "33024",
                "3056952200"
            );
        });
    }

    @Test
    public void PersonLastNameException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                "Joe",
                "",
                "711 Hope St",
                "Hollywood",
                "FL",
                "33024",
                "3056952200"
            );
        });

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                "Joe",
                null,
                "711 Hope St",
                "Hollywood",
                "FL",
                "33024",
                "3056952200"
            );
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

        int i;
        for(i=0;i<7;i++){
            assertTrue(person.containsString(personArray[i]));
        }

        assertTrue(!person.containsString("Greg"));
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

    @Test(expected=IllegalArgumentException.class)
    public void getFieldException(){
        assertTrue(person.getField(-1)=="Field number out of bounds");
        assertTrue(person.getField(7)=="Field number out of bounds");
    }
}