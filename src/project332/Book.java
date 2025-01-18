package project332;

/**
 * Abstract base class representing a book in the library system.
 * This class can be extended to implement specific behaviors for different types of books.
 */
public abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String description;
    private int borrowCount; // Number of times this book has been borrowed

    /**
     * Constructs a Book object with the specified details.
     *
     * @param title       the title of the book
     * @param author      the author of the book
     * @param isbn        the unique ISBN of the book
     * @param genre       the genre of the book
     * @param description a brief description of the book
     */
    public Book(String title, String author, String isbn, String genre, String description) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.description = description;
        borrowCount = 0;
    }

    /**
     * Gets the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the new author of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the new ISBN of the book
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the genre of the book.
     *
     * @return the genre of the book
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre the new genre of the book
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the description of the book.
     *
     * @return the description of the book
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the book.
     *
     * @param description the new description of the book
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets the borrow count(nb of times borrowed) of the book.
     *
     * @return the borrowCount of the book
     */
    public int getBorrowCount() {
        return borrowCount;
    }
    
    
    /**
     * Increments the borrow count(nb of times borrowed) of the book.
     *
     */
    public void incrementBorrowCount() {
        borrowCount++;
    }

    /**
     * Provides a string representation of the book.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * Determines if this book is equal to another object based on ISBN.
     *
     * @param obj the object to compare with this book
     * @return true if the books have the same ISBN, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return isbn.equals(book.isbn);
    }

    /**
     * Returns the hash code for this book, based on ISBN.
     *
     * @return the hash code for this book
     */
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
