/* Problem set 6 - Problem 2

Name: Jose Ramos
Date: November 9, 2019

-- OBJECTIVE --

Reverse a stack using a queue. Write a main class with a main method. Using any implementation of the stack and the
queue that you like, write a static method that a stack as a parameter. The method must use a queue to reverse the
values in the stack. The method returns void. In main, print the stack, call the reverse method, and print the
resulting stack.

Reference: - OpenDSA Chapter 9.2 Linked Queues
*/

// Linked queue implementation
class LQueue<E> implements Queue<E> {
    private Link<E> front; // Pointer to front queue node
    private Link<E> rear;  // Pointer to rear queue node
    private int size;      // Number of elements in queue

    // Constructors
    LQueue() { init(); }
    LQueue(int size) { init(); } // Ignore size

    // Initialize queue
    void init() {
        front = rear = new Link<E>(null);
        size = 0;
    }

    @Override
    public void clear() {
        init();
    }

    // Put element on rear
    public boolean enqueue(E it) {
        rear.setNext(new Link<E>(it, null));
        rear = rear.next();
        size++;
        return true;
    }

    // Remove and return element from front
    public E dequeue() {
        if (size == 0) return null;
        E it = front.next().element(); // Store the value
        front.setNext(front.next().next()); // Advance front
        if (front.next() == null) rear = front; // Last element
        size--;
        return it; // Return element
    }

    // Return front element
    public E frontValue() {
        if (size == 0) return null;
        return front.next().element();
    }

    // Return queue size
    public int length() { return size; }

    //Tell if the queue is empty or not
    public boolean isEmpty() { return size == 0; }

    public String toString() {
        Link<E> temp = front.next();
        StringBuffer out = new StringBuffer((size + 1) * 4);

        out.append("Front --> < ");
        for (int i = 0; i < size; i++) {
            out.append(temp.element());
            out.append(" ");
            temp = temp.next();
        }
        out.append(">");
        return out.toString();
    }

    public boolean swapFront(){

        if(size <= 1){return false;}

        E temp = front.next().element();
        front.next().setElement(front.next().next().element());
        front.next().next().setElement(temp);

        return true;
    }

    public boolean swapBack(){

        if(size <= 1){return false;}

        Link<E> tempLink = front.next();

        for(int i = 1; i < size - 1; i++){
            tempLink = tempLink.next();
        }

        E temp = rear.element();
        rear.setElement(tempLink.element());
        tempLink.setElement(temp);

        return true;
    }

    public boolean remove(int i){

        Link<E> temp = front.next();

        if(i >= size || i< 0){ return false;}

        else if(i == 0){
            dequeue();
        }
        else{
            for(int n = 0; n + 1 < i; n++){
                temp = temp.next();
            }
            temp.setNext(temp.next().next());
            size--;
        }

        return true;
    }

    public int count(){

        Link<E> temp = front.next();
        return count(temp);

    }

    private int count(Link<E> temp){

        if(temp == null){return 0;}
        else{
            temp = temp.next();
            return count(temp) + 1;
        }

    }

    public static void reverseStack( LinkedStack stack){

        LQueue queue = new LQueue();

        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }

        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }

    }

}