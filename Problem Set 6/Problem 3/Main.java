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

import java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        LQueue<Integer> queue = new LQueue<>();

        for(int i=1; i<=10; i++){
            queue.enqueue(randInt());
        }

        System.out.println(queue.toString()+"\n");
        queue.sortLoHi();
        System.out.println(queue.toString()+"\n");
        queue.sortHiLo();
        System.out.println(queue.toString()+"\n");


    }

    public static int randInt(){
        return (int)(Math.random()*100)%11;
    }

}
