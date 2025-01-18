package project332;

/**
 * The Borrowable interface defines a contract for any resource that can be borrowed.
 * This ensures consistent behavior across all borrowable entities,
 *  such as physical books and other resources in the library
 *   Even though right now the library only has books as something that can be borrowed, I think that for the sake of scalability it is better
 *    to have this interface since we might add other borrowable items to the library like DVDs, or we may make tablets borrowable too.
 */
public interface Borrowable {
    /**
     * Checks if the resource is available for borrowing.
     *
     * @return true if the resource is available, false otherwise
     */
    public boolean isAvailable();
    
    
    /**
     * To set the resource's availability
     */
    void setAvailable(boolean isAvailable);

    /**
     * Marks the resource as borrowed and not available. This is called when user.borrow(book) is called
     */
    public void borrow();

    /**
     * Marks the resource as returned and thus available. This is called when user.returnResource(book) is called.
     */
    public void returnResource();
}
