package project332;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The PhysicalBorrowableBook class represents a physical book in the library system that
 * can be borrowed and reserved by users. It inherits from the abstract Book class, which provides shared attributes
 * like title, author, ISBN, genre, and description. This class also implements the Borrowable and Reservable interfaces,
 * enabling borrowing-related behavior and reservation management.
 */
public class PhysicalBorrowableBook extends Book implements Borrowable, Reservable {
    private boolean isAvailable; // Availability status of the book
    private Queue<User> waitingList; // Waiting list for reservations

    /**
     * Constructs a PhysicalBorrowableBook object with the given details.
     *
     * @param title       the title of the book
     * @param author      the author of the book
     * @param isbn        the ISBN of the book
     * @param genre       the genre of the book
     * @param description a brief description of the book
     * @param isAvailable the initial availability status of the book
     */
    public PhysicalBorrowableBook(String title, String author, String isbn, String genre, String description, boolean isAvailable) {
        super(title, author, isbn, genre, description);
        this.isAvailable = isAvailable;
        this.waitingList = new LinkedList<>();
    }

    /**
     * Checks if the book is available for borrowing.
     *
     * @return true if the book is available, false otherwise
     */
    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param isAvailable the new availability status
     */
    @Override
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Marks the book as borrowed.
     */
    @Override
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            incrementBorrowCount(); // Increment borrow count
            System.out.println("Borrowing successful.");
        } else {
            System.out.println("Borrowing failed. The book is currently unavailable.");
        }
    }

    /**
     * Marks the book as returned. If there are users in the waiting list, assigns the book to the next user.
     */
    @Override
    public void returnResource() {
        if (!isAvailable) {
            if (!waitingList.isEmpty()) {
                User nextUser = waitingList.poll(); //to safely remove
                System.out.println("The book '" + getTitle() + "' is now assigned to " + nextUser.getName());
            } 
            else {
                isAvailable = true;
                System.out.println("The book '" + getTitle() + "' has been returned and is now available.");
            }
        } 
        else {
            System.out.println("The book '" + getTitle() + "' was not borrowed, so it cannot be returned.");
        }
    }

    /**
     * Reserves the book for the specified user by adding them to the waiting list.
     *
     * @param user the user requesting the reservation
     * @return true if the reservation is successful, false otherwise
     */
    @Override
    public boolean reserve(User user) {
        if (isAvailable()) {
            System.out.println("The book '" + getTitle() + "' is currently available. No reservation needed.");
            return false; // Reservation not required if the book is available
        }
        if (waitingList.contains(user)) {
            System.out.println(user.getName() + " is already in the waiting list for the book '" + getTitle() + "'.");
            return false;
        }
        waitingList.add(user);
        System.out.println(user.getName() + " has been added to the waiting list for the book '" + getTitle() + "'.");
        return true;
    }

    /**
     * Cancels the reservation for the specified user by removing them from the waiting list.
     *
     * @param user the user canceling the reservation
     * @return true if the cancellation is successful, false otherwise
     */
    @Override
    public boolean cancelReservation(User user) {
        if (waitingList.remove(user)) {
            System.out.println(user.getName() + "'s reservation for the book '" + getTitle() + "' has been canceled.");
            return true;
        }
        System.out.println(user.getName() + " does not have a reservation for the book '" + getTitle() + "'.");
        return false;
    }
}
