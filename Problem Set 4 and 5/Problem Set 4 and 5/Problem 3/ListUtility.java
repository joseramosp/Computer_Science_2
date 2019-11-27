/* Problem set 4 and 5 - Problem 3

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Write a class called ListUtility that offers the following methods. Include a Big-O cost of each method:

* List cloneList(List list) - make a duplicate of the given list and return the copy. You may not use the Java clone method,
  you must duplicate the list yourself. The original list must be preserved upon method completion

* void reverseList(List list) - takes a list and modifies that list by reversing the oder of the contents. (A,B,C,D => D,C,B,A)

* List mergeList(List a, List b) - takes two lists and returns a merged list of list a and list b. List a and b should
  be preserved. The original lists must be preserved upon method completion. (A, B, C and X, Y, Z ==> A, X, B, Y, C, Z)

* List appendList(List a, List b) - takes two lists and returns a new list of list a and list b. List a and b should be
  preserved. The original lists must be preserved upon method completion. (A, B, C and X, Y, Z ==> A, B, C, X, Y, Z)

NOTES: The big O is mentioned on the top of every method.

*/

public class ListUtility<E> {

    ListUtility(){}

    // Big O --> n
    LinkedList<E> cloneList(LinkedList<E> list){
        LinkedList<E> innList = new LinkedList<>();

        for(int i = 0; i<list.length();i++){
            innList.append(list.getValue());
            list.next();
        }
        list.moveToStart();
        return innList;
    }

    // Big O --> 2n --> n
    void reverseList(LinkedList<E> list){
        LinkedList<E> innList = new LinkedList<>();

        while(!list.isEmpty()){
            innList.insert(list.remove());
        }
        while(!innList.isEmpty()){
            list.append(innList.remove());
        }
    }

    // Big O --> n
    LinkedList<E> mergeList(LinkedList<E> a, LinkedList<E> b){
        LinkedList<E> innList = new LinkedList<>();

        for(int i = 0; i<a.length() || i < b.length(); i++){
            if(!a.isAtEnd()){
                innList.append(a.getValue());
                a.next();
            }
            if(!b.isAtEnd()){
                innList.append(b.getValue());
                b.next();
            }
        }
        a.moveToStart();
        b.moveToStart();
        return innList;
    }

    // Big O --> 2n --> n
    LinkedList<E> appendList(LinkedList<E> a, LinkedList<E> b){

        LinkedList<E> innList = new LinkedList<>();

        innList = cloneList(a);

        for(int i = 0; i < b.length(); i++){
            innList.append(b.getValue());
            b.next();
        }
        a.moveToStart();
        b.moveToStart();
        return innList;
    }

}
