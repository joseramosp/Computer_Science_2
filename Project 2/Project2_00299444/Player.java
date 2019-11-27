/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * October 10/2019
 * Project 2
 * -----------------------
 * Objectives:
 * This class is part of the "Project 2" assignment. To see the objectives of this lab please read the readme.txt file
 *
 * NOTE: I added addCardToDrawStack(), getName() and peekCard() methods. This methods are not required but I belief they
 *       are essentials.
 */

public class Player {
    private String name;  // Name of the player
    private LinkedStack<Card> discardStack = new LinkedStack<>();
    private LinkedStack<Card> drawStack = new LinkedStack<>();

    public Player(String name){
        this.name = name;
    }
    public Card draw(){
        Card card;
        if(drawStack.size()>0){
            card = drawStack.peek();
            drawStack.pop();
            return card;
        }
        else if(!(drawStack.size() > 0) && discardStack.size() > 0){
            replenishDrawStack();
            card = drawStack.peek();
            drawStack.pop();
            return card;
        }
        else{
            return null;
        }
    }
    public void discard(Card card) {
        discardStack.push(card);
    }
    public void addCardToDrawStack(Card card){
        drawStack.push(card);
    }
    public boolean hasCards(){
        return drawStack.size() > 0 || discardStack.size() > 0;
    }
    public Card peekCard(){
        if(drawStack.size() == 0 && discardStack.size() > 0){
            replenishDrawStack();
        }
        return drawStack.peek();
    }
    public String getName(){
        return name;
    }
    // This class is private because is meant to be used inside of the class only.
    private void replenishDrawStack(){
        while(discardStack.size() > 0){
            drawStack.push(discardStack.peek());
            discardStack.pop();
        }
    }
    @Override
    public String toString(){
        return name + " has " + discardStack.size() + " card/s in discard and " + drawStack.size() + " to draw.";
    }
}