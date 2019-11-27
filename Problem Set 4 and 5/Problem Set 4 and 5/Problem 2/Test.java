/* Problem set 4 and 5 - Problem 2

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Create a DoubleLinkNode. Use that node to create a DoubleLinkedList that implements the textbook's List interface.
Include a testing file to test your list.

*/

public class Test {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> test = new DoubleLinkedList<>();

        for(int i = 1; i<10; i++){
            test.append(i);
        }

        test.next();
        test.next();
        test.next();
        test.next();
        test.prev();
        test.insert(10);
        test.next();
        System.out.println("The number " + test.remove() + " was removed");

        System.out.println("The current position is " + test.currPos());

        System.out.println(test.toString());

    }
}
