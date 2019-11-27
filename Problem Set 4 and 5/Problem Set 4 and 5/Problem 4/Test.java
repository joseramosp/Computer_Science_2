/* Problem set 4 and 5 - Problem 4

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Modify the linked list class (from the book or your own version) so that removal, insertion, and size are written
recursively.  Write a test program

*/

public class Test {

    public static void main(String[] args) {

        LinkedList<Integer> a = new LinkedList<>();
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
        System.out.println(a.toString());
        System.out.println(a.length());

    }
}
