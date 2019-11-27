/* Problem set 6 - Problem 1

Name: Jose Ramos
Date: November 9, 2019

-- OBJECTIVE --

Implement the books queue interface on an array-based queue and on a linked queue. Add the following methods to both your queue implementations and provide a test file.

* swapFront() - swaps the first two elements in the queue, returns true if successful, false otherwise (like only 1 element in the queue)
* swapBack( )- swaps the last two elements in the queue,  returns true if successful, false otherwise (like only 1 element in the queue)
* remove (int i) - takes the index of an element in the queue and returns it. Returns a boolean value - true if the item is removed, false otherwise (like an invalid index)
* toString() - provide a toString method that prints the queues contents clearly.
* count() - a method that returns the number of elements in the queue - it must recursively count the elements. You cannot use a instance variable to track the count.

Reference: - OpenDSA Chapter 9.2 Linked Queues & Chapter 9.1 Queues
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

}