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
// * NOTE: This is the version of the tree that is used as to use each question as a node.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
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
        
        this.root = new Question<String>("Is is alive?", new Question<String>("It is the word humble!"), new Question<String>("It is a dog!"));
        
    }

    public void toFile(){
        try(PrintWriter out = new PrintWriter("src/QuestionAndAnswersOfTheTree.txt")) {
            out.println(root.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fromFile() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("src/QuestionAndAnswersOfTheTree.txt");
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