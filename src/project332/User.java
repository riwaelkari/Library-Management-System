package project332;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class representing a general user in the library system,
 * such as a student or professor. It extends the Person class.
 *
 * **Responsibilities:**
 * - Users can interact with resources in libraries belonging to their
 *   faculty only.
 * - Users can reserve, borrow, return, and access various resources
 *   (e.g., books, meeting rooms, electronic resources).
 * - Tracks borrowing history and maintains a borrow count for usage
 *   statistics.
 *
 * **Key Features:**
 * 1. **Faculty-Based Access Control:**
 *    - Each user belongs to a specific faculty.
 *    - Access to library resources is restricted to libraries within
 *      the user's faculty.
 *    - Before performing actions like reserving, borrowing, or
 *      accessing resources, the system checks if the user is allowed
 *      to interact with the specified library using the
 *      `LibrarySystem.canUserAccessLibrary(User user, Library library)`
 *      method.
 *    - If access is denied, the action is not performed, and a message
 *      is displayed to the user.
 *      *Example:* "Access denied: Alice cannot reserve resources in
 *      Main Library."
 *
 * 2. **Resource Interaction:**
 *    - Users can:
 *      - Reserve resources (e.g., meeting rooms, electronic devices).
 *      - Borrow and return physical borrowable books.
 *      - Access non-borrowable books and eBooks.
 *      - Use electronic resources like PCs or tablets.
 *    - Delegates resource-specific logic (e.g., validating availability
 *      or checking reservations) to the resource classes themselves.
 *
 * 3. **Borrowing History and Statistics:**
 *    - The `borrowedBooks` list tracks books currently borrowed by the
 *      user.
 *    - The `returnedBooks` list tracks books returned by the user.
 *    - The `borrowCount` field tracks the total number of books
 *      borrowed, useful for generating reports on frequent borrowers.
 *
 * 4. **Access Denial:**
 *    - Access is denied if a user attempts to interact with a library
 *      that does not belong to their faculty.
 *    - Access control is enforced for actions like:
 *      - Borrowing or returning books.
 *      - Reserving resources.
 *      - Accessing eBooks or non-borrowable books.
 *      - Using electronic resources.
 *    - This ensures that users respect faculty boundaries and only
 *      interact with permitted libraries.
 *
 * **Design Notes:**
 * - This class extends the `Person` class.
 * - It is extended by specific user types like `Student` and
 *   `Professor`.
 * - Faculty-based restrictions are implemented in the `LibrarySystem`
 *   class, allowing consistent access control across all users.
 * - Delegating resource-specific functionality to resource classes
 *   ensures modularity and cleaner code.
 */
public abstract class User extends Person {
    private Faculty faculty; // Faculty the user belongs to
    private List<Book> borrowedBooks; // Books currently borrowed
    private List<Book> returnedBooks; // Books returned by the user
    private int borrowCount; // Total number of books borrowed
    private Map<Book, BorrowRecord> borrowRecords; // Borrow records
    private LocalDate penaltyEndDate; // Penalty end date for overdue

    /**
     * Constructs a User with the specified details.
     *
     * @param name         the name of the user
     * @param address      the address of the user
     * @param phoneNb      the phone number of the user
     * @param emailAddress the email address of the user
     * @param faculty      the faculty the user belongs to
     */
    public User(String name, String address, String phoneNb,
                String emailAddress, Faculty faculty) {
        super(name, address, phoneNb, emailAddress);
        this.faculty = faculty;
        this.borrowedBooks = new ArrayList<>();
        this.returnedBooks = new ArrayList<>();
        this.borrowCount = 0;
        this.borrowRecords = new HashMap<>();

        // Automatically add the user to the faculty's user list
        if (faculty != null) {
            faculty.addUser(this);
        }
    }

    /**
     * Gets the faculty the user belongs to.
     *
     * @return the faculty
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Sets the faculty of the user and updates the faculty's user list.
     *
     * @param faculty the new faculty
     */
    public void setFaculty(Faculty faculty) {
        // Remove the user from the current faculty, if applicable
        if (this.faculty != null) {
            this.faculty.removeUser(this);
        }
        // Update the faculty and add the user to the new faculty
        this.faculty = faculty;
        if (faculty != null) {
            faculty.addUser(this);
        }
    }

    /**
     * Gets the borrow count (number of times the user has borrowed a
     * book).
     *
     * @return the borrow count of the user
     */
    public int getBorrowCount() {
        return borrowCount;
    }

