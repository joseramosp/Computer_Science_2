/* Problem set 6 - Problem 2

Name: Jose Ramos
Date: November 9, 2019

-- OBJECTIVE --

Reverse a stack using a queue. Write a main class with a main method. Using any implementation of the stack and the
queue that you like, write a static method that a stack as a parameter. The method must use a queue to reverse the
values in the stack. The method returns void. In main, print the stack, call the reverse method, and print the
resulting stack.

Reference: - OpenDSA Chapter 9.2 Linked Queues
*/

public class Main {

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();

        for(int i=1; i<=10; i++){
            stack.push(i);
        }

        System.out.println(stack.toString()+"\n");
        LQueue.reverseStack(stack);
        System.out.println(stack.toString());

    }
}
