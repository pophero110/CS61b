package src;
public class LinkedListDeque<T> {
    private Node sentinel;
    
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
    }


    public void addLast(T val) {
        Node newLast = new Node(val);
        Node last = this.sentinel.prev;

        this.sentinel.prev = newLast;

        newLast.next = this.sentinel;
        newLast.prev = last;

        last.next = newLast;
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

    public static void main(String[] args) {
        LinkedListDeque list = new LinkedListDeque<>();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);
        System.out.println(list);
    }
}
