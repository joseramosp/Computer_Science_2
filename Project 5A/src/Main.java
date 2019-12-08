public class Main {

    public static void main(String[] args){

        BSTree tree = new BSTree();
        TwentyQuestions tq = new TwentyQuestions(tree);
        tq.setup();
        tq.startGame();
    }
}
