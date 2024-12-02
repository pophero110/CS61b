package cs61b.list;

import java.util.Arrays;

/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

 public class AList {
    int[] intList;
    int size;
    /** Creates an empty list. */
    public AList() {
        this.intList = new int[100];
        this.size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == intList.length) {
           resize(size * 2);
        }
        this.intList[size] = x;
        size++;
    }

    private void resize(int size) {
        int[] newList = new int[size];
        System.arraycopy(intList, 0, newList, 0, this.size);
        this.intList = newList;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return this.intList[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return this.intList[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int item = getLast();
        if ((this.size / this.intList.length) <= 0.3) {
            resize(size / 2);
        }
        size--;
        return item;
    }

    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[6];
        System.arraycopy(src, 0, dest, 0, 0); 
        System.out.println(Arrays.toString(dest));

        int[] emtpy = new int[0];
        System.out.println(Arrays.toString(emtpy));
        System.out.println(emtpy.length);
    }
} 