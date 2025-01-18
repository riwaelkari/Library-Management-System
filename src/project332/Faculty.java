package project332;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a faculty in the university system.
 * Each faculty contains multiple libraries and users (students and professors).
 */
public class Faculty {
    private String name; // Name of the faculty
    private List<Library> libraries; // List of libraries in the faculty
    private List<User> users; // List of users (students and professors) in the faculty
    private FacultyRules rules; // Rules for the faculty

    /**
     * Constructs a Faculty with the specified name.
     *
     * @param name the name of the faculty
     */
    public Faculty(String name) {
        this.name = name;
        this.libraries = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rules = new FacultyRules(); // Initialize rules
    }

    /**
     * Gets the name of the faculty.
     *
     * @return the name of the faculty
     */
    public String getName() {
        return name;
    }
    /**Gets the faculty rules
     * 
     * @return the faculty rules
     */
    public FacultyRules getRules() {
        return rules;
    }

    /**
     * Gets the list of libraries in the faculty.
     *
     * @return a list of libraries
     */
    public List<Library> getLibraries() {
        return new ArrayList<>(libraries);
    }

    /**
     * Adds a library to the faculty.
     *
     * @param library the library to add
     */
    public void addLibrary(Library library) {
        if (!libraries.contains(library)) {
            libraries.add(library);
            System.out.println("Library added to faculty " + this.name +":" + library.getName());
        } else {
            System.out.println("Library is already part of the faculty.");
        }
    }

    /**
     * Gets the list of all users in the faculty.
     *
     * @return a list of users (students and professors)
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Adds a user (student or professor) to the faculty.
     *
     * @param user the user to add
     */
    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            System.out.println("User added to faculty of " + this.name+ ":"  + user.getName());
        } else {
            System.out.println("User is already part of the faculty.");
        }
    }

    /**
     * Removes a user (student or professor) from the faculty.
     *
     * @param user the user to remove
     */
    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("User removed from faculty: " + user.getName());
        } else {
            System.out.println("User not found in the faculty.");
        }
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", librariesCount=" + libraries.size() +
                ", usersCount=" + users.size() +
                '}';
    }
}
