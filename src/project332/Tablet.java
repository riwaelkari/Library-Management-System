package project332;

/**
 * Represents a Tablet as a type of electronic resource in the library.It inherits from ElectronicResource.
 * The Tablet can be reserved and used by a user.
 */
public class Tablet extends ElectronicResource {
    private String shelf;  // The shelf where the Tablet is stored

    /**
     * Constructs a Tablet with the specified brand and shelf location.
     *
     * @param brand the brand of the Tablet
     * @param shelf the shelf where the Tablet is stored
     */
    public Tablet(String brand, String shelf) {
        super(brand);  
        this.shelf = shelf;
    }

    /**
     * Gets the shelf where the Tablet is stored.
     *
     * @return the shelf where the Tablet is stored
     */
    public String getShelf() {
        return shelf;
    }

    /**
     * Sets the shelf where the Tablet is stored.
     *
     * @param shelf the new shelf where the Tablet is stored
     */
    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    /**
     * Implements the use() method for a Tablet.
     * Describes how a Tablet is used in the library, checking if the user who reserved it is trying to use it.
     *
     * @param user the user who is trying to use the Tablet
     */
    @Override
    public boolean use(User user) {
        if (isReserved()) {
            if (getReservedBy() == user) {
                System.out.println(user.getName() + " is using the Tablet stored on shelf: " + shelf);
                return true;
            } else {
                System.out.println(user.getName() + " cannot use the Tablet, as it is reserved by someone else.");
                return false;
            }
        } else {
            System.out.println("The Tablet on shelf " + shelf + " is not reserved and is available for use.");
            return false;
        }
    }

    @Override
    public String toString() {
        String reservedByName = "None";
        if (getReservedBy() != null) {
            reservedByName = getReservedBy().getName();
        }
        return "Tablet{" +
                "brand='" + getBrand() + '\'' +
                ", shelf='" + shelf + '\'' +
                ", isReserved=" + isReserved() +
                ", reservedBy=" + reservedByName +
                '}';
    }
}
