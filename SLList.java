
public class SLList<T> {
    private int size;
    private Node sentinel;

    private class Node<T> {
        private T val;
        private Node next;
        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }

    public SLList() {
        this.sentinel = new Node(null);
        size = 0;
    }

    public SLList(T val) {
        this.sentinel = new Node<T>(null);
        Node first = new Node<>(val);
        this.sentinel.next = first;
        size++;
    }

    public void addFirst(T val) {
        Node newFirst = new Node<T>(val);
        Node first = sentinel.next;
        sentinel.next = newFirst;
        newFirst.next = first;
        size++;
    }

    public void addLast(T val) {
        Node last = getLast();
        if (last != null) {
            last.next = new Node<T>(val);
        } else {
            sentinel = new Node<T>(val);
        }
        size++;
    }

    public Node getSentinel() {
        return sentinel;
    }

    public Node getLast() {
        Node cur = this.sentinel;
        while(cur != null & cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        Node<T> cur = sentinel.next;
        StringBuilder builder = new StringBuilder();
        while(cur != null) {
            builder.append(cur.val);
            cur = cur.next;
        }
        return builder.isEmpty() ? "[]" : builder.toString();
    }


    public static void main(String[] args) {
       SLList<Integer> list = new SLList(1);
       list.addFirst(2);
    //    System.out.println(list); // 21
    //    System.out.println(list.getSize()); // 2
    //    System.out.println(list.getFirst().val); // 2
    //    System.out.println(list.getLast().val); // 1

       SLList<Integer> emptyList = new SLList();
    //    System.out.println(emptyList); // 21
    //    System.out.println(emptyList.getSize()); // 2
    //    System.out.println(emptyList.getFirst()); // 2
    //    System.out.println(emptyList.getLast()); // 1
    //    emptyList.addFirst(1);
    //    emptyList.addLast(2);
    //    emptyList.addLast(3);
    //    System.out.println(emptyList);
    //    System.out.println(emptyList.getLast().val);
    //    System.out.println(emptyList.getSize());

       emptyList.addFirst(1);
       emptyList.addFirst(2);
       emptyList.addFirst(3);
       System.out.println(emptyList);
       System.out.println(emptyList.getLast().val);
       System.out.println(emptyList.getSize());
    }
}
