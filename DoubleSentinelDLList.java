// Two Sentinels
public class DoubleSentinelDLList<T> {
    private int size;
    private Node sentinel;
    private Node backSentinel;

    private class Node<T> {
        private T val;
        private Node next;
        private Node prev;
        public Node(T val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public DoubleSentinelDLList() {
        this.sentinel = new Node(null);
        this.backSentinel = new Node(null);
        sentinel.next = backSentinel;
        backSentinel.prev = sentinel;
        size = 0;
    }

    public DoubleSentinelDLList(T val) {
        super();
        Node node = new Node<>(val);
        this.sentinel.next = node;
        this.backSentinel.prev = node;
        size++;
    }

    public void addFirst(T val) {
        Node newFirst = new Node<T>(val);
        Node first = sentinel.next;
        sentinel.next = newFirst;
        newFirst.next = first;
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        Node first = sentinel.next;
        Node newFirst = first.next;
        sentinel.next = newFirst;
        size--;
    }

    public void addLast(T val) {
        Node last = backSentinel.prev;
        Node node = new Node<T>(val);
        if (last == sentinel) {
            backSentinel.prev = node; // set last
            sentinel.next = node; // set first
            node.next = backSentinel;
            node.prev = sentinel;
        } else {
            backSentinel.prev = node; // set new last
            last.next = node; // set prev last
            node.next = backSentinel;
            node.prev = last;
        }
        size++;
    }

    public void removeLast() {
        Node last = backSentinel.prev;
        if (last == sentinel) throw new IllegalStateException("Can not remove from empty list");
        Node newLast = last.prev;
        newLast.next = backSentinel;
        backSentinel.prev = newLast;
        last.next = null;
        last.prev = null;
    }

    public Node getFirst() {
        return sentinel.next;
    }

    public Node getLast() {
       return this.backSentinel.prev;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        Node<T> cur = sentinel.next;
        StringBuilder builder = new StringBuilder();
        while(cur.next != null) {
            builder.append(cur.val);
            cur = cur.next;
        }
        return builder.isEmpty() ? "[]" : builder.toString();
    }


    public static void main(String[] args) {
        DoubleSentinelDLList<Integer> list = new DoubleSentinelDLList<>();
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
