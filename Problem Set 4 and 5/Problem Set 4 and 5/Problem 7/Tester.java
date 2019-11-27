/* Problem set 4 and 5 - Problem 7

Name: Jose Ramos
Date: October 20, 2019

-- OBJECTIVE --

Write the following recursive functions
    * power - Given two integers, it calculates the first to the power of the second
    * gcd - use Euclid's definition of GCD:  GCD(a, 0) is a; GCD(a, b) is GCD(b, a mod b)
    * factorial - given an int return n! recursively
*/


public class Tester {

    public static void main(String[] args) {

        Power test = new Power();
        GCD test2 = new GCD();
        Factorial test3 = new Factorial();


        // Testing Power class:
        System.out.println("Testing power:");
        System.out.println(test.power(2,3));
        System.out.println(test.power(5,5));
        System.out.println(test.power(9,4));
        System.out.println(test.power(4,3));
        System.out.println();

        // Testing GCD class:
        System.out.println("Testing GCD:");
        System.out.println(test2.gcd(1785,546));
        System.out.println(test2.gcd(18,6));
        System.out.println(test2.gcd(336,360));
        System.out.println();

        // Testing Factorial Class:
        System.out.println("Testing factorial:");
        System.out.println(test3.factorial(2));
        System.out.println(test3.factorial(5));
        System.out.println(test3.factorial(10));
    }
}
