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
