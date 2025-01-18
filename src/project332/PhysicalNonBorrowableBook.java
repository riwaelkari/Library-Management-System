package project332;

/**
 * Represents a physical book that cannot be borrowed. It can only be accessed inside the library. It extends Book
 */
public class PhysicalNonBorrowableBook extends Book {

    /**
     * Constructs a PhysicalNonBorrowableBook object with the given details.
     *
     * @param title       the title of the book
     * @param author      the author of the book
     * @param isbn        the ISBN of the book
     * @param genre       the genre of the book
     * @param description a brief description of the book
     */
    public PhysicalNonBorrowableBook(String title, String author, String isbn, String genre, String description) {
        super(title, author, isbn, genre, description);
    }


}
