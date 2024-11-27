package src;
public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;
    
    private class Node<T> {
       private T val;
       private Node next; 
       private Node prev;

       public Node(T val) {
        this.val = val;
        this.next = null;
       }
    }

    public LinkedListDeque() {
        this.sentinel = new Node<>(null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        size = 0;
    }

    // sentinel <=> sentinel
    // sentinel <= senteinel => newFirst
    // sentinel <= senteine <=> newFirst => sentinel
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

    public void addLast(T val) {
        Node newLast = new Node(val);
        Node last = this.sentinel.prev;

        this.sentinel.prev = newLast;

        newLast.next = this.sentinel;
        newLast.prev = last;

        last.next = newLast;

        size++;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) return null;
        Node first = this.sentinel.next;
        while(index > 0) {
            first = first.next;
            index--;
        }
        return first;
    }

    public Node getRecursive(int index) {
        if (index < 0 || index >= size) return null;
        return getRecursive(index, this.sentinel.next);
    }

    private Node getRecursive(int index, Node cur) {
        if (index == 0) {
            return cur;
        }
        return getRecursive(index - 1, cur.next);
    }

    public Node removeFirst() {
        if (this.sentinel.next == this.sentinel) return null;
        Node first = this.sentinel.next;
        this.sentinel.next = first.next;
        first.next.prev = this.sentinel;
        first.next = null;
        first.prev = null;
        return first;
    }

    public Node removeLast() {
        if (this.sentinel.next == this.sentinel) return null;
        Node last = this.sentinel.prev;
        this.sentinel.prev = last.prev;
        last.prev.next = this.sentinel;
        last.next = null;
        last.prev = null;
        return last;
    }

    public String toString() {
        Node<T> cur = sentinel.next;
        StringBuilder builder = new StringBuilder();
        while(cur != sentinel) {
            builder.append(cur.val);
            cur = cur.next;
        }
        return builder.isEmpty() ? "[]" : builder.toString();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedListDeque list = new LinkedListDeque<>();
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }
}