    /**
     * Increments the borrow count of the user.
     */
    public void incrementBorrowCount() {
        borrowCount++;
    }

    /**
     * Checks if the user has any overdue books.
     *
     * @return true if the user has overdue books, false otherwise
     */
    public boolean hasOverdueBooks() {
        for (BorrowRecord record : borrowRecords.values()) {
            if (record.isOverdue()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reserves a reservable resource, enforcing faculty-specific rules
     * for certain resource types.
     *
     * @param <T>      the type of the reservable resource
     * @param resource the resource to reserve
     * @param library  the library containing the resource
     * @param duration the requested reservation duration (applies to
     *                 MeetingRoom)
     */
    public <T extends Reservable> void reserve(T resource,
            Library library, int duration) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot reserve resources in " + library.getName());
            return;
        }

        if (resource instanceof MeetingRoom) {
            FacultyRules rules = this.getFaculty().getRules();
            MeetingRoom room = (MeetingRoom) resource;

            // Check if the meeting room is already reserved
            if (room.isReserved()) {
                System.out.println("Reservation failed: The meeting room '"
                    + room.getName() + "' is already reserved.");
                return;
            }

            // Check if students/professors are allowed to reserve
            if (this instanceof Student && !rules.isStudentsAllowedToReserve()) {
                System.out.println("Reservation denied: Students are not "
                    + "allowed to reserve meeting rooms.");
                return;
            }
            if (this instanceof Professor && !rules.isProfessorsAllowedToReserve()) {
                System.out.println("Reservation denied: Professors are not "
                    + "allowed to reserve meeting rooms.");
                return;
            }

            // Check maximum duration
            if (duration > rules.getMaxReservationDuration()) {
                System.out.println("Reservation denied: Maximum duration is "
                    + rules.getMaxReservationDuration() + " hour(s).");
                return;
            }

            // Proceed with reservation
            if (room.reserve(this)) {
                System.out.println(this.getName() + " successfully reserved "
                    + "the meeting room '" + room.getName() + "' for "
                    + duration + " hour(s).");
            } else {
                System.out.println("Reservation failed: The meeting room '"
                    + room.getName() + "' is already reserved.");
            }
            return;
        }
        
        
        if (resource instanceof ElectronicResource) {
        	ElectronicResource er = (ElectronicResource) resource;
        	Map<User, Integer> m =(er.getusermaxUsageTimeMap());

            FacultyRules rules = this.getFaculty().getRules();
        	int hoursToAdd = rules.getWaitingPeriodToUseAgain();
        	if (m.containsKey(this)){
        		if (m.get(this) == 0) {
        			LocalDateTime firstTimeUsed = er.getuserUsageTime(this);
        			System.out.println("You cannot reserve again (renew) until " + firstTimeUsed.plusHours(hoursToAdd));
        		}
        	}
        		
        	
        	
        }

        // Default behavior for other reservable resources
        if (resource.reserve(this)) {
            System.out.println(this.getName() + " successfully reserved the "
                + "resource.\n");
        } else {
            System.out.println("Reservation failed for " + this.getName()
                + ".");
        }
    }

    /**
     * Cancels the reservation for a reservable resource.
     *
     * @param <T>      the type of the reservable resource
     * @param resource the resource to cancel the reservation for
     * @param library  the library containing the resource
     */
    public <T extends Reservable> void cancelReservation(T resource, Library library) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot access resources in " + library.getName());
            return;
        }
        if (resource.cancelReservation(this)) {
            System.out.println(this.getName() + " canceled the reservation "
                + "for: " + resource + "\n");
        } else {
            System.out.println("Cancellation failed for " + this.getName());
        }
    }

    /**
     * Accesses an eBook.
     *
     * @param eBook   the eBook to access
     * @param library the library containing the eBook
     */
    public void accessEBook(EBook eBook, Library library) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot use eBooks in " + library.getName());
            return;
        }
        System.out.println(this.getName() + " is reading the eBook: "
            + eBook.getTitle() + "\n");
    }

    /**
     * Accesses a non-borrowable physical book.
     *
     * @param book    the non-borrowable book to access
     * @param library the library containing the book
     */
    public void accessNonBorrowableBook(PhysicalNonBorrowableBook book,
                                        Library library) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot access books in " + library.getName());
            return;
        }
        System.out.println(this.getName() + " is accessing the "
            + "non-borrowable book: " + book.getTitle() + "\n");
    }

    /**
     * Uses an electronic resource, enforcing faculty-specific rules for
     * duration and user type.
     *
     * @param resource the electronic resource to use
     * @param library  the library containing the resource
     * @param duration the requested usage duration in hours
     */
    public void useElectronicResource(ElectronicResource resource, Library library, int duration) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot access electronic resources in "
                + library.getName());
            return;
        }

        FacultyRules rules = this.getFaculty().getRules();

        // Rule: Only certain users can use electronic resources
        if (this instanceof Professor && !rules.isProfessorsAllowedToUse()) {
            System.out.println("Usage denied: Professors are not allowed to "
                + "use electronic resources.");
            return;
        }
        if (this instanceof Student && !rules.isStudentsAllowedToUse()) {
            System.out.println("Usage denied: Students are not allowed to "
                + "use electronic resources.");
            return;
        }

        
        if (!resource.getusermaxUsageTimeMap().containsKey(this)) {
            // User is not in the map, add them with the max usage duration from rules
            int maxUsageTime = rules.getMaxUsageDuration();
            resource.setusermaxUsageTime(this, maxUsageTime);
            //System.out.println("User added with max usage time: " + maxUsageTime);
        
        }
        //System.out.println("debugging " +  resource.getusermaxUsageTime(this));
        
     // Check maximum usage duration
        if (duration > resource.getusermaxUsageTime(this)) {
            System.out.println("Usage denied: Maximum usage duration is "
                + rules.getMaxUsageDuration() + " hour(s) in total. You still have " +  resource.getusermaxUsageTime(this) +"hours left");
            return;
        }
        
        

        // Proceed with usage
        int maxUsageTime1 = rules.getMaxUsageDuration();
        boolean success = resource.use(this);
        if (success) {
        	
        	resource.setusermaxUsageTime(this, resource.getusermaxUsageTime(this)- duration);
            System.out.println(this.getName() + " is using the electronic "
                + "resource for " + duration + " hour(s).\n");
            
         
        
        } else {
            System.out.println("Usage unsuccessful");
        }
    }

    /**
     * Borrows a physical borrowable book.
     *
     * @param book    the book to borrow
     * @param library the library containing the book
     */
    public void borrowBook(Book book, Library library) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot borrow from " + library.getName());
            return;
        }
        if (book instanceof PhysicalBorrowableBook) {
            PhysicalBorrowableBook physicalBook = (PhysicalBorrowableBook) book;

            if (hasOverdueBooks()) {
                System.out.println("Borrowing denied: " + this.getName()
                    + " has overdue books. Not allowed to borrow until "
                    + "penalty is over.");
                return;
            }
            if (physicalBook.isAvailable()) {
                FacultyRules rules = this.getFaculty().getRules();
                int borrowDuration = rules.getBorrowDuration(this.getRole());

                physicalBook.borrow(); // Mark as borrowed
                borrowedBooks.add(physicalBook);
                borrowRecords.put(physicalBook, new BorrowRecord(
                    LocalDate.now(), borrowDuration));

                incrementBorrowCount();
                System.out.println(this.getName() + " borrowed the book: "
                    + physicalBook.getTitle() + " (ISBN: "
                    + physicalBook.getIsbn() + ")");
                System.out.println("Borrowing duration: " + borrowDuration
                    + " days. This is the max for this type of user. "
                    + "Do not borrow it for more time.\n");

            } else {
                System.out.println("The book " + physicalBook.getTitle()
                    + " is not available for borrowing.");
            }
        } else {
            System.out.println("Error: Only physical borrowable books can "
                + "be borrowed.");
        }
    }

    /**
     * Returns a borrowed book, moving it from borrowed to returned
     * history.
     *
     * @param book    the book being returned
     * @param library the library where the book is returned
     */
    public void returnBook(Book book, Library library) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot return books to " + library.getName());
            return;
        }

        if (!(book instanceof PhysicalBorrowableBook)) {
            System.out.println("Error: This book is not a physical "
                + "borrowable book.");
            return;
        }

        PhysicalBorrowableBook physicalBook = (PhysicalBorrowableBook) book;

        // Check if the book was borrowed by the user
        if (!borrowedBooks.contains(physicalBook)) {
            System.out.println("Error: This book is not currently borrowed "
                + "by " + this.getName() + ".");
            return;
        }

        BorrowRecord record = borrowRecords.get(physicalBook);

        // Handle overdue books before returning
        if (record != null && record.isOverdue()) {
            System.out.println("Warning: The book '" + physicalBook.getTitle()
                + "' was returned late!");
            int penaltyDuration = this.getFaculty().getRules()
                .getLatePenaltyDays();
            penaltyEndDate = LocalDate.now().plusDays(penaltyDuration);
            System.out.println("Penalty applied. You cannot borrow books "
                + "until: " + penaltyEndDate);
        }

        // Mark the book as returned
        physicalBook.returnResource();
        borrowedBooks.remove(physicalBook);
        returnedBooks.add(physicalBook);
        System.out.println(this.getName() + " returned the book: '"
            + physicalBook.getTitle() + "' (ISBN: "
            + physicalBook.getIsbn() + ").");
    }

    /**
     * Renews a borrowed book, extending its borrowing duration if
     * eligible.
     *
     * @param book    the book to renew
     * @param library the library where the book was borrowed
     */
    public void renewBook(Book book, Library library) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot renew books in " + library.getName());
            return;
        }

        if (penaltyEndDate != null && LocalDate.now().isBefore(
                penaltyEndDate)) {
            System.out.println("Borrowing denied: You are under penalty "
                + "until " + penaltyEndDate);
            return;
        }

        if (book instanceof PhysicalBorrowableBook) {
            PhysicalBorrowableBook physicalBook = (PhysicalBorrowableBook) book;
            BorrowRecord record = borrowRecords.get(physicalBook);

            if (record == null) {
                System.out.println("Error: You haven't borrowed this book.");
                return;
            }

            FacultyRules rules = this.getFaculty().getRules();
            int maxRenewals = rules.getMaxRenewals(this.getRole());

            if (record.getRenewCount() >= maxRenewals) {
                System.out.println("Renewal denied: Max renewals reached for "
                    + physicalBook.getTitle() + " by " + this.getName());
                return;
            }

            int additionalDays = rules.getBorrowDuration(this.getRole());
            record.renew(additionalDays); // Extend borrowing duration
            System.out.println(this.getName() + " successfully renewed the "
                + "book: " + physicalBook.getTitle());
            System.out.println("New due date: " + record.getBorrowDate()
                .plusDays(record.getDuration()));
        }
    }

    /**
     * Returns the list of books currently borrowed by the user.
     *
     * @return a list of borrowed books
     */
    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    /**
     * Returns the list of books returned by the user.
     *
     * @return a list of returned books
     */
    public List<Book> getReturnedBooks() {
        return new ArrayList<>(returnedBooks);
    }

    /**
     * Searches for books in the specified library by a specific field
     * and value.
     *
     * @param library the library to search in
     * @param field   the field to search (e.g., "isbn", "title", "author")
     * @param value   the value to match
     * @return a list of books that match the criteria
     */
    public List<Book> searchBooks(Library library, String field,
                                  String value) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot search books in " + library.getName());
            return new ArrayList<>();
        }
        return library.searchBooksByField(field, value);
    }

    /**
     * Searches for meeting rooms in the specified library by a specific
     * field and value.
     *
     * @param library the library to search in
     * @param field   the field to search (e.g., "location", "capacity")
     * @param value   the value to match
     * @return a list of meeting rooms that match the criteria
     */
    public List<MeetingRoom> searchRooms(Library library, String field,
                                         String value) {
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot search meeting rooms in " + library.getName());
            return new ArrayList<>();
        }
        return library.searchRoomsByField(field, value);
    }

    /**
     * Abstract method to get the user's role.
     * This must be implemented by subclasses like Student and Professor.
     *
     * @return the user's role (e.g., "Student" or "Professor")
     */
    public abstract String getRole();

    /**
     * Gets the borrow records of the user.
     *
     * @return a map of books to their borrow records
     */
    public Map<Book, BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }
    
    
    //public void renewER(ElectronicResource ER) {
    	//FacultyRules rules = this.getFaculty().getRules();
    	//int maxRenewalsER = rules.getMaxRenewalsER();
 
    	
    //}
    
    public void reserveBook(Book book, Library library) {
    	
        if (!LibrarySystem.canUserAccessLibrary(this, library)) {
            System.out.println("Access denied: " + this.getName()
                + " cannot reserve a book in " + library.getName());
            return;
        }
        else {
        	
        	if (book instanceof PhysicalBorrowableBook) {
        		PhysicalBorrowableBook b = (PhysicalBorrowableBook) book;
            	boolean works = b.reserve(this);
            	if (!works) {
            		System.out.println("Reservation unsuccessful");
            	}
        	}
        	else {
        		System.out.println("You cannot reserve a book that is not of type PhysicalBorrowableBook");
        		return;
        	}
        
        	
        }
    }
}
