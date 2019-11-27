import java.lang.*;

public class StackArray<E> implements Stack<E>{
    public E stackArray[];         // Array holding stack
    private static final int DEFAULT_SIZE = 10;
    public int maxSize;            // Maximum size of stack
    public int top;                // First free position at top

    // Constructors
    @SuppressWarnings("unchecked") // Generic array allocation
    StackArray(int size) {
        maxSize = size;
        top = 0;
        stackArray = (E[])new Object[size]; // Create stackArray
    }
    StackArray() { this(DEFAULT_SIZE); }

    public void clear() { top = 0; }    // Reinitialize stack

    // Push "it" onto stack
    public boolean push(E it) {
        if (top >= maxSize) return false;
        stackArray[top++] = it;
        return true;
    }

    // Remove and return top element
    public E pop() {
        if (top == 0) return null;
        return stackArray[--top];
    }

    public E topValue() {          // Return top element
        if (top == 0) return null;
        return stackArray[top-1];
    }

    public int length() { return top; } // Return stack size

    public boolean isEmpty() { return top == 0; }	// Tell if the stack is empty
}
