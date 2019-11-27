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

public class Test {

    public static void main(String[] args) {

        AQueue<Integer> arrayQueue = new AQueue<>();
        LQueue<Integer> linkedQueue = new LQueue<>();

        for(int i=1; i<=10; i++){
            arrayQueue.enqueue(i);
        }

        for(int i=11; i<=20; i++){
            linkedQueue.enqueue(i);
        }

        System.out.println(arrayQueue.toString());

        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.dequeue();
//        arrayQueue.dequeue();
//        arrayQueue.dequeue();
        arrayQueue.enqueue(11);
        arrayQueue.enqueue(12);
//        arrayQueue.enqueue(13);

        // toString() TEST
        System.out.println(arrayQueue.toString());
        System.out.println();

        // SwapFront() TEST
        System.out.println(arrayQueue.swapFront());
        System.out.println(arrayQueue.toString());

        // swapBack() TEST
        System.out.println(arrayQueue.swapBack());
        System.out.println(arrayQueue.toString());

        // remove (int i) TEST
        System.out.println(arrayQueue.remove(1));
        System.out.println(arrayQueue.toString());

        // count() TEST
        System.out.println(arrayQueue.count());
        System.out.println(arrayQueue.toString());


        // Link based Queue TESTs

        System.out.println("-----------------------------");
        System.out.println("Link based Queue:\n");

        // toString() TEST
        System.out.println(linkedQueue.toString()+"\n");

        // swapFront() TEST
        System.out.println(linkedQueue.swapFront());
        System.out.println(linkedQueue.toString()+"\n");

        // swapBack() TEST
        System.out.println(linkedQueue.swapBack());
        System.out.println(linkedQueue.toString()+"\n");

        // remove(int i) TEST
        System.out.println(linkedQueue.remove(5));
        System.out.println(linkedQueue.toString()+"\n");

        // count() TEST
        System.out.println(linkedQueue.count());

    }
}
