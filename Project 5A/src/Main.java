public class Main {
    public static void main(String[] args){
        BSTree tree = new BSTree();
        tree.generateQuestions();
        tree.toFile();
        TwentyQuestions tq = new TwentyQuestions(tree);
        tq.setup();
        tq.startGame();
    }
}
