package project332;

/**
 * The abstract base class representing a person in the library system.
 * It provides the common attributes and behaviors shared by all individuals in the library management system, including Admin, Student, and Professor.
 */
public abstract class Person {
    private String name;
    private String address;
    private String phoneNb;
    private String emailAddress;

    /**
     * Constructs a Person object with the specified details.
     *
     * @param name         the name of the person
     * @param address      the address of the person
     * @param phoneNb      the phone number of the person
     * @param emailAddress the email address of the person
     *                     (must contain an '@' character)
     * @throws IllegalArgumentException if the email address does not contain '@'
     */
    public Person(String name, String address, String phoneNb, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNb = phoneNb; 
        setEmailAddress(emailAddress); 
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the person.
     *
     * @return the address of the person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the person.
     *
     * @param address the new address of the person
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the phone number of the person
     */
    public String getPhoneNb() {
        return phoneNb;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNb the new phone number of the person
     */
    public void setPhoneNb(String phoneNb) {
        this.phoneNb = phoneNb; // No validation for phone number
    }

    /**
     * Gets the email address of the person.
     *
     * @return the email address of the person
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the person. The email address must contain an '@' character.
     *
     * @param emailAddress the new email address of the person
     * @throws IllegalArgumentException if the email address does not contain '@'
     */
    public void setEmailAddress(String emailAddress) {
        if (!emailAddress.contains("@")) {
            throw new IllegalArgumentException("Invalid email address. Email must contain an @.");
        }
        this.emailAddress = emailAddress;
    }

    /**
     * Abstract method to get the role of the person.
     * Each subclass must provide its specific implementation.
     *
     * @return a string describing the role of the person
     */
    public abstract String getRole();

    /**
     * Determines whether this person is equal to another object.
     * Two Person objects are considered equal if their email addresses are the same.
     *
     * @param obj the object to compare with this person
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return emailAddress.equals(person.emailAddress);
    }

    /**
     * Returns the hash code for this person. The hash code is based on the email address.
     *
     * @return the hash code for this person
     */
    @Override
    public int hashCode() {
        return emailAddress.hashCode();
    }
}
