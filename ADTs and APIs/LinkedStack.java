public class LinkedStack<E> implements Stack<E>{
    public Link<E> top;            // Pointer to first element
    public int size;               // Number of elements

    // Constructors
    LinkedStack() { top = null; size = 0; }
    LinkedStack(int size) { top = null; size = 0; }

    // Reinitialize stack
    public void clear() { top = null; size = 0; }

    // Put "it" on stack
    public boolean push(E it) {
        top = new Link<E>(it, top);
        size++;
        return true;
    }

    // Remove "it" from stack
    public E pop() {
        if (top == null) return null;
        E it = top.element();
        top = top.next();
        size--;
        return it;
    }

    public E topValue() {      // Return top value
        if (top == null) return null;
        return top.element();
    }

    // Return stack length
    public int length() { return size; }

    // Tell if the stack is empty
    public boolean isEmpty() { return size == 0; }

    public String toString(){

        Link<E> temp = top;
        StringBuffer out = new StringBuffer((size + 1) * 4);

        out.append("Top --> < ");
        for(int i = 0; i<size; i++){
            out.append(temp.element());
            out.append(" ");
            temp = temp.next();
        }
        out.append(">");
        return out.toString();

    }

}