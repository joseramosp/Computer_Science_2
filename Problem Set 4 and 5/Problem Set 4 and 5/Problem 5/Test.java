/* Problem set 4 and 5 - Problem 5

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Modify the Double Linked list class so that is uses a Freelist as discussed in the text. Write a test program.

*/

public class Test {

    public static void main(String[] args) {

        DoubleLinkedList<Integer> a = new DoubleLinkedList<>();
        //LinkedList<Integer> b = new LinkedList<>();
        //LinkedList<Integer> newList = new LinkedList<>();

        for(int i = 1; i<= 10; i++){
            //a.insert(i);
            a.append(i);
            //a.insert(i+10);
        }

        System.out.println(a.toString());
        System.out.println(a.length());
        a.next();
        a.insert(11);
        a.next();
        a.remove();
        a.remove();
        a.remove();
        a.remove();
        a.insert(12);
        System.out.println(a.toString());
        System.out.println(a.length());
        a.next();
        a.next();
        a.next();
        a.next();
        a.next();
        a.next();
        a.next();
        a.prev();
        a.remove();
        System.out.println(a.toString());
        System.out.println(a.length());

    }
}
