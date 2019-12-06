import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream textFile = new FileInputStream("src/text.txt");
        //File textFile = new File("text.txt" );
        //Scanner scanner = new Scanner(textFile);

        BSTree test = new BSTree();

//        test.test1();
//        System.out.println(test.root.toString());
        test.fromFile();

        System.out.println(test.root.toString());
//        test.root.question();


    }
    
}
