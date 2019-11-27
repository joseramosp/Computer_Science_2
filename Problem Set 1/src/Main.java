/* Problem set 1 - Problem 4

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

Define a Box class. A Box uses a generic type to contain any object. A Box has a single private field called item of
generic type. The class provides setter and getter methods for the item. Create a main class that tests your box - make
a few with different data types.
*/

public class Main extends Box {

    public static void main(String[] args) {

        Box<Integer> test = new Box<>();
        Box<String> test2 = new Box<>();
        Box<Double> test3 = new Box<>();

        test.setItem(50);
        System.out.println("item1 = " + test.getItem());

        test2.setItem("This is a String");
        System.out.println("item2 = " + test2.getItem());

        test3.setItem(3.14);
        System.out.println("item3 = " + test3.getItem());

    }

}
