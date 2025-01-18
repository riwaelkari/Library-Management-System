package project332;

/**
 * Represents an electronic book in the library system. It extends Book
 */
public class EBook extends Book {

    /**
     * Constructs an EBook object with the given details.
     *
     * @param title       the title of the eBook
     * @param author      the author of the eBook
     * @param isbn        the ISBN of the eBook
     * @param genre       the genre of the eBook
     * @param description a brief description of the eBook
     */
    public EBook(String title, String author, String isbn, String genre, String description) {
        super(title, author, isbn, genre, description);
    }

    /**
     * Simulates reading the eBook online.
     */
    public void readOnline() {
        System.out.println("The eBook '" + getTitle() + "' is being accessed online.");
    }
}
