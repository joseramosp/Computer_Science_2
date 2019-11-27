/* Problem set 4 and 5 - Problem 3

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Write a class called ListUtillity that offers the following methods. Include a Big-O cost of each method.

*/

public class Test {

    public static void main(String[] args) {

        ListUtility<Integer> listUtility = new ListUtility<>();
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> newList = new LinkedList<>();

        for(int i = 1; i<= 10; i++){
            a.append(i);
            b.append(100 + i);
        }

        newList = listUtility.appendList(a,b);
        //newList = listUtility.mergeList(a,b);
        //listUtility.reverseList(b);
        //newList = listUtility.cloneList(a);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(newList.toString());


    }
}
