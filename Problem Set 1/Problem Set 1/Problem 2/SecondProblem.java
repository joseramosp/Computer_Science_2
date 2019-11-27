/* Problem set 1 - Problem 2

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

Write a program that defines an array of 100 ints. Fill the array with random integers. Print the array. Sort the array from greatest to lowest. Print the sorted array.
*/

import java.util.*;

public class SecondProblem {

    public static void main(String[] args) {

        // Declaring a Random type variable to generate a random int number
        Random rand = new Random();

        SecondProblem test = new SecondProblem();

        int[] array_of_100_number = new int[100];

        // Giving a random value to each index in the array
        for (int i = 0; i<100; i++){
            array_of_100_number[i] = rand.nextInt(1000);
        }

        System.out.println("Unsorted array: ");

        test.print_array(array_of_100_number);

        test.sortArray(array_of_100_number);

        System.out.println("Sorted array: ");

        test.print_array(array_of_100_number);
    }

    void swap(int array [], int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    void print_array(int array []){
        // Printing all the values in the array
        System.out.print("[ ");
        for (int number: array) {
            System.out.print(number + " ");
        }
        System.out.println("]\n");
    }

    void sortArray(int array []){
        for(int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
