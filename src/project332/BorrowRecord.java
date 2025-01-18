package project332;

import java.time.LocalDate;

/**
 * Class to represent borrowing records for books.
 * Tracks the borrow date, allowed duration, and renewals.
 */
public class BorrowRecord {
    private LocalDate borrowDate; // Date when the book was borrowed
    private int duration; // Allowed borrowing duration in days
    private int renewCount; // Number of times the book has been renewed

    /**
     * Constructs a BorrowRecord with the specified borrow date and duration.
     *
     * @param borrowDate the date the book was borrowed
     * @param duration   the allowed borrowing duration in days
     */
    public BorrowRecord(LocalDate borrowDate, int duration) {
        this.borrowDate = borrowDate;
        this.duration = duration;
        this.renewCount = 0; // Initialize renew count to 0
    }

    /**
     * Gets the borrow date.
     *
     * @return the borrow date
     */
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    /**
     * Gets the allowed borrowing duration.
     *
     * @return the borrowing duration in days
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Checks if the book is overdue.
     *
     * @return true if the book is overdue, false otherwise
     */
    public boolean isOverdue() {
        LocalDate dueDate = borrowDate.plusDays(duration);
        return LocalDate.now().isAfter(dueDate);
    }

    /**
     * Gets the number of times the book has been renewed.
     *
     * @return the renew count
     */
    public int getRenewCount() {
        return renewCount;
    }

    /**
     * Renews the borrowing record, extending the duration.
     *
     * @param additionalDays the number of days to add for renewal
     */
    public void renew(int additionalDays) {
        if (additionalDays < 0) {
            borrowDate = borrowDate.plusDays(additionalDays); // Adjust borrowDate for negative days
        } else {
            duration += additionalDays; // Extend the borrowing duration
            renewCount++; // Increment the renew count
        }
    }
}
