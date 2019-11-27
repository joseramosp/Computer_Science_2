/* Problem set 1 - Problem 5

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

Define a class that implements the interface CalculatorInterface.
*/

import java.util.*;
import java.lang.*;

public class QuickMath implements CalculatorInterface {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mult(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        return a/b;
    }

    public static void main(String[] args) {

        QuickMath test = new QuickMath();

        double number1 = 12, number2 = 1.5;

        System.out.println("Basic math operations using "+number1+" and "+number2+" are:");
        System.out.println(number1+" + "+number2+" = " + test.add(number1,number2));
        System.out.println(number1+" - "+number2+" = " + test.sub(number1,number2));
        System.out.println(number1+" x "+number2+" = " + test.mult(number1,number2));
        System.out.println(number1+" / "+number2+" = " + test.div(number1,number2));

        System.out.println("\nThe area of a circle of radius 4 is = " + PI * (4*4));
        System.out.println("\"e\" is a numerical constant that is approximately equal to = " + E);
    }
}
