import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BSTree test = new BSTree();

//        System.out.println(test.root.toString());

//        test.test1();
//        test.toFile();

        test.fromFile();
        Main.startGame(test);
//        System.out.println(test.root);
        test.toFile();

//        System.out.println(test.root);

//        test.root.question();
//        System.out.println(test.root.yes().question());
//        test.print();

    }

    static void startGame(BSTree tree){
        Scanner scanner = new Scanner(System.in);

        Question<String> rt = tree.root;
        String userInput;

        tree.print();
        System.out.println(tree.root);

        System.out.println("Think about anything and I am going to guess what it is. Just type \"y\" for yes and \"n\" for no on each question.\n");

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
//                tree.print();
//                System.out.println(tree.root);
            }
        }
    }
}
