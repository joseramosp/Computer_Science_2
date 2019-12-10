/* Problem set 7 - Problem 3

Name: Jose Ramos
NECC ID#: 00299444
Date: November 28, 2019

-- OBJECTIVE --

Create an application that will read a text file (file name/location provided by the user) and display the 5 most frequently
used word (or words if there is a tie) in the file and how many times they occur.

Reference: - OpenDSA Chapter 11
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File textFile = new File("Problem 3/text.txt");
        Scanner scanner = new Scanner(textFile);
        ArrayList<String> repeatedWords = new ArrayList<>();

        BSTree test = new BSTree();

        String word = "";
        while (scanner.hasNext()) {
            word = scanner.next();
            if(test.find(word) == null){
                test.insert(word);
            }
            else{
                repeatedWords.add(word);
            }
            //test.print();
        }

        ArrayList<String> tempArrayList = new ArrayList<>();
        for(int i=0; i< repeatedWords.size(); i++){
            test.getFrequencyOfAWord(repeatedWords.get(i));
        }

        test.printFirstsWordsSortedByFrequency();

//        System.out.print("[ ");
//        for(int i=0; i<repeatedWords.size();i++){
//            System.out.print(test.repeatedWords.get(i) + " ");
//        }
//        System.out.println("]");

    }
    
}
