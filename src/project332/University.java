package project332;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a university containing multiple faculties and their libraries.
 * The university acts as a central entity to manage faculties, libraries, and resources.
 */
public class University {
    private String name; // Name of the university
    private List<Faculty> faculties; // List of faculties in the university

    /**
     * Constructs a University with the specified name.
     *
     * @param name the name of the university
     */
    public University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    /**
     * Gets the name of the university.
     *
     * @return the name of the university
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of faculties in the university.
     *
     * @return a list of faculties
     */
    public List<Faculty> getFaculties() {
        return new ArrayList<>(faculties);
    }

    /**
     * Adds a faculty to the university.
     *
     * @param faculty the faculty to add
     */
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    /**
     * Lists all libraries across all faculties in the university.
     *
     * @return a list of libraries in the university
     */
    public List<Library> getAllLibraries() {
        List<Library> allLibraries = new ArrayList<>();
        for (Faculty faculty : faculties) {
            allLibraries.addAll(faculty.getLibraries());
        }
        return allLibraries;
    }

    /**
     * Searches for a library by its name across all faculties.
     *
     * @param libraryName the name of the library to search for
     * @return the library if found, or null if not found
     */
    public Library searchLibraryByName(String libraryName) {
        for (Faculty faculty : faculties) {
            for (Library library : faculty.getLibraries()) {
                if (library.getName().equalsIgnoreCase(libraryName)) {
                    return library;
                }
            }
        }
        return null;
    }

    /**
     * Searches for a faculty by its name.
     *
     * @param facultyName the name of the faculty to search for
     * @return the faculty if found, or null if not found
     */
    public Faculty searchFacultyByName(String facultyName) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(facultyName)) {
                return faculty;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", facultiesCount=" + faculties.size() +
                '}';
    }
}
