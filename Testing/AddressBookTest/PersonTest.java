package AddressBookTest;

    import org.junit.Test;

    import java.util.regex.Pattern;

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

    @Test(expected=IllegalArgumentException.class)
    public void PersonFirstNameException(){
        Person personException = new Person(
            "",
            "Gonzalez",
            "711 Hope St",
            "Hollywood",
            "FL",
            "33024",
            "3056952200"
        );
        assertEquals("First name cannot be empty", personException.getFirstName());
    }

    @Test(expected=IllegalArgumentException.class)
    public void PersonLastNameException(){
        Person personException = new Person(
            "Joe",
            "",
            "711 Hope St",
            "Hollywood",
            "FL",
            "33024",
            "3056952200"
        );
        assertEquals("Last name cannot be empty", personException.getLastName());
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

        int caseCounter=0;
        String field;
        int caseCounterFields=0;
        String matcherField;


        while(caseCounter<7){

            switch(caseCounterFields){
                case 0:
                    matcherField = person.getFirstName();
                    break;
                case 1:
                    matcherField = person.getLastName();
                    break;
                case 2:
                    matcherField = person.getAddress();
                    break;
                case 3:
                    matcherField = person.getCity();
                    break;
                case 4:
                    matcherField = person.getState();
                    break;
                case 5:
                    matcherField = person.getZip();
                    break;
                case 6:
                    matcherField = person.getPhone();
                    break;
                default:
                    matcherField = "Invalid";
                    break;
            }

            switch (caseCounter) {
                case 0:
                    field = "Joe";
                    break;
                case 1:
                    field = "Gonzalez";
                    break;
                case 2:
                    field = "711 Hope St";
                    break;
                case 3:
                    field = "Hollywood";
                    break;
                case 4:
                    field = "FL";
                    break;
                case 5:
                    field = "33024";
                    break;
                case 6:
                    field = "3056952200";
                    break;
                default:
                    field = "Invalid";
                    break;
            }
            Pattern p = Pattern.compile(Pattern.quote(field), Pattern.CASE_INSENSITIVE);
            assertTrue(personArray[caseCounter], p.matcher(matcherField).find());
            caseCounter++;
            caseCounterFields++;
        }
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