/*
7. Write a program that prompts the user for a binary string of 1s and 0s with equal numbers of 1s and 0s. Where the all
the ones precede all the zeros. Using any stack implementation you choose, utilize the nature of the stack to track if
the 1s and 0s are balanced (think about the parenthesis example I described in class).
*/

import java.util.*;

public class OnesAndZeros {

    public static void main(String[] args) {

        StackArray<Integer> stackBalance = new StackArray<>();

        System.out.println("Type 1's and 0's:");
        Scanner userInput = new Scanner(System.in);
        char[] onesAndZeros = userInput.next().toCharArray();

        OnesAndZeros test = new OnesAndZeros();

        for(int i = 0; i < onesAndZeros.length; i++){
            if(onesAndZeros[i]== '0'){
                if(!stackBalance.isEmpty() && stackBalance.topValue() == 1)
                    stackBalance.pop();
                else
                    stackBalance.push(0);
            }
            else if(onesAndZeros[i]== '1'){
                if(!stackBalance.isEmpty() && stackBalance.topValue() == 0)
                    stackBalance.pop();
                else
                    stackBalance.push(1);
            }
            else{

            }
        }

        if(stackBalance.isEmpty())
            System.out.println("The 1's and 0's are balanced");
        else
            System.out.println("The 1's and 0's are not balanced");

    }

}
