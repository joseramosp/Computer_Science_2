/* Problem set 7 - Problem 1

Name: Jose Ramos
NECC ID#: 00299444
Date: November 28, 2019

-- OBJECTIVE --

Implement a BinarySearchTree using BSTNodes of Strings. Include a balance method that balances the tree. Each node of the
tree contains a string. Sort the tree lexicographically. Write a program that  Enter 25 words into the structure. Prompt
the user for a word 1 letter at a time. Each time a letter is entered, print out all the possible words in the tree. This
continues until only one possible word is displayed. If the word is not the user's word, prompt them for the complete word
and add it to the tree. For example, if the tree contains the following: Apple, Hall, Hen, Hello, Help, Zoo - and the user
enters the letter H, Hen, Hello, and Help are printed. If the next letter entered is E then Hen, Hello, and Help are printed.
If next letter is L then Hello and Help are printed. If the next letter entered is L then Hello and Help are printed. If
P is the users final letter, Help is printed. If help is not the users word - perhaps it is Helper - their word is added
to the tree.

Reference: - OpenDSA Chapter 11
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StringsBST test = new StringsBST();

        test.insert("Hello");
        test.insert("Bye");
        test.insert("Car");
        test.insert("Red");
        test.insert("Snow");
        test.insert("Love");
        test.insert("Zorro");
        test.insert("Hart");
        test.insert("Rock");
        test.insert("Avalon");
        test.insert("Help");
        test.insert("Rex");
        test.insert("Blue");
        test.insert("Good");
        test.insert("Best");
        test.insert("Diamond");
        test.insert("Phone");
        test.insert("Swift");
        test.insert("Python");
        test.insert("Coffee");
        test.insert("Homework");
        test.insert("Project");
        test.insert("Helper");
        test.insert("Future");
        test.insert("Clear");
        test.insert("Resilient");
        test.balance();

        String word = "";
        boolean isSimilar;
        Scanner scanner = new Scanner(System.in);

        System.out.println("All the words in the tree are:");
        test.print();

        System.out.println("\nEnter a letter and then press enter until you complete the word that you want:\n");

        while(true){
            word += scanner.next();

            isSimilar = test.findSimilar(word);

            if(!isSimilar){
                System.out.println("It seems like the word that you want is no on the tree. What is the word?");
                test.insert(scanner.next());
                test.balance();
                System.out.println("\nEnter a letter and then press enter until you complete the word that you want:\n");
                word = "";
            }
        }
    }
}
