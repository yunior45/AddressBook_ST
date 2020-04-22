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

// The Class is the unit test for the Person class.
public class PersonTest {

    // Dummy Person Object to be used in each test case.
    private final Person person = new Person(
        "Joe",
        "Gonzalez",
        "711 Hope St",
        "Hollywood",
        "FL",
        "33024",
        "3056952200"
    );

    /*
     * Test that the IllegalArgumentException is thrown when an
     * empty string or null is used as the firstName parameter of the Person object.
     */
    @Test
    public void PersonFirstNameException() {
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

    /*
     * Test that the IllegalArgumentException is thrown when an
     * empty string or null is used as the lastName parameter of the Person object.
     */
    @Test
    public void PersonLastNameException() {
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


    /*
     * Test that an exception is thrown when String used for
     * the zip parameter of the Person object is neither of length 5 or 0
     *
     * Valid Inputs: length == 0, length == 5
     * Invalid Inputs: null String, length > 0 && < 5, length > 5
     * Test inputs: null, 1-char string, 4-char String, 6-char String.
     */
    @Test
    public void PersonZipInvalidInputs() {
        Assert.assertThrows(NullPointerException.class, () -> {
            Person personException = new Person(
                "Joe",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                null,
                "3056952200"
            );
        });

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                "Joe",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "1",
                "3056952200"
            );
        });

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                "Joe",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "1234",
                "3056952200"
            );
        });

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            Person personException = new Person(
                "Joe",
                "Gonzalez",
                "711 Hope St",
                "Hollywood",
                "FL",
                "123456",
                "3056952200"
            );
        });
    }

    /*
     * Test that no exception is thrown and that the valid inputs
     * for zip successfully creates a Person object.
    */
    @Test
    public void PersonZipValidInputs() {
       Person personWithNoZip = new Person(
            "Joe",
            "Gonzalez",
            "711 Hope St",
            "Hollywood",
            "FL",
            "",
            "3056952200"
        );

        Person personWith5CharacterZip = new Person(
            "Joe",
            "Gonzalez",
            "711 Hope St",
            "Hollywood",
            "FL",
            "12345",
            "3056952200"
        );
    }

    // Test that the getFirstName() method returns the correct field.
    @Test
    public void getFirstName() {
        assertEquals("Joe", person.getFirstName());
    }

    // Test that the getLastName() method returns the correct field.
    @Test
    public void getLastName() {
        assertEquals("Gonzalez", person.getLastName());
    }

    // Test that the getAddress() method returns the correct field.
    @Test
    public void getAddress() {
        assertEquals("711 Hope St", person.getAddress());
    }

    // Test that the getCity() method returns the correct field.
    @Test
    public void getCity() {
        assertEquals("Hollywood", person.getCity());
    }

    // Test that the getState() method returns the correct field.
    @Test
    public void getState() {
        assertEquals("FL", person.getState());
    }

    // Test that the getZip() method returns the correct field.
    @Test
    public void getZip() {
        assertEquals("33024", person.getZip());
    }

    // Test that the getPhone() method returns the correct field.
    @Test
    public void getPhone() {
        assertEquals("3056952200", person.getPhone());
    }

    // Test that the toString() method returns the correct string.
    @Test
    public void testToString() {
        assertEquals("Gonzalez, Joe", person.toString());
    }

    /*
     * Test that the containsString() method returns true if any field
     * contains the input String and false if no match was found in any field.
     */
    @Test
    public void containsString() {
        String[] personArray = new String[]{
            "Jo", "Go", "71", "Holly", "FL", "330", "695"
        };

        for (String field: personArray) {
            assertTrue(person.containsString(field));
        }

        assertFalse(person.containsString("Greg"));
    }

    /*
     * Test that the getField() method returns the expected field values that
     * corresponds to the index argument and tests that the index is within the
     * bounds of valid inputs.
     * Valid inputs: index >= 0, index <= 6
     * Invalid inputs: index < 0, index > 6
    */
    @Test
    public void getField() {
        // Testing valid inputs
        assertEquals("Gonzalez", person.getField(0));
        assertEquals("Joe", person.getField(1));
        assertEquals("711 Hope St", person.getField(2));
        assertEquals("Hollywood", person.getField(3));
        assertEquals("FL", person.getField(4));
        assertEquals("33024", person.getField(5));
        assertEquals("3056952200", person.getField(6));

        // Testing invalid inputs
        assertThrows(IllegalArgumentException.class, () -> person.getField(-1));
        assertThrows(IllegalArgumentException.class, () -> person.getField(7));
    }
}