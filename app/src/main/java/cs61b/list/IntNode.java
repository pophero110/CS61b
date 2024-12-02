package cs61b.list;

public class IntNode {
    public int val;
    public IntNode next;

    public IntNode(int val) {
       this.val = val; 
    }

    public IntNode(int val, IntNode next) {
        this.val = val; 
        this.next = next;
    }

    public IntNode addFirst(int val) {
        IntNode newNode = new IntNode(val);
        newNode.next = this;
        return newNode;
    }

    public IntNode addLast(int val) {
        IntNode newNode = new IntNode(val);
        IntNode cur = this;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        return newNode;
    }
    
    public IntNode removeFirst() {
        IntNode temp = this.next;
        this.next = null;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntNode cur = this;
        while(cur != null) {
           sb.append(cur.val);
           cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntNode listNode = new IntNode(2);
        IntNode head = new IntNode(1);
        head.next = listNode;
        System.out.println(head);

        head = head.addFirst(0);
        System.out.println(head);

        head.addLast(3);
        System.out.println(head);

        head = head.removeFirst();
        System.out.println(head);
    }
}