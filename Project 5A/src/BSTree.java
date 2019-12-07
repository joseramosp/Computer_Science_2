import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class BSTree {
    protected Question<String> root; // Root of the BST
    protected int nodeCount; // Number of nodes in the BST

    // constructor
    public BSTree() {
        root = null;
        nodeCount = 0;
    }

    // Reinitialize tree
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    // Return the number of records in the dictionary
    public int size() {
        return nodeCount;
    }

    public void print() {
        System.out.print("[");
        printHelp(root);
        System.out.println("]");
    }

    protected void printHelp(Question rt) {
        if (rt == null) return;
        printHelp(rt.no());
        System.out.print(" " + rt.question() + " ");
        printHelp(rt.yes());
    }

    public void test1(){
        
        this.root = new Question<String>("Is is alive?", new Question<String>("It is a rock"), new Question<String>("It is a dog"));
        
    }

    public void toFile(){
        try(PrintWriter out = new PrintWriter("src/textForWritingTest.txt")) {
            out.println(root.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fromFile() throws IOException {
        //Take the file
        FileReader file = new FileReader(new File("src/textForWritingTest.txt"));
            //Wrap the FileReader around a BufferedReader for a less costly read because
            //it returns raw data (byte level) rather than parsing what it finds
            //These two lines could have been abstracted to one, like this
            //BufferedReader bf = new BufferedReader(new FileReader(new File("src/textForWritingTest.txt")));
            //but readability and understanding is key here
        BufferedReader bf = new BufferedReader(file);
        //Look at the first character
        if ((char) bf.read() == '{'){
        //If it is a '{' then helper
            //helper: Take all the characters after the { and return a node
            //with its data being the String of these characters, until it finds a
            //'}', and when it does, set its left to whatever the string is and
            //its right to the same thing (same method not the same object
            this.root = fromFile(bf);
        }
        //If it's not, abort
        else {
            System.out.println("File doesn't match desired structure {Text{}{}}");
        }

//        Scanner scanner = new Scanner(file);
//        root = fromFileHelper(root, scanner);
    }

    private Question<String> fromFile(BufferedReader reader) throws IOException {
        //Take all the characters after the { and return a node
        //with its data being the String of these characters, until it finds a
        //'}', and when it does, set its left to whatever the string is and
        //its right to the same thing (same method not the same object

        StringBuilder parsedQuestion = new StringBuilder();
        Question<String> newlyCreated = new Question<>(null);
        char currentChar = (char) reader.read();

        if (currentChar == '}' && reader.toString().isEmpty()) {
            return newlyCreated;
        } else {
            currentChar = (char) reader.read();
        }

        //Here it should only be a read while the character is not either { or }.
            //BufferedReader works like a LinkedList in the way that when a character is read,
            //it is just doing next() from a LinkedList: it displays what it has AND moves the cursor one
            //step forward. That's why we should also save before the loop starts to check if we
            //don't meet these condition

        while (currentChar != '{' && currentChar != '}'){
            parsedQuestion.append(currentChar);
            currentChar = (char)reader.read();
        }

        if (!parsedQuestion.toString().isEmpty()){
            newlyCreated.setQuestion(parsedQuestion.toString());
        }

        if (currentChar == '{'){
            if(newlyCreated.getQuestion() != null){
                newlyCreated.setNo(fromFile(reader));
                newlyCreated.setYes(fromFile(reader));
            }
        }
        return newlyCreated;
    }

    public Question<String> fromFileHelper(Question<String> rt,  Scanner scanner){

        String c = scanner.next();

        while(c.equals("}") && scanner.hasNext()){
            c = scanner.next();
        }
        if (c.equals("{")) {
            c = scanner.next();
            c = scanner.next();
            while (!('\"' == c.charAt(c.length() - 1))){
                c = c + " " + scanner.next();
            }

            c = c.substring(0,c.length() - 2);

            if(!c.equals("{null}")){
                rt = new Question<String>(c);
                rt.setNo(fromFileHelper(null,scanner));
                rt.setYes(fromFileHelper(null,scanner));
                return rt;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    public Question<String> goToYes(){
        root.yes().setParent(root);
        root = root.yes();
        return root;
    }

    public Question<String> goToNo(){
        root.no().setParent(root);
        root = root.no();
        return root;
    }

    public Question<String> goToParent(){
        root = root.getParent();
        return root;
    }
}