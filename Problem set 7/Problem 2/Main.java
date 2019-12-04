/* Problem set 7 - Problem 2

Name: Jose Ramos
NECC ID#: 00299444
Date: November 28, 2019

-- OBJECTIVE --

Design and implement the following Binary Search Tree Methods:

* leafCount - returns the number of leaves
* height - returns the height of the tree

Reference: - OpenDSA Chapter 11
*/

public class Main {

    public static void main(String[] args) {
        BSTree<Integer> test = new BSTree<>();
        int num = 0;

        for(int i = 0; i<10; i++){
            num = (int)(Math.random() * 1000 ) % 50;
            test.insert(num);
            System.out.println(num);
        }

        test.print();
        System.out.println("Total leaf: ");
        System.out.println(test.leafCount());

        System.out.println("Height:");
        System.out.println(test.height());
    }
}
