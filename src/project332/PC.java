package project332;

/**
 * Represents a PC as a type of electronic resource in the library. It inherits from ElectronicResource.
 * The PC can be reserved and used by a user.
 */
public class PC extends ElectronicResource {
    private String labRoom;  // The lab room where the PC is located

    /**
     * Constructs a PC with the specified brand and lab room.
     *
     * @param brand    the brand of the PC
     * @param labRoom  the lab room where the PC is located
     */
    public PC(String brand, String labRoom) {
        super(brand);  // Call the constructor of the parent class (ElectronicResource)
        this.labRoom = labRoom;
    }

    /**
     * Gets the lab room where the PC is located.
     *
     * @return the lab room where the PC is located
     */
    public String getLabRoom() {
        return labRoom;
    }

    /**
     * Sets the lab room where the PC is located.
     *
     * @param labRoom the new lab room where the PC is located
     */
    public void setLabRoom(String labRoom) {
        this.labRoom = labRoom;
    }

    /**
     * Implements the use() method for a PC.
     * Describes how a PC is used in the library, checking if the user who reserved it is trying to use it.
     *
     * @param user the user who is trying to use the PC
     */
    @Override
    public boolean use(User user) {
        if (isReserved()) {
            if (getReservedBy() == user) {
                System.out.println(user.getName() + " is using the PC in lab room: " + labRoom);
                return true;
            } else {
                System.out.println(user.getName() + " cannot use the PC, as it is reserved by someone else.");
                return false;
            }
        } else {
            System.out.println("The PC in lab room " + labRoom + " is not reserved and is available for use. Reserve first and then use it.");
            return false;
        }
    }

    @Override
    public String toString() {
        String reservedByName = "None";
        if (getReservedBy() != null) {
            reservedByName = getReservedBy().getName();
        }
        return "PC{" +
                "brand='" + getBrand() + '\'' +
                ", labRoom='" + labRoom + '\'' +
                ", isReserved=" + isReserved() +
                ", reservedBy=" + reservedByName +
                '}';
    }
}
