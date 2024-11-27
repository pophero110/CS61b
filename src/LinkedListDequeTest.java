package src;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

class LinkedListDequeTest {
    private LinkedListDeque<Integer> intList;
    private LinkedListDeque<String> stringList;

    @BeforeEach
    void setUp() {
        intList = new LinkedListDeque<>();
        stringList = new LinkedListDeque<>();
    }

    @Test
    void testAddFirstToEmptyList() {
        intList.addFirst(42);
        assertThat(intList.toString()).isEqualTo("42");
    }

    @Test
    void testAddFirstMultipleElements() {
        intList.addFirst(1);
        intList.addFirst(2);
        intList.addFirst(3);
        assertThat(intList.toString()).isEqualTo("321");
    }

    @Test
    void testAddFirstWithDifferentTypes() {
        stringList.addFirst("hello");
        stringList.addFirst("world");
        assertThat(stringList.toString()).isEqualTo("worldhello");
    }

    @Test
    void testAddFirstPreservesListCircularity() {
        intList.addFirst(1);
        intList.addFirst(2);
        
        // Use reflection to check sentinel and node connections
        try {
            java.lang.reflect.Field sentinelField = LinkedListDeque.class.getDeclaredField("sentinel");
            sentinelField.setAccessible(true);
            Object sentinel = sentinelField.get(intList);
            
            java.lang.reflect.Field nextField = sentinel.getClass().getDeclaredField("next");
            nextField.setAccessible(true);
            Object firstNode = nextField.get(sentinel);
            
            java.lang.reflect.Field prevField = firstNode.getClass().getDeclaredField("prev");
            prevField.setAccessible(true);
            Object firstNodePrev = prevField.get(firstNode);
            
            assertThat(firstNodePrev)
                .isSameInstanceAs(sentinel);
            
            java.lang.reflect.Field valField = firstNode.getClass().getDeclaredField("val");
            valField.setAccessible(true);
            assertThat(valField.get(firstNode)).isEqualTo(2);
        } catch (Exception e) {
            assertWithMessage("Reflection error in circular list test")
                .that(e).isNull();
        }
    }

    @Test
    void testAddFirstNullElement() {
        intList.addFirst(null);
        assertThat(intList.toString()).isEqualTo("null");
    }

    @Test
    void testAddFirstManyElements() {
        for (int i = 0; i < 1000; i++) {
            intList.addFirst(1);
        }
        assertThat(intList.toString().length()).isEqualTo(1000);
    }

    @Test
    void testAddFirstConsecutively() {
        intList.addFirst(1);
        intList.addFirst(2);
        intList.addFirst(3);
        intList.addFirst(4);
        assertThat(intList.toString()).isEqualTo("4321");
    }

    // addLast Tests
    @Test
    void testAddLastToEmptyList() {
        intList.addLast(42);
        assertThat(intList.toString()).isEqualTo("42");
    }

    @Test
    void testAddLastMultipleElements() {
        intList.addLast(1);
        intList.addLast(2);
        intList.addLast(3);
        assertThat(intList.toString()).isEqualTo("123");
    }

    @Test
    void testAddLastWithDifferentTypes() {
        stringList.addLast("hello");
        stringList.addLast("world");
        assertThat(stringList.toString()).isEqualTo("helloworld");
    }

    @Test
    void testAddLastPreservesListCircularity() {
        intList.addLast(1);
        intList.addLast(2);
        
        // Use reflection to check sentinel and node connections
        try {
            java.lang.reflect.Field sentinelField = LinkedListDeque.class.getDeclaredField("sentinel");
            sentinelField.setAccessible(true);
            Object sentinel = sentinelField.get(intList);
            
            java.lang.reflect.Field prevField = sentinel.getClass().getDeclaredField("prev");
            prevField.setAccessible(true);
            Object lastNode = prevField.get(sentinel);
            
            java.lang.reflect.Field nextField = lastNode.getClass().getDeclaredField("next");
            nextField.setAccessible(true);
            Object lastNodeNext = nextField.get(lastNode);
            
            assertThat(lastNodeNext)
                .isSameInstanceAs(sentinel);
            
            java.lang.reflect.Field valField = lastNode.getClass().getDeclaredField("val");
            valField.setAccessible(true);
            assertThat(valField.get(lastNode)).isEqualTo(2);
        } catch (Exception e) {
            assertWithMessage("Reflection error in circular list test")
                .that(e).isNull();
        }
    }

    @Test
    void testAddLastNullElement() {
        intList.addLast(null);
        assertThat(intList.toString()).isEqualTo("null");
    }

    @Test
    void testAddLastManyElements() {
        for (int i = 0; i < 1000; i++) {
            intList.addLast(1);
        }
        assertThat(intList.toString().length()).isEqualTo(1000);
    }

    @Test
    void testAddLastConsecutively() {
        intList.addLast(1);
        intList.addLast(2);
        intList.addLast(3);
        intList.addLast(4);
        assertThat(intList.toString()).isEqualTo("1234");
    }

    @Test
    void testMixedAddFirstAndAddLast() {
        intList.addFirst(1);
        intList.addLast(2);
        intList.addFirst(3);
        intList.addLast(4);
        assertThat(intList.toString()).isEqualTo("3124");
    }
}