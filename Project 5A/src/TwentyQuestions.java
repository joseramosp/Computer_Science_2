import java.io.IOException;
import java.util.Scanner;

public class TwentyQuestions {
    private Question<String> currentQuestion;
    private Question<String> pastQuestion;
    private BSTree twentyQ;

    public TwentyQuestions(BSTree tq){
        this.twentyQ = tq;
    }

    public void setup(){
        try{
            this.twentyQ.fromFile();
            this.currentQuestion = twentyQ.root;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void startGame(){
        boolean gameDone = false;
        String input = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the 20 Questions game!");
        while (!gameDone){
            System.out.println(currentQuestion.getQuestion());
            input = scanner.nextLine();
            if (input.equals("y") || input.equals("yes")){
                if (currentQuestion.yes() == null || currentQuestion.yes().getQuestion() == null){
                    System.out.println("I won!");
                    gameDone = true;
                } else {
                    this.pastQuestion = currentQuestion;
                    currentQuestion = currentQuestion.yes();
                }
            } else if (input.equals("n") || input.equals("no")){
                if (currentQuestion.no() == null || currentQuestion.no().getQuestion() == null){
                    createNewQuestion();
                    gameDone = true;
                } else {
                    this.pastQuestion = currentQuestion;
                    currentQuestion = currentQuestion.no();
                }
            } else {
                System.out.println("Try that input again!");
            }
        }
        twentyQ.toFile();
    }

    private void createNewQuestion(){
        String question;
        String answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type what the answer was");
        answer = scanner.nextLine();
        System.out.println("Now type in how you would make it as a question");
        question = scanner.nextLine();
        this.currentQuestion.setNo(new Question<>(question));
    }
}
