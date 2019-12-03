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
        test.print();

        String word = "Hello";
        String word2 = "H";
        System.out.println(test.root.value());
        test.findSimilar(word2);
    }
}
