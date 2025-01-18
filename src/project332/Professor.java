package project332;

/**
 * Represents a professor in the library system.
 * A professor is a type of user with specific attributes like rank.
 * This class extends the User class, inheriting general user attributes and behaviors
 * while adding specific details relevant to professors.
 */
public class Professor extends User {
    private String rank; // Rank of the professor (e.g., "Professor", "Lecturer")

    /**
     * Constructs a Professor with the specified details.
     *
     * @param name         the name of the professor
     * @param address      the address of the professor
     * @param phoneNb      the phone number of the professor
     * @param emailAddress the email address of the professor
     * @param faculty      the faculty the professor belongs to
     * @param rank         the rank of the professor (e.g., "Professor", "Lecturer")
     */
    public Professor(String name, String address, String phoneNb, String emailAddress, Faculty faculty, String rank) {
        super(name, address, phoneNb, emailAddress, faculty); // Pass faculty to User constructor
        this.rank = rank;
    }

    /**
     * Gets the rank of the professor.
     *
     * @return the rank of the professor
     */
    public String getRank() {
        return rank;
    }

    /**
     * Sets the rank of the professor.
     *
     * @param rank the new rank of the professor
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Gets the role of the professor.
     *
     * @return "Professor"
     */
    @Override
    public String getRole() {
        return "Professor";
    }

    @Override
    public String toString() {
        String facultyName = "None";
        if (getFaculty() != null) {
            facultyName = getFaculty().getName();
        }
        return "Professor{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNb='" + getPhoneNb() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", faculty='" + facultyName + '\'' +
                ", rank='" + rank + '\'' +
                ", borrowedBooks=" + getBorrowedBooks().size() +
                ", returnedBooks=" + getReturnedBooks().size() +
                '}';
    }

}
