package cs61b.set;

/**
 * A generic Set class that defines the operations supported by a set.
 *
 * @param <E> the type of elements maintained by this set
 */
public class Set<E> {

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param element the element to be added
     * @return true if the set did not already contain the element
     */
    public boolean add(E element) {
        // Method specification only, no implementation
        return false;
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param element the element to be removed
     * @return true if the set contained the specified element
     */
    public boolean remove(E element) {
        // Method specification only, no implementation
        return false;
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param element the element to check for presence
     * @return true if the set contains the specified element
     */
    public boolean contains(E element) {
        // Method specification only, no implementation
        return false;
    }

    /**
     * Returns the number of elements in this set (its cardinality).
     *
     * @return the number of elements in this set
     */
    public int size() {
        // Method specification only, no implementation
        return 0;
    }

    /**
     * Removes all elements from this set. The set will be empty after this call.
     */
    public void clear() {
        // Method specification only, no implementation
    }

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if this set is empty
     */
    public boolean isEmpty() {
        // Method specification only, no implementation
        return false;
    }

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {
        var integerSet = new Set<Integer>();

        integerSet.add(12);
        System.out.println(integerSet);
    }
}

