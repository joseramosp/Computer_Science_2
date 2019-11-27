public class FreeListLink <E> { // Singly linked list node with freelist support
    private E e;       // Value for this node
    private FreeListLink<E> n;    // Point to next node in list

    // Constructors
    FreeListLink(E it, FreeListLink<E> inn) { e = it; n = inn; }
    FreeListLink(FreeListLink<E> inn) { e = null; n = inn; }

    E element() { return e; }                        // Return the value
    E setElement(E it) { return e = it; }            // Set element value
    FreeListLink<E> next() { return n; }                     // Return next FreeListLink
    FreeListLink<E> setNext(FreeListLink<E> inn) { return n = inn; } // Set next FreeListLink

    // Extensions to support freelists
    private static FreeListLink freelist = null;                  // Freelist for the class

    // Return a new FreeListLink, from freelist if possible
    static <E> FreeListLink<E> get(E it, FreeListLink<E> inn) {
        if (freelist == null)
            return new FreeListLink<E>(it, inn);                 // Get from "new"
        FreeListLink<E> temp = freelist;                       // Get from freelist
        freelist = freelist.next();
        temp.setElement(it);
        temp.setNext(inn);
        return temp;
    }

    // Return a FreeListLink node to the freelist
    void release() {
        e = null;   // Drop reference to the element
        n = freelist;
        freelist = this;
    }
}
