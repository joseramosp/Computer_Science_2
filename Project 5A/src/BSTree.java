import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // String: The record to insert.
    public void insert(String String) {
        root = insertHelp(root, String);
        nodeCount++;
    }

    // Remove a record from the tree
    // key: The key question of record to remove
    // Returns the record removed, null if there is none.
    public String remove(String key) {
        String temp = (String) findHelp(root, key); // First find it
        if (temp != null) {
            root = removeHelp(root, key); // Now remove it
            nodeCount--;
        }
        return temp;
    }

    // Return the record with key question k, null if none exists
    // key: The key question to find
    public String find(String key) {
        return (String) findHelp(root, key);
    }

    // Return the number of records in the dictionary
    public int size() {
        return nodeCount;
    }


    protected String findHelp(Question<String> rt, String k) {
        if (rt == null) return null;
        String c = rt.question();
        if (c.compareTo(k) > 0)
            return (String) findHelp(rt.no(), k);
        else if (c.compareTo(k) == 0)
            return rt.question();
        else return (String) findHelp(rt.yes(), k);
    }


    protected Question insertHelp(Question<String> rt, String String) {
        if (rt == null) return new Question<>(String);
        if (rt.question().compareTo(String) >= 0)
            rt.setNo(insertHelp(rt.no(), String));
        else
            rt.setYes(insertHelp(rt.yes(), String));
        return rt;
    }

    protected Question removeHelp(Question<String> rt, String k) {
        if (rt == null) return null;
        if (rt.question().compareTo(k) > 0) {
            rt.setNo(removeHelp(rt.no(), k));
        } else if (rt.question().compareTo(k) < 0) {
            rt.setYes(removeHelp(rt.yes(), k));
        } else {
            if (rt.no() == null) return rt.yes();
            else if (rt.yes() == null) return rt.no();
            else {
                Question<String> temp = getMax(rt.no());
                rt.setQuestion(temp.question());
                rt.setNo(deleteMax(rt.no()));
            }
        }

        return rt;
    }

    // Get the maximum valued element in a subtree
    protected Question<String> getMax(Question<String> rt) {
        if (rt.yes() == null) return rt;
        return getMax(rt.yes());
    }

    protected Question deleteMax(Question rt) {
        if (rt.yes() == null) return rt.no();
        rt.setYes(deleteMax(rt.yes()));
        return rt;
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

    public void fromFile() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("src/textForWritingTest.txt");
        Scanner scanner = new Scanner(file);
        root = fromFileHelper(root, scanner);
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
                rt.setYes(fromFileHelper(null,scanner));
                rt.setNo(fromFileHelper(null,scanner));
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
}