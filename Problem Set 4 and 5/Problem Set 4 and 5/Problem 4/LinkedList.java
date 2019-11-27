/* Problem set 4 and 5 - Problem 4

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Modify the linked list class (from the book or your own version) so that removal, insertion, and size are written
recursively.  Write a test program.

*/

// Linked list implementation
class LinkedList<E> implements List<E> {
    private Link<E> head;      // Pointer to list header
    private Link<E> tail;      // Pointer to last element
    private Link<E> curr;      // Access to current element
    private int listSize;      // Size of list

    // Constructors
    LinkedList(int size) { this(); }     // Constructor -- Ignore size
    LinkedList() { clear(); }

    // Remove all elements
    public void clear() {
        curr = tail = new Link<E>(null); // Create trailer
        head = new Link<E>(tail);        // Create header
        listSize = 0;
    }

    // Insert "it" at current position
    public boolean insert(E it) {
        Link n = head.next();
        insert(it, n);
        if (tail == curr) tail = curr.next();  // New tail
        listSize++;
        return true;
    }

    private void insert(E it, Link<E> n){

        if(n == curr){
            curr.setNext(new Link<E>(curr.element(), curr.next()));
            curr.setElement(it);
        }
        else{
            insert(it, n.next());
        }
    }

    // Append "it" to list
    public boolean append(E it) {
        tail.setNext(new Link<E>(null));
        tail.setElement(it);
        tail = tail.next();
        listSize++;
        return true;
    }

    // Remove and return current element
    public E remove () {
        Link<E> n = head.next();
        if (curr == tail) return null;          // Nothing to remove
        E it = curr.element();                  // Remember value
        remove(n);
        //curr.setElement(curr.next().element()); // Pull forward the next element
        //if (curr.next() == tail) tail = curr;   // Removed last, move tail
        //curr.setNext(curr.next().next());       // Point around unneeded link
        listSize--;                             // Decrement element count
        return it;                              // Return value
    }

    private void remove (Link<E> n){
        if(n == curr){
            curr.setElement(curr.next().element());
            if (curr.next() == tail) tail = curr;
            curr.setNext(curr.next().next());
        }
        else{
            remove(n.next());
        }
    }

    public void moveToStart() { curr = head.next(); } // Set curr at list start
    public void moveToEnd() { curr = tail; }     // Set curr at list end

    // Move curr one step left; no change if now at front
    public void prev() {
        if (head.next() == curr) return; // No previous element
        Link<E> temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) temp = temp.next();
        curr = temp;
    }

    // Move curr one step right; no change if now at end
    public void next() { if (curr != tail) curr = curr.next(); }

    // Return list length
    public int length() {
        Link<E> n = head.next();

        return length(n);
    }
    private int length(Link<E> n) {
        if (n==tail)
            return 0;
        else{
            return 1 + length(n.next());
        }
    }


    // Return the position of the current element
    public int currPos() {
        Link<E> temp = head.next();
        int i;
        for (i=0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    // Move down list to "pos" position
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) return false;
        curr = head.next();
        for(int i=0; i<pos; i++) curr = curr.next();
        return true;
    }

    // Return true if current position is at end of the list
    public boolean isAtEnd() { return curr == tail; }

    // Return current element value. Note that null gets returned if curr is at the tail
    public E getValue() {
        return curr.element();
    }

    public String toString() {
        Link<E> temp = head.next();
        StringBuffer out = new StringBuffer((listSize + 1) * 4);

        out.append("< ");
        for (int i = 0; i < currPos(); i++) {
            out.append(temp.element());
            out.append(" ");
            temp = temp.next();
        }
        out.append("| ");
        for (int i = currPos(); i < listSize; i++) {
            out.append(temp.element());
            out.append(" ");
            temp = temp.next();
        }
        out.append(">");
        return out.toString();
    }

    //Tell if the list is empty or not
    public boolean isEmpty() {
        return listSize == 0;
    }
}