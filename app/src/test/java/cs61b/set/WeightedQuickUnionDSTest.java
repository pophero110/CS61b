package cs61b.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightedQuickUnionDSTest {
    private WeightedQuickUnionDS weightedQuickUnion;

    @BeforeEach
    void setUp() {
        weightedQuickUnion = new WeightedQuickUnionDS(10);  // Initialize with 10 elements (0 to 9)
    }

    @Test
    void testInitialConnection() {
        // Initially, no elements should be connected
        assertFalse(weightedQuickUnion.isConnected(0, 1), "Elements 0 and 1 should not be connected initially");
    }

    @Test
    void testConnect() {
        // Connect elements 0 and 1
        weightedQuickUnion.connect(0, 1);

        // After connecting, elements 0 and 1 should be connected
        assertTrue(weightedQuickUnion.isConnected(0, 1), "Elements 0 and 1 should be connected after calling connect(0, 1)");
    }

    @Test
    void testMultipleConnections() {
        // Connect 0 and 1, then 1 and 2
        weightedQuickUnion.connect(0, 1);
        weightedQuickUnion.connect(1, 2);

        // Elements 0 and 2 should be connected indirectly
        assertTrue(weightedQuickUnion.isConnected(0, 2), "Elements 0 and 2 should be connected after connecting 0-1 and 1-2");
    }

    @Test
    void testDisconnectedElements() {
        // Elements 3 and 4 should not be connected initially
        assertFalse(weightedQuickUnion.isConnected(3, 4), "Elements 3 and 4 should not be connected initially");
    }

    @Test
    void testSelfConnection() {
        // A single element should always be connected to itself
        assertTrue(weightedQuickUnion.isConnected(5, 5), "Element 5 should be connected to itself");
    }

    @Test
    void testNoConnectionAfterNonConnect() {
        // Connect 0 and 1, but don't connect 2
        weightedQuickUnion.connect(0, 1);

        // Elements 1 and 2 should not be connected
        assertFalse(weightedQuickUnion.isConnected(1, 2), "Elements 1 and 2 should not be connected");
    }

    // Additional test cases can be written to cover more edge cases or performance testing

}