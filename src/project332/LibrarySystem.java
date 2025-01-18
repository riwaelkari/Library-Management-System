package project332;

/**
 * Utility class for library system operations, such as access control.
 * This class is designed to enforce faculty-based access restrictions,
 *  where users can only interact with libraries associated with their respective faculties.
 */
public class LibrarySystem {
    /**
     * Checks if a user is allowed to access a given library.
     * A user can only access libraries belonging to their own faculty.
     *
     * @param user    the user attempting to access the library
     * @param library the library the user wants to access
     * @return true if the user can access the library, false otherwise
     */
    public static boolean canUserAccessLibrary(User user, Library library) {
        return user.getFaculty().equals(library.getFaculty());
    }
}
