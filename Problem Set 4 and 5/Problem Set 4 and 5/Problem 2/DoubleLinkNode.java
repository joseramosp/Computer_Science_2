public class DoubleLinkNode<E>{
    private E e;                    // Value for this node
    private DoubleLinkNode<E> n;    // Pointer to next node in list
    private DoubleLinkNode<E> p;    // Pointer to previous node

    // Constructors
    DoubleLinkNode(E it, DoubleLinkNode<E> inp, DoubleLinkNode<E> inn) { e = it;  p = inp; n = inn; }
    DoubleLinkNode(DoubleLinkNode<E> inp, DoubleLinkNode<E> inn) { p = inp; n = inn; }

    // Get and set methods for the data members
    public E element() { return e; }                                                     // Return the value
    public E setElement(E it) { return e = it; }                                         // Set element value
    public DoubleLinkNode<E> next() { return n; }                                        // Return next DoubleLinkNode
    public DoubleLinkNode<E> setNext(DoubleLinkNode<E> nextVal) { return n = nextVal; }  // Set next DoubleLinkNode
    public DoubleLinkNode<E> prev() { return p; }                                        // Return prev DoubleLinkNode
    public DoubleLinkNode<E> setPrev(DoubleLinkNode<E> prevVal) { return p = prevVal; }  // Set prev DoubleLinkNode
}
