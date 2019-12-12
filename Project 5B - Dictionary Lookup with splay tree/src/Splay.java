public class Splay {


    public static void main(String[] args) {


        SplayTree s = new SplayTree();
        s.insert(5);
        s.printLevelOrder();
        s.insert(7);
        s.printLevelOrder();
        s.insert(1);
        s.printLevelOrder();
        s.insert(2);
        s.printLevelOrder();
        s.find(1);
        s.printLevelOrder();
        s.insert(6);
        s.printLevelOrder();
        s.insert(15);
        s.printLevelOrder();
        s.find(1);
        s.printLevelOrder();
    }

}
