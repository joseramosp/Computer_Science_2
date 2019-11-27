/* Problem set 4 and 5 - Problem 6

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

A sentinel node is a dummy node that goes at the front of a list. In a doubly-linked list, the sentinel node points to the first and last elements of the list.

Some advantages to using these nodes:

We no longer need to keep separate pointers for the head and tail of the list, like we had to do with singly-linked lists.
We do not have to worry about updating the head and tail pointers, since as we shall see, this happens automatically if we insert after a sentinel node, hence prepending an item to the list, or insert before a sentinel node, hence appending an item to the list
Modify your implementation of all your list to include a sentinel - SLL, DLL, CLL

*/

public class DoubleLinkedList <E> implements List<E>{
    private DoubleLinkNode<E> head;      // Pointer to list header
    private DoubleLinkNode<E> tail;      // Pointer to last element
    private DoubleLinkNode<E> curr;      // Access to current element
    private int listSize;                // Size of list
    private int currIndex;

    // Constructors
    DoubleLinkedList(){ clear(); }

    public void clear() {
        curr = tail = new DoubleLinkNode<E>(head, null);
        head = new DoubleLinkNode<E>(null, tail);
        currIndex = listSize = 0;
    }

    public boolean insert(E it) {
        curr.setNext(new DoubleLinkNode<E>(curr.element(),curr,curr.next()));
        curr.setElement(it);
        if(tail == curr){
            tail = curr.next();
        }
        listSize++;
        return true;
    }

    public boolean append(E it) {
        tail.setNext(new DoubleLinkNode<E>(null,tail, null));
        tail.setElement(it);
        tail = tail.next();
        listSize++;

        return false;
    }

    public E remove() {
        if(curr == tail){
            return null;
        }
        E it = curr.element();
        curr.prev().setNext(curr.next());
        curr.next().setPrev(curr.prev());
        curr = curr.next();
        listSize--;
        return it;
    }

    public void moveToStart() {
        curr = head.next();
        currIndex = 0;
    }

    public void moveToEnd() { curr = tail;}

    public void prev() {
        if(curr != head.next()) {
            curr = curr.prev();
            currIndex--;
        }
    }

    public void next() {
        if(curr != tail) {
            curr = curr.next();
            currIndex++;
        }
    }

    public int length() {
        return listSize;
    }

    public int currPos() {
        return currIndex;
    }

    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) return false;
        if (currIndex == pos) return true;
        for(int i = currIndex; i > pos; i--){
            prev();
        }
        for(int i = currIndex; i < pos; i--){
            next();
        }
        return true;
    }

    public boolean isAtEnd() {
        return curr == tail;
    }

    public E getValue() {
        return curr.element();
    }

    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public String toString() {
        DoubleLinkNode<E> temp = head.next();
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
}
