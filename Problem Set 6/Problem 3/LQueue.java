/* Problem set 6 - Problem 3

Name: Jose Ramos
Date: November 9, 2019

-- OBJECTIVE --

Implement or extend a queue that can contain objects that implement the comparable interface. Include a method called
sortLoHi that sorts the queue lowest to highest and a method called sortHiLo that sorts them highest to lowest. Use the
compareTo method of the comparable object to determine greater or less then. Each method should implement s sort algorithm
(bubble, selection, or insertion), and you can't use the same sort in both methods.

Reference: - OpenDSA Chapter 9.2 Linked Queues
*/

// Linked queue implementation
class LQueue<E extends Comparable<E>> implements Queue<E>{
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

    // Bubble sort algorithm
    public void sortLoHi(){

        E tempE;
        Link<E> tempLink = front;
        for(int i = 0; i<size; i++){
            Link<E> tempLink2 = front.next();
            tempLink = tempLink.next();
            tempE = tempLink.element();
            for(int n = 0; n<size; n++){
                if(tempLink2.element().compareTo(tempE) > 0){
                    tempE = tempLink2.element();
                    tempLink2.setElement(tempLink.element());
                    tempLink.setElement(tempE);
                }
                tempLink2 = tempLink2.next();
            }
        }
    }

    // Selecting algorithm
    public void sortHiLo(){

        Link<E> tempLink = front.next();
        Link<E> tempLink2 = front.next().next();
        E tempE;
        while(tempLink != null){
            tempLink2 = tempLink.next();
            while(tempLink2 != null){
                if(tempLink.element().compareTo(tempLink2.element()) < 0){
                    tempE = tempLink2.element();
                    tempLink2.setElement(tempLink.element());
                    tempLink.setElement(tempE);
                }
                tempLink2 = tempLink2.next();
            }
            tempLink = tempLink.next();
        }
    }
}