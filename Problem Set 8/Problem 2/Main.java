/* Problem Set 8 - Problem 2

Name: Jose Ramos
NECC ID#: 00299444
Date: December 2, 2019

-- OBJECTIVE --

Write an implementation of a HashMap that uses chaining. The map and the chaining "buckets" should be implemented  on
a linked list. Provide testing code.

Reference: I worked with Vladimir Ventura to learn more about this topic and understand the API for record and HashMap.

NOTE: When running the program, there is going to few of the records that has more than 1 record linked. This records are going to
print all of the values linked.

*/

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, String> test = new HashMap<>();

        int keys[] = new int[35];

        for(int i=0; i < 35; i++){
            keys[i] = i+1;
        }

        for(int i=0; i < keys.length; i++){
            test.insert(keys[i], "This is a test for the key "+ keys[i]);
        }

        for(int i = 0; i<10; i++){
            int randNumber = ((int)(Math.random()*100) % keys.length);

            System.out.println("For the key " + keys[randNumber] + ", the value is: " + test.getValue(keys[randNumber]));
        }
    }
}
