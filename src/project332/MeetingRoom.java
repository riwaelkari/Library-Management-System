package project332;

/**
 * Represents a meeting room in a library that can be reserved by users.
 * Meeting rooms have attributes like name, location, and capacity.
 * They implement the Reservable interface to support reservation functionality.
 */
public class MeetingRoom implements Reservable {
    private String name;
    private String location; 
    private int capacity; 
    private boolean isReserved; // Indicates whether the room is currently reserved

    /**
     * Constructs a MeetingRoom with the specified details.
     *
     * @param name     the name of the meeting room
     * @param location the physical location of the meeting room
     * @param capacity the maximum capacity of the meeting room
     */
    public MeetingRoom(String name, String location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.isReserved = false; // Initially, the room is not reserved
    }

    /**
     * Gets the name of the meeting room.
     *
     * @return the name of the meeting room
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the location of the meeting room.
     *
     * @return the physical location of the meeting room
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the capacity of the meeting room.
     *
     * @return the maximum capacity of the meeting room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Checks whether the meeting room is currently reserved.
     *
     * @return true if the room is reserved, false otherwise
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * Reserves the meeting room without specifying a user.
     * This method is kept for compatibility with the Reservable interface.
     *
     * @return true if the room is successfully reserved, false if it is already reserved
     */
    @Override
    public boolean reserve(User user) {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Room reservation successful");
            return true;
        }
        return false;
    }

    /**
     * Cancels the reservation of the meeting room.
     *
     * @return true if the reservation is successfully canceled, false if the room was not reserved
     */
    @Override
    public boolean cancelReservation(User user) {
        if (isReserved) {
            isReserved = false;
            System.out.println("Room cancelation successful");
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the meeting room, including its name, location, capacity,
     * and reservation status.
     *
     * @return a string representation of the meeting room
     */
    @Override
    public String toString() {
        return "MeetingRoom{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", isReserved=" + isReserved +
                '}';
    }
}
