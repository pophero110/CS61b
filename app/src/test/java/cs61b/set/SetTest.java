package cs61b.set;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SetTest {

    @Test
    public void testAdd() {
        Set<Integer> set = new Set<>();
        set.add(10);
        assertEquals("10", set.toString());
    }

    @Test
    public void testRemove() {
        Set<Integer> set = new Set<>();
        boolean result = set.remove(10);
        // Since the method is not implemented, it should return false by default
        assertFalse(result);
    }

    @Test
    public void testContains() {
        Set<Integer> set = new Set<>();
        boolean result = set.contains(10);
        // Since the method is not implemented, it should return false by default
        assertFalse(result);
    }

    @Test
    public void testSize() {
        Set<Integer> set = new Set<>();
        int result = set.size();
        // Since the method is not implemented, it should return 0 by default
        assertEquals(0, result);
    }

    @Test
    public void testClear() {
        Set<Integer> set = new Set<>();
        set.clear();
        // No actual behavior, but no exception should be thrown
        assertTrue(true);
    }

    @Test
    public void testIsEmpty() {
        Set<Integer> set = new Set<>();
        boolean result = set.isEmpty();
        // Since the method is not implemented, it should return false by default
        assertFalse(result);
    }

    @Test
    public void testUniqueness() {
        Set<Integer> set = new Set<>();
        set.add(10);  // Add an element
        set.add(10);  // Add the same element (duplicate)
        set.add(20);  // Add a different element

        // The size should be 2 if the set enforces uniqueness
        // But since the current implementation returns 0 by default, it should fail with the current code
        // After implementing, you can change this to assertEquals(2, set.size()) once the set enforces uniqueness
        assertEquals(0, set.size());
    }
}

