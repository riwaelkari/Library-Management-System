package project332;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents an admin responsible for managing a library.
 * Admin class extends Person.
 * Admins can add, update, delete, and view resources in the library, view user logs,
 * and configure library settings. Admins also manage users and oversee library operations.
 * Admins can modify rules related to borrowing books, reserving meeting rooms, 
 * and using electronic resources for the faculty associated with their managed library.
 */
public class Admin extends Person {
    private Library managedLibrary; // Library managed by this admin
    private String schedule; // Admin's working schedule

    /**
     * Constructs an Admin with the specified details.
     *
     * @param name          the name of the admin
     * @param address       the address of the admin
     * @param phoneNb       the phone number of the admin
     * @param emailAddress  the email address of the admin
     * @param schedule      the admin's working schedule
     * @param managedLibrary the library managed by this admin
     */
    public Admin(String name, String address, String phoneNb, String emailAddress, String schedule, Library managedLibrary) {
        super(name, address, phoneNb, emailAddress);
        this.schedule = schedule;
        this.managedLibrary = managedLibrary;
    }

    /**
     * Gets the library managed by the admin.
     *
     * @return the library managed by the admin
     */
    public Library getManagedLibrary() {
        return managedLibrary;
    }

    /**
     * Sets the library managed by the admin.
     *
     * @param managedLibrary the new library to be managed by the admin
     */
    public void setManagedLibrary(Library managedLibrary) {
        this.managedLibrary = managedLibrary;
    }

    /**
     * Gets the admin's working schedule.
     *
     * @return the working schedule of the admin
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Sets the admin's working schedule.
     *
     * @param schedule the new working schedule of the admin
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * Adds a book to the managed library's collection.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        if (!managedLibrary.getBooks().contains(book)) {
            managedLibrary.addBook(book);
            System.out.println("Admin "+ this.getName()+" added a book: " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
        } else {
            System.out.println("The book " + book.getTitle() + " is already in the library.");
        }
    }

    /**
     * Adds a meeting room to the managed library's collection.
     *
     * @param room the meeting room to add
     */
    public void addMeetingRoom(MeetingRoom room) {
        if (!managedLibrary.getMeetingRooms().contains(room)) {
            managedLibrary.addMeetingRoom(room);
            System.out.println("Admin "+ this.getName()+" added a meeting room: " + room.getName());
        } else {
            System.out.println("The meeting room " + room.getName() + " is already in the library.");
        }
    }

    /**
     * Adds an electronic resource to the managed library's collection.
     *
     * @param resource the electronic resource to add
     */
    public void addElectronicResource(ElectronicResource resource) {
        if (!managedLibrary.getElectronicResources().contains(resource)) {
            managedLibrary.addElectronicResource(resource);
            System.out.println("Admin" + this.getName()+" added an electronic resource: " + resource.getBrand());
        } else {
            System.out.println("The electronic resource " + resource.getBrand() + " is already in the library.");
        }
    }

