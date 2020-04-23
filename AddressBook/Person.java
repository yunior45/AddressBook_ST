package AddressBook;

import java.util.regex.Pattern;

public class Person {
    // Variables
    public static final String[] fields =
            {
                    "Last Name",
                    "First Name",
                    "Address",
                    "City",
                    "State",
                    "ZIP",
                    "Phone",
            };

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    // Methods

    /**
     * Class Constructor
     *
     * @param firstName String to assign to person's first name.
     * @param lastName  String to assign to person's last name.
     * @param address  String to assign to person's address.
     * @param city  String to assign to person's city.
     * @param state  String to assign to person's state.
     * @param zip  String to assign to person's zip.
     * @param phone  String to assign to person's phone.
     */
    public Person(String firstName, String lastName, String address, String city, String state, String zip, String phone) {
        // Input validation for First Name.
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First name cannot be empty");
        // Input validation for Last name.
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Last name cannot be empty");
        // Input validation for Zip.
        if (zip.length() != 5 && !zip.isEmpty())
            throw new IllegalArgumentException("Zip code can only be 5 numbers long or blank.");

        // If no exceptions were thrown, assign the member fields the argument values.
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * Returns this Person's first name.
     *
     * @return First name of this Person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns this Person's last name.
     *
     * @return Last name of this Person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns this Person's address.
     *
     * @return Address of this Person.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns this Person's city.
     *
     * @return City code of this Person.
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns this Person's state.
     *
     * @return State of this Person.
     */
    public String getState() {
        return state;
    }

    /**
     * Returns this Person's ZIP code.
     *
     * @return ZIP code of this Person.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Returns this Person's telephone number.
     *
     * @return Telephone number of this Person.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns this Person's last and first name.
     *
     * @return Last and first name of this Person.
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    /**
     * Returns whether or not any fields of this Person contains the search text.
     *
     * @return True or false.
     * @param findMe String to check for a match.
     */
    public boolean containsString(String findMe) {
        Pattern p = Pattern.compile(Pattern.quote(findMe), Pattern.CASE_INSENSITIVE);
        return p.matcher(firstName).find()
                || p.matcher(lastName).find()
                || p.matcher(address).find()
                || p.matcher(city).find()
                || p.matcher(state).find()
                || p.matcher(zip).find()
                || p.matcher(phone).find();
    }

    /**
     * Returns this Person's specified field.
     *
     * @return A field of this Person according to field index.
     * @param field Index of field to return.
     */
    public String getField(int field) {
        switch (field) {
            case 0:
                return lastName;
            case 1:
                return firstName;
            case 2:
                return address;
            case 3:
                return city;
            case 4:
                return state;
            case 5:
                return zip;
            case 6:
                return phone;
            default:
                throw new IllegalArgumentException("Field number out of bounds");
        }
    }
}