package project332;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract class representing a general electronic resource in the library.
 * This class implements the Reservable interface to ensure that each resource can be reserved,
 * preventing multiple users from using the same resource at the same time.
 */
public abstract class ElectronicResource implements Reservable {
    private String brand;  // The brand of the electronic resource
    private boolean isReserved; // Indicates whether the resource is currently reserved
    private User reservedBy;  // The user who has reserved the resource: will be used to check if it is the same one trying to use it in the use method
    private Map<User, LocalDateTime> userUsageTimeMap; // Map to track last usage time for each user
    private Map<User, Integer> usermaxUsageTimeMap; // Map to track last usage time for each user
    


    /**
     * Constructs an ElectronicResource with the specified brand.
     *
     * @param brand the brand of the electronic resource
     */
    public ElectronicResource(String brand) {
        this.brand = brand;
        this.isReserved = false;
        this.reservedBy = null;
        this.userUsageTimeMap = new HashMap<>();
        this.usermaxUsageTimeMap = new HashMap<>();
    }

    /**
     * Gets the brand of the electronic resource.
     *
     * @return the brand of the electronic resource
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the electronic resource.
     *
     * @param brand the new brand of the electronic resource
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Checks if the resource is currently reserved.
     *
     * @return true if the resource is reserved, false otherwise
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * Reserves the electronic resource for a user.
     *
     * @param user the user who wants to reserve the resource
     * @return true if the resource is successfully reserved, false if already reserved
     */
    @Override
    public boolean reserve(User user) {
        if (!isReserved) {
            this.isReserved = true;
            this.reservedBy = user;
            return true;
        }
        return false;
    }

    /**
     * Cancels the reservation for the electronic resource.
     *
     * @return true if the reservation is successfully canceled, false if the room was not reserved
     */
    @Override
    public boolean cancelReservation(User user) {
        if (isReserved) {
            this.isReserved = false;
            this.reservedBy = null;
            System.out.println("Electronic resource's reservation successful");
            return true;
        }
        System.out.println("Unfortunateky, electronic resource's reservation was unsuccessful");
        return false;
    }
    
    
    public void setusermaxUsageTime(User user, int duration) {
        usermaxUsageTimeMap.put(user, duration);
    }

    
    public void setuserUsageTime(User user, LocalDateTime now) {
        userUsageTimeMap.put(user, now);
    }

    
  
    public int getusermaxUsageTime(User user) {
        return usermaxUsageTimeMap.getOrDefault(user, 0);
    }
    
    public Map<User, Integer> getusermaxUsageTimeMap() {
        return this.usermaxUsageTimeMap;
    }
    
    
    public LocalDateTime getuserUsageTime(User user) {
        return userUsageTimeMap.getOrDefault(user, LocalDateTime.now());
    }
    /**
     * Returns the user who reserved the resource.
     *
     * @return the user who reserved the resource, or null if not reserved
     */
 
    public User getReservedBy() {
        return reservedBy;
    }

    /**
     * Abstract method for using the electronic resource.
     * Each subclass will implement this method to specify how the resource is used. Note that it takes the user in order to check if the user who
     *  reserved it is the one attempting to use it
     *  @return boolean to indicate whether usage was successful
     */
    public abstract boolean use(User user);

    /**
     * Returns a string representation of the electronic resource, including its brand and reservation status.
     * @return a string representation of the electronic resource
     * 
     * 
     */
    @Override
    public String toString() {
        String reservedByName = "None";
        if (reservedBy != null) {
            reservedByName = reservedBy.getName();
        }
        return "ElectronicResource{" +
                "brand='" + brand + '\'' +
                ", isReserved=" + isReserved +
                ", reservedBy=" + reservedByName +
                '}';
    }

}
