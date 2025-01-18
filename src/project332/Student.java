package project332;

/**
 * Represents a student in the university's library system.
 * Each student is associated with a specific faculty and has a unique student ID.
 * This class extends the User class, inheriting general user attributes and behaviors
 * while adding specific details relevant to students.
 */
public class Student extends User {
    private String studentID; // Unique identifier for the student

    /**
     * Constructs a Student with the specified details.
     *
     * @param name         the name of the student
     * @param address      the address of the student
     * @param phoneNb      the phone number of the student
     * @param emailAddress the email address of the student
     * @param faculty      the faculty the student belongs to
     * @param studentID    the unique ID of the student
     */
    public Student(String name, String address, String phoneNb, String emailAddress, Faculty faculty, String studentID) {
        super(name, address, phoneNb, emailAddress, faculty); // Pass faculty to User constructor
        this.studentID = studentID;
    }

    /**
     * Gets the unique student ID.
     *
     * @return the student ID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Sets the unique student ID.
     *
     * @param studentID the new student ID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Gets the role of the student.
     *
     * @return "Student"
     */
    @Override
    public String getRole() {
        return "Student";
    }

    
    @Override
    public String toString() {
        String facultyName = "None";
        if (getFaculty() != null) {
            facultyName = getFaculty().getName();
        }
        return "Student{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNb='" + getPhoneNb() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", faculty='" + facultyName + '\'' +
                ", studentID='" + studentID + '\'' +
                ", borrowedBooks=" + getBorrowedBooks().size() +
                ", returnedBooks=" + getReturnedBooks().size() +
                '}';
    }

}
