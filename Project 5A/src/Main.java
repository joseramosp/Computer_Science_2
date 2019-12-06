import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

//        File textFile = new File("text.txt" );
//        Scanner scanner = new Scanner(textFile);
//        ArrayList<String> repeatedWords = new ArrayList<>();
//
//        BSTree test = new BSTree();
//
//        String word = "";
//        while (scanner.hasNext()) {
//            word = scanner.next();
//            if(test.find(word) == null){
//                test.insert(word);
//            }
//            else{
//                repeatedWords.add(word);
//            }
//            test.print();
//        }

        BSTree test = new BSTree();
        test.test1();
        System.out.println(test.root.toString());

    }
    
}
