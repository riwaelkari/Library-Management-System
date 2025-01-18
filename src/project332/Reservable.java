package project332;

/**
 * Interface for resources that can be reserved. These include physical borrowable books, meeting rooms, and electronic resources.
 */
public interface Reservable {

    /**
     * Reserves the resource for the specified user.
     *
     * @param user the user who wants to reserve the resource
     * @return true if the reservation is successful, false if the resource is already reserved
     */
    boolean reserve(User user);

    /**
     * Cancels the reservation for the resource.
     *
     * @return true if the cancellation is successful, false otherwise
     */
    boolean cancelReservation(User user);
}
