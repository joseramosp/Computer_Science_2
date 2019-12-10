/*
// * Jose Ramos
// * Student ID: 00299444
// * CIS 252 - T-7847
// * December 4/2019
// * Project 5A
// * -----------------------
// * Objectives:
// * This class is part of the "Project 5A" assignment. To see the objectives of this lab please read the readme.txt file.
// *
// * NOTE: The method menu() call all the methods that are necessary to run the game.
*/

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Main.menu();

    }

    // This is the method that runs the game. Note: it doesn't load the the tree from the file or save the tree on the file.
    // Call the method fromFile() from the class BSTree before using it and call the toFile() after using it.
    static void startGame(BSTree tree){
        Scanner scanner = new Scanner(System.in);

        Question<String> rt = tree.root;
        String userInput;

        System.out.println("\nThink about anything and I am going to guess what it is. Just type \"y\" for yes and \"n\" for no on each question.\n");

        while(!tree.root.isLeaf()){
            System.out.println(tree.root.question());

            userInput = scanner.nextLine();
            while(!userInput.equals("n") && !userInput.equals("y")){
                System.out.println("\nYour input is not valid. Try aging:");
                userInput = scanner.nextLine();
            }

            if(userInput.equals("n")){
                tree.goToNo();
            }
            else{
                tree.goToYes();
            }
        }

        System.out.println("You are thinking about: " + tree.root.question() +"\n");

        System.out.println("If it is not the answer type \"n\" or \"y\" if it is the answer:");

        userInput = scanner.nextLine();
        while(!userInput.equals("n") && !userInput.equals("y")){
            System.out.println("Your input is not valid. Try aging:\n");
            userInput = scanner.nextLine();
        }

        if(userInput.equals("n")){
            String newQuestion;
            String newAnswer;

            System.out.println("\nEnter the real answer:");
            newAnswer = scanner.nextLine();

            System.out.println("\nEnter a question that can lead to your answer:");
            newQuestion = scanner.nextLine();

            Question<String> tempQuestion = new Question<String>(newQuestion, tree.root, new Question<String>(newAnswer));

            tempQuestion.setParent(tree.root.getParent());
            if(tree.root.getParent().yes().question().equals(tempQuestion.no().question())){
                tree.root.getParent().setYes(tempQuestion);
            }
            if(tree.root.getParent().no().question().equals(tempQuestion.no().question())){
                tree.root.getParent().setNo(tempQuestion);
            }

            tree.root = tempQuestion;

            while(tree.root.hasParent()){
                tree.goToParent();
            }
        }
        else{
            System.out.println("\nI knew it!");
            while(tree.root.hasParent()){
                tree.goToParent();
            }
        }
    }

    // This is the menu of the program.
    static public void menu() throws IOException{

        BSTree test = new BSTree();

        System.out.println("Welcome to the 20Q game!!\nEnter \"y\" to start the game or \"q\" to quit the game:");

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        while(userInput.equals("y")){
            test.fromFile();
            Main.startGame(test);
            test.toFile();
            System.out.println("\nEnter \"y\" to start the game or \"q\" to quit the game:");
            userInput = scanner.nextLine();
        }
    }
}
