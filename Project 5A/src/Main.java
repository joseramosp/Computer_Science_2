import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BSTree test = new BSTree();

//        test.test1();
//        System.out.println(test.root.toString());
//        test.toFile();
        test.fromFile();

        System.out.println(test.root);

//        test.root.question();
        System.out.println(test.root.yes().question());


    }
    
}
