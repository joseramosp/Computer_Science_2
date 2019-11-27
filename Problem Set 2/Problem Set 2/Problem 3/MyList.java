/* Problem set 2 - Problem 3

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

In the textbook implementation of the Array-based list, adding something to the list is not guaranteed to be successful
- it returns false is the array is full. Implement your own version of an array-based list but allow for an unlimited
capacity. When an item is added to your list, if the list is more than 75% filled, double the size of the array. When
items are removed from the list, if the list is less than 25% filled, cut the size of the array in half. When you change
the size of the array, you will need to create a new array and copy values from one to the other.
*/

import java.lang.*;
import java.util.*;

public class MyList<E> {

    private E listArray[];                      // Array holding list elements
    private static final int DEFAULT_SIZE = 10; // Default size
    private int maxSize;                        // Maximum size of list
    private int listSize;                       // Current # of list items
    private int curr;                           // Position of current element

    @SuppressWarnings("unchecked") // Generic array allocation
    MyList(int size) {
        maxSize = size;
        listSize = curr = 0;
        listArray = (E[])new Object[size];         // Create listArray
    }
    // Create a list with the default capacity
    MyList() { this(DEFAULT_SIZE); }          // Just call the other constructor

    public void clear()                     // Reinitialize the list
    { listSize = curr = 0; }              // Simply reinitialize values

    // Insert "it" at current position
    public boolean insert(E it) {
        if (listSize >= maxSize) return false;
        for (int i=listSize; i>curr; i--)  // Shift elements up
            listArray[i] = listArray[i-1];   //   to make room
        listArray[curr] = it;
        listSize++;                        // Increment list size
        return true;
    }

    // Append "it" to list
    public boolean append(E it) {
        if (listSize >= maxSize) return false;
        listArray[listSize++] = it;
        if((3*maxSize)/4 <= listSize) {
            maxSize *= 2;
            E[] tempList = listArray;
            listArray = (E[])new Object[maxSize];
            for(int i = 0; i<tempList.length; i++){
                listArray[i] = tempList[i];
            }
        }
        return true;
    }

    // Remove and return the current element
    public E remove() {
        if ((curr<0) || (curr>=listSize))  // No current element
            return null;
        E it = listArray[curr];            // Copy the element
        for(int i=curr; i<listSize-1; i++) // Shift them down
            listArray[i] = listArray[i+1];
        listSize--;                        // Decrement size

        if(listSize <= maxSize/4){
            maxSize /= 2;
            E[] tempList = listArray;
            listArray = (E[])new Object[maxSize];
            for(int i = 0; i<listSize; i++){
                listArray[i] = tempList[i];
            }
        }
        return it;
    }

    public void moveToStart() { curr = 0; }       // Set to front
    public void moveToEnd() { curr = listSize; }  // Set at end
    public void prev() { if (curr != 0) curr--; } // Move left
    public void next() { if (curr < listSize) curr++; } // Move right
    public int length() { return listSize; }      // Return list size
    public int currPos() { return curr; }         // Return current position

    // Set current list position to "pos"
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) return false;
        curr = pos;
        return true;
    }

    // Return true if current position is at end of the list
    public boolean isAtEnd() { return curr == listSize; }

    // Return the current element
    public E getValue() {
        if ((curr < 0) || (curr >= listSize)) // No current element
            return null;
        return listArray[curr];
    }

    public void printList(){

        System.out.print("List: { ");
        for(int i = 0; i<listSize; i++){
            System.out.print(listArray[i] + " ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        MyList<Integer> test = new MyList<Integer>(5);

        System.out.println("Current list max size: " + test.maxSize);
        test.append(20);
        test.append(40);
        test.append(1);
        test.append(5);
        test.append(30);
        test.append(30);
        test.printList();
        System.out.println("Current list max size: " + test.maxSize);
        System.out.println("Current list size: " + test.length());
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        test.remove();
        System.out.println("-----------------------");
        test.printList();
        System.out.println("Current list max size: " + test.maxSize);
        System.out.println("Current list size: " + test.length());
    }
}
