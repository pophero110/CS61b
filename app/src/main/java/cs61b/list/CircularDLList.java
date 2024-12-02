package cs61b.list;
public class CircularDLList<T> {
    private int size;
    private final Node<T> sentinel;

    private static class Node<T> {
        T val;
        Node<T> next;
        Node<T> prev;

        Node(T val) {
            this.val = val;
        }
    }

    public CircularDLList() {
        sentinel = new Node<>(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public CircularDLList(T val) {
        this();
        addLast(val);
    }

    public void addFirst(T val) {
        Node<T> newNode = new Node<>(val);
        // inject node in the front
        newNode.next = sentinel.next;
        newNode.prev = sentinel;

        // shift front node to second
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        Node<T> first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
    }

    public void addLast(T val) {
        Node<T> newNode = new Node<>(val);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        Node<T> last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return sentinel.next.val;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return sentinel.prev.val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = sentinel.next;
        while (current != sentinel) {
            builder.append(current.val);
            current = current.next;
            if (current != sentinel) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        CircularDLList<Integer> list = new CircularDLList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println(list);  // [1, 2, 3]
        
        list.removeFirst();
        System.out.println(list);  // [2, 3]
        
        list.removeLast();
        System.out.println(list);  // [2]
    }
}