    /**
     * Updates the details of a book in the managed library's collection.
     *
     * @param isbn          the ISBN of the book to update
     * @param newTitle      the new title of the book (if null, title remains unchanged)
     * @param newAuthor     the new author of the book (if null, author remains unchanged)
     * @param newGenre      the new genre of the book (if null, genre remains unchanged)
     * @param newDescription the new description of the book (if null, description remains unchanged)
     * @return true if the book was updated successfully, false otherwise
     */
    public boolean updateBook(String isbn, String newTitle, String newAuthor, String newGenre, String newDescription) {
        for (Book book : managedLibrary.getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                if (newTitle != null) book.setTitle(newTitle);
                if (newAuthor != null) book.setAuthor(newAuthor);
                if (newGenre != null) book.setGenre(newGenre);
                if (newDescription != null) book.setDescription(newDescription);
                System.out.println("Book updated: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }

    /**
     * Deletes a book from the managed library's collection and updates all users' records.
     *
     * @param isbn the ISBN of the book to delete
     * @return true if the book was deleted successfully, false otherwise
     */
    public boolean deleteBook(String isbn) {
        List<Book> books = managedLibrary.getBooks();
        for (Book book : new ArrayList<>(books)) { // Create a copy to avoid ConcurrentModificationException
            if (book.getIsbn().equals(isbn)) {
                books.remove(book); // Remove the book
                System.out.println("Book removed from library: " + book.getTitle());

                // Update all users in the faculty to remove the book
                Faculty faculty = managedLibrary.getFaculty();
                if (faculty != null) {
                    for (User user : faculty.getAllUsers()) {
                        System.out.println("Updating records for user: " + user.getName());

                        // Remove book references
                        boolean removedBorrowed = user.getBorrowedBooks().remove(book);
                        boolean removedReturned = user.getReturnedBooks().remove(book);
                        boolean removedRecord = (user.getBorrowRecords().remove(book) != null);

                        // Debugging outputs
                        //System.out.println("  Removed from borrowedBooks: " + removedBorrowed);
                        //System.out.println("  Removed from returnedBooks: " + removedReturned);
                        //System.out.println("  Removed from borrowRecords: " + removedRecord);
                    }
                }

                // Ensure the library's book list is updated
                managedLibrary.setBooks(new ArrayList<>(books)); // Update the library's list explicitly
                return true;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found.");
        return false;
    }




    /**
     * Retrieves a list of all users in the faculty associated with the managed library.
     *
     * @return a list of users in the faculty
     */
    public List<User> viewAllUsers() {
        Faculty faculty = managedLibrary.getFaculty();
        if (faculty != null) {
            return faculty.getAllUsers();
        }
        System.out.println("No faculty associated with the library.");
        return new ArrayList<>();
    }

    /**
     * Retrieves the borrowing logs for all users in the managed library's faculty.
     *
     * @return a list of borrowing logs (list of strings)
     */
    public List<String> viewBorrowLogs() {
        List<String> logs = new ArrayList<>();
        Faculty faculty = managedLibrary.getFaculty();
        if (faculty != null) {
            List<User> users = faculty.getAllUsers();
            for (User user : users) {
                for (Book book : user.getBorrowedBooks()) {
                    logs.add(user.getName() + " borrowed " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
                }
            }
        } else {
            System.out.println("No faculty associated with the library.");
        }
        return logs;
    }

    /**
     * Retrieves the return logs for all users in the managed library's faculty.
     *
     * @return a list of return logs
     */
    public List<String> viewReturnLogs() {
        List<String> logs = new ArrayList<>();
        Faculty faculty = managedLibrary.getFaculty();
        if (faculty != null) {
            List<User> users = faculty.getAllUsers();
            for (User user : users) {
                for (Book book : user.getReturnedBooks()) {
                    logs.add(user.getName() + " returned " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
                }
            }
        } else {
            System.out.println("No faculty associated with the library.");
        }
        return logs;
    }
    
    
    
    /**
     * Retrieves and prints a list of all books in the managed library.
     */
    public void viewAllBooks() {
        List<Book> books = managedLibrary.getBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("- " + book.getTitle() + " (ISBN: " + book.getIsbn() + ")");
            }
        }
    }
    
    /**
     * Retrieves a list of the most frequent borrowers from the managed library's faculty.
     * The list is sorted in descending order of borrow count.
     */
    public void viewFrequentBorrowers() {
        Faculty faculty = managedLibrary.getFaculty();
        if (faculty != null) {
            List<User> users = faculty.getAllUsers();
            
            // Sort users by borrow count in descending order
            users.sort(new Comparator<User>() {  // i found this way online
                @Override
                public int compare(User u1, User u2) {
                    return Integer.compare(u2.getBorrowCount(), u1.getBorrowCount()); // Descending
                }
            });

            System.out.println("Most frequent borrowers:");
            for (User user : users) {
                System.out.println(user.getName() + " (Borrowed " + user.getBorrowCount() + " books)");
            }
        } else {
            System.out.println("No faculty associated with the library.");
        }
    }
    
    /**
     * Retrieves a list of the most borrowed books in the managed library.
     * The list is sorted in descending order of borrow count.
     */
    public void viewFrequentBooks() {
        List<Book> books = managedLibrary.getBooks();

        // Sort books by borrow count in descending order
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return Integer.compare(b2.getBorrowCount(), b1.getBorrowCount()); // Descending
            }
        });

        // Display sorted results
        System.out.println("Most borrowed books:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " (Borrowed " + book.getBorrowCount() + " times)");
        }
    }
    
    
    /**
     * Generates a report of overdue books in the library system.
     * 
     * This method iterates through the users in the faculty, checks each user's borrowed books,
     * and identifies which books are overdue. It prints a report listing all overdue books.
     *
     * @param faculty The faculty whose users will be checked for overdue books.
     */
    public void generateOverdueBooksReport(Faculty faculty) {
        System.out.println("Overdue Books Report:");
        boolean hasOverdueBooks = false;

        for (User user : faculty.getAllUsers()) { // Iterate through all users in the faculty
            for (Book book : user.getBorrowedBooks()) { // Iterate through each user's borrowed books
                BorrowRecord record = user.getBorrowRecords().get(book); // Get the BorrowRecord for the book

                if (record != null && record.isOverdue()) { // Check if the book is overdue
                    hasOverdueBooks = true;
                    System.out.println("User: " + user.getName() + " - Book: " + book.getTitle() 
                                       + " (ISBN: " + book.getIsbn() + ")");
                }
            }
        }

        if (!hasOverdueBooks) {
            System.out.println("No overdue books found.");
        }
    }

    
    /**
     * Configures borrowing duration for a specific user type.
     *
     * @param userType the type of user (e.g., "Student", "Professor")
     * @param duration the maximum borrowing duration in days
     */
    public void setBorrowDuration(String userType, int duration) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setBorrowDuration(userType, duration);
            System.out.println("Borrow duration set to " + duration + " days for " + userType);
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    /**
     * Configures maximum renewals for a specific user type.
     *
     * @param userType  the type of user (e.g., "Student", "Professor")
     * @param renewals  the maximum number of renewals
     */
    public void setMaxRenewals(String userType, int renewals) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setMaxRenewals(userType, renewals);
            System.out.println("Maximum renewals set to " + renewals + " for " + userType);
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    /**
     * Configures late penalty duration for returning books late.
     *
     * @param penaltyDays the number of penalty days
     */
    public void setLatePenaltyDays(int penaltyDays) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setLatePenaltyDays(penaltyDays);
            System.out.println("Late penalty set to " + penaltyDays + " days.");
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    /**
     * Configures maximum meeting room reservation duration.
     *
     * @param hours the maximum reservation duration in hours
     */
    public void setMaxReservationDuration(int hours) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setMaxReservationDuration(hours);
            System.out.println("Maximum meeting room reservation duration set to " + hours + " hours.");
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    /**
     * Configures whether students can reserve meeting rooms.
     *
     * @param allowed true if students are allowed, false otherwise
     */
    public void setStudentsAllowedToReserve(boolean allowed) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setStudentsAllowedToReserve(allowed);
            System.out.println("Students allowed to reserve meeting rooms: " + allowed);
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }
    
    
    
    /**
     * Configures whether professors can reserve meeting rooms.
     *
     * @param allowed true if professors are allowed, false otherwise
     */
    public void setProfessorsAllowedToReserve(boolean allowed) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setProfessorsAllowedToReserve(allowed);
            System.out.println("Professors allowed to reserve meeting rooms: " + allowed);
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    /**
     * Configures maximum usage duration for electronic resources.
     *
     * @param hours the maximum usage duration in hours
     */
    public void setMaxUsageDuration(int hours) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setMaxUsageDuration(hours);
            System.out.println("Electronic resource usage duration set to " + hours + " hours.");
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    /**
     * Configures whether students are allowed to use electronic resources.
     *
     * @param allowed true if students are allowed, false otherwise
     */
    public void setStudentsAllowedToUse(boolean allowed) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setStudentsAllowedToUse(allowed);
            System.out.println("Students allowed to use electronic resources: " + allowed);
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    public void setwaitingPeriodToUseAgain(int wp) {
        if (managedLibrary.getFaculty() != null) {
            FacultyRules rules = managedLibrary.getFaculty().getRules();
            rules.setWaitingPeriodToUseAgain(wp);
            System.out.println("Students allowed to use electronic resources again after waiting for: " + wp + " hours");
        } else {
            System.out.println("No faculty associated with the library to configure rules.");
        }
    }

    



    /**
     * Provides a string representation of the admin's details.
     *
     * @return a string representation of the admin
     */
    @Override
    public String toString() {
        String libraryName = "None";
        if (managedLibrary != null) {
            libraryName = managedLibrary.getName();
        }
        return "Admin{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNb='" + getPhoneNb() + '\'' +
                ", emailAddress='" + getEmailAddress() + '\'' +
                ", schedule='" + schedule + '\'' +
                ", managedLibrary='" + libraryName + '\'' +
                '}';
    }

    /**
     * Gets the admin's role.
     *
     * @return "Admin"
     */
    @Override
    public String getRole() {
        return "Admin";
    }
}
