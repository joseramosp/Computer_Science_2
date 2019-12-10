/* Problem Set 8 - Problem 1

Name: Jose Ramos
NECC ID#: 00299444
Date: December 2, 2019

-- OBJECTIVE --

Write an implementation of a HashMap that uses linear probing. Implement this in an array of 25 elements. Use strings
as the keys and their hash codes as the array index. Provide testing code.

Reference:
*/

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        HashMap test = new HashMap();

        int keys[] = new int[25];

        for(int i=0; i < 25; i++){
            keys[i] = i+1;
        }

        for(int i=0; i < keys.length; i++){
            test.put(keys[i], "This is a test for the key "+ keys[i]);
        }

        for(int i = 0; i<10; i++){
            int randNumber = ((int)(Math.random()*100) % keys.length);

            System.out.println("For the key " + keys[randNumber] + ", the value is: " + test.get(keys[randNumber]));
        }
    }
}
