package cs61b.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WQUWithPathCompressionTest {
    private WQUWithPathCompression wquWithPathCompression;

    @BeforeEach
    void setUp() {
        wquWithPathCompression = new WQUWithPathCompression(10);  // Initialize with 10 elements (0 to 9)
    }

    @Test
    void testInitialConnection() {
        // Initially, no elements should be connected
        assertFalse(wquWithPathCompression.isConnected(0, 1), "Elements 0 and 1 should not be connected initially");
    }

    @Test
    void testConnect() {
        // Connect elements 0 and 1
        wquWithPathCompression.connect(0, 1);

        // After connecting, elements 0 and 1 should be connected
        assertTrue(wquWithPathCompression.isConnected(0, 1), "Elements 0 and 1 should be connected after calling connect(0, 1)");
    }

    @Test
    void testMultipleConnections() {
        // Connect 0 and 1, then 1 and 2
        wquWithPathCompression.connect(0, 1);
        wquWithPathCompression.connect(1, 2);

        // Elements 0 and 2 should be connected indirectly
        assertTrue(wquWithPathCompression.isConnected(0, 2), "Elements 0 and 2 should be connected after connecting 0-1 and 1-2");
    }

    @Test
    void testDisconnectedElements() {
        // Elements 3 and 4 should not be connected initially
        assertFalse(wquWithPathCompression.isConnected(3, 4), "Elements 3 and 4 should not be connected initially");
    }

    @Test
    void testSelfConnection() {
        // A single element should always be connected to itself
        assertTrue(wquWithPathCompression.isConnected(5, 5), "Element 5 should be connected to itself");
    }

    @Test
    void testNoConnectionAfterNonConnect() {
        // Connect 0 and 1, but don't connect 2
        wquWithPathCompression.connect(0, 1);

        // Elements 1 and 2 should not be connected
        assertFalse(wquWithPathCompression.isConnected(1, 2), "Elements 1 and 2 should not be connected");
    }

    @Test
    void testPathCompression() {
        // Connect 0 and 1, then 1 and 2
        wquWithPathCompression.connect(0, 1);
        wquWithPathCompression.connect(2, 3);
        wquWithPathCompression.connect(0, 2);

        wquWithPathCompression.connect(4, 5);
        wquWithPathCompression.connect(6, 7);
        wquWithPathCompression.connect(4, 6);

        wquWithPathCompression.connect(0, 4);
        assertTrue(wquWithPathCompression.isConnected(0, 1), "Elements 0 and 2 should be " +
                "connected after connecting 0-1 and 1-2");
        assertTrue(wquWithPathCompression.isConnected(0, 2), "Elements 0 and 2 should be connected after connecting 0-1 and 1-2");
        assertEquals(wquWithPathCompression.toString(), "[7, 7, 7, 7, 7, 7, 7, -4, -1, -1]");
    }
}