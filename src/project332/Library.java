package project332;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library in the university system.
 * A library manages its own collection of resources, including books, meeting rooms,
 * and electronic resources like PCs and Tablets. Libraries are associated with a specific faculty.
 */
public class Library {
    private String name; // Name of the library
    public void setAdmin(Admin admin) {
		this.admin = admin;
		System.out.println(admin.getName() + " has been assigned to " +this.name);
	}

	private String location; // Physical location of the library
    private Faculty faculty; // Faculty to which the library belongs
    private Admin admin; // Admin responsible for managing the library
    private List<Book> books; // Collection of books in the library
    private List<MeetingRoom> meetingRooms; // Collection of meeting rooms
    private List<ElectronicResource> electronicResources; // Collection of electronic resources

    /**
     * Constructs a Library with the specified details.
     *
     * @param name     the name of the library
     * @param location the physical location of the library
     * @param faculty  the faculty to which the library belongs
     * @param admin    the admin responsible for managing the library
     */
    public Library(String name, String location, Faculty faculty, Admin admin) {
        this.name = name;
        this.location = location;
        this.faculty = faculty;
        this.admin = admin;
        this.books = new ArrayList<>();
        this.meetingRooms = new ArrayList<>();
        this.electronicResources = new ArrayList<>();
    }

    // Getters and Setters

    /**
     * Gets the name of the library.
     *
     * @return the name of the library
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the physical location of the library.
     *
     * @return the location of the library
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the faculty to which the library belongs.
     *
     * @return the faculty of the library
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Gets the admin responsible for managing the library.
     *
     * @return the admin of the library
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Gets the list of books in the library.
     *
     * @return a list of books in the library
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Gets the list of meeting rooms in the library.
     *
     * @return a list of meeting rooms in the library
     */
    public List<MeetingRoom> getMeetingRooms() {
        return new ArrayList<>(meetingRooms);
    }

    /**
     * Gets the list of electronic resources in the library.
     *
     * @return a list of electronic resources in the library
     */
    public List<ElectronicResource> getElectronicResources() {
        return new ArrayList<>(electronicResources);
    }

    // Methods for Resource Management

    /**
     * Adds a book to the library's collection.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Adds a meeting room to the library's collection.
     *
     * @param room the meeting room to add
     */
    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.add(room);
    }

    /**
     * Adds an electronic resource to the library's collection.
     *
     * @param resource the electronic resource to add
     */
    public void addElectronicResource(ElectronicResource resource) {
        electronicResources.add(resource);
    }

    // Search Methods

    /**
     * Searches for books in the library by a specific field and value.
     *
     * @param field the field to search (e.g., "title", "author", "isbn", "genre")
     * @param value the value to match
     * @return a list of books that match the criteria
     */
    public List<Book> searchBooksByField(String field, String value) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (field.equalsIgnoreCase("title") && book.getTitle().equalsIgnoreCase(value)) {
                results.add(book);
            } 
            else if (field.equalsIgnoreCase("author") && book.getAuthor().equalsIgnoreCase(value)) {
                results.add(book);
            }
            else if (field.equalsIgnoreCase("isbn") && book.getIsbn().equalsIgnoreCase(value)) {
                results.add(book);
            }
            else if (field.equalsIgnoreCase("genre") && book.getGenre().equalsIgnoreCase(value)) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * Searches for meeting rooms in the library by a specific field and value.
     *
     * @param field the field to search (e.g., "name", "location", "capacity")
     * @param value the value to match
     * @return a list of meeting rooms that match the criteria
     */
    public List<MeetingRoom> searchRoomsByField(String field, String value) {
        List<MeetingRoom> results = new ArrayList<>();
        for (MeetingRoom room : meetingRooms) {
            if (field.equalsIgnoreCase("name") && room.getName().equalsIgnoreCase(value)) {
                results.add(room);
            } else if (field.equalsIgnoreCase("location") && room.getLocation().equalsIgnoreCase(value)) {
                results.add(room);
            } else if (field.equalsIgnoreCase("capacity")) {
                try {
                    int capacityValue = Integer.parseInt(value); // Convert value to an integer
                    if (room.getCapacity() == capacityValue) {
                        results.add(room);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid capacity value: " + value);
                    // Continue to next iteration without adding to results
                }
            }
        }
        return results;
    }

    /**
     * Searches for electronic resources in the library by their brand.
     *
     * @param brand the brand to search for
     * @return a list of electronic resources that match the brand
     */
    public List<ElectronicResource> searchElectronicResourcesByBrand(String brand) {
        List<ElectronicResource> results = new ArrayList<>();
        for (ElectronicResource resource : electronicResources) {
            if (resource.getBrand().equalsIgnoreCase(brand)) {
                results.add(resource);
            }
        }
        return results;
    }

    /**
     * Returns a string representation of the library, including its name, location, faculty, admin,
     * and resource counts.
     *
     * @return a string representation of the library
     */
    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", faculty=" + faculty.getName() +
                ", admin=" + admin.getName() +
                ", booksCount=" + books.size() +
                ", meetingRoomsCount=" + meetingRooms.size() +
                ", electronicResourcesCount=" + electronicResources.size() +
                '}';
    }

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
