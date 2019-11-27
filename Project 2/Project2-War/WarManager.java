/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * October 10/2019
 * Project 2
 * -----------------------
 * Objectives:
 * This class is part of the "Project 2" assignment. To see the objectives of this lab please read the readme.txt file
 * This the class that runs the game itself.
 *
 * NOTE: The class war was added to apply better practice into the class that helps readability.
 */

import java.util.Scanner; // This library will be used to ask the players for their names.

public class WarManager {

    private Deck deck;        // The deck that the dealer will use to deal and hold the cards draw and then give it to the winner.
    private Player player1;
    private Player player2;

    Scanner scanner = new Scanner(System.in);

    // Creating the deck and player
    public void setup(){
        deck = new Deck();
        deck.shuffle();
        System.out.println("Enter Player 1 name:");
        player1 = new Player(scanner.next());
        System.out.println("Enter Player 2 name:");
        player2 = new Player(scanner.next());
    }
    // Dealing the cards in the deck.
    public void deal(){
        while(deck.size() >1){
            player1.addCardToDrawStack(deck.draw());
            player2.addCardToDrawStack(deck.draw());
        }
    }
    // This is where the game start.
    public void play(){
        boolean gameIsOver = false;
        String winner = "None";

        System.out.println("********* WELCOME TO WAR *********");

        setup();
        deal();

        while(!gameIsOver){

            System.out.println(player1.toString());
            System.out.println(player2.toString());

            System.out.println(player1.getName() + " has a " + player1.peekCard().getFace() + " and " + player2.getName() + " has a " + player2.peekCard().getFace());
            switch (player1.peekCard().compareTo(player2.peekCard())){

                // If player1 card is less than player2 card
                case -1:
                    System.out.println(player2.getName() + " takes the cards");

                    player2.discard(player2.draw());
                    deck.addToDeck(player1.draw());
                    while(deck.size() > 0){
                        player2.discard(deck.draw());
                    }
                    System.out.println("----------------------------------------");
                    break;
                // If both cards are the same
                case 0:
                    System.out.println("\n****** The game is in WAR mode ******\n");
                    war();

                    // The next if and else if will check if one of the player ran out of cards
                    if(!player1.hasCards()){
                        System.out.println(player1.getName() + " ran out of cards");
                        break;
                    }
                    else if(!player2.hasCards()){
                        System.out.println(player2.getName() + " ran out of cards");
                        break;
                    }

                    break;
                // If player1 card is greater than player2 card
                case 1:
                    System.out.println(player1.getName() + " is takes the cards");

                    player1.discard(player1.draw());
                    deck.addToDeck(player2.draw());

                    while(deck.size() > 0){
                        player1.discard(deck.draw());
                    }

                    System.out.println("----------------------------------------");
                    break;
                default:
                    break;
            }
            if(!player1.hasCards()){
                winner = player2.getName();
                gameIsOver = true;
            }
            else if(!player2.hasCards()){
                winner = player1.getName();
                gameIsOver = true;
            }
        }
        System.out.println("\n" + winner + " won the game!!!!!!!!!!!");
    }

    // This method is private because is for internal use of the class only.
    private void war() {

        for(int i = 0; i < 4; i++) {

            if(player1.peekCard() == null){
                break;
            }
            else if(player2.peekCard() == null){
                break;
            }
            deck.addToDeck(player1.draw());
            deck.addToDeck(player2.draw());
        }
    }
}
