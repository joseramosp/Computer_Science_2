/* Problem set 2 - Problem 1

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

Write a class called MyNewDeck which implements the CardDeckInterfae interface iin project 1 and inhertis from ArrayList
(below is the start of the class declaration). Use the main tester from Project 1 to test your creation.
*/

import java.util.*;
import java.lang.*;

public class MyNewDeck extends ArrayList <Card>  implements CardDeckInterface{

    @Override
    public Card draw() {
        return null;
    }

    @Override
    public void shuffle() {

    }

    public static void main(String[] args)
    {
        //using the interface as the type for the reference variable
        CardDeckInterface deck = new MyNewDeck();

        Card player1Card, player2Card;

        System.out.println("There are "+deck.size()+" cards in the deck");
        System.out.println("Deck is being shuffled");
        deck.shuffle();

        System.out.println("Player 1 draws a card");
        player1Card = deck.draw();
        System.out.println("Player 1 drew the " + player1Card);
        System.out.println("There are "+deck.size()+" cards in the deck");

        System.out.println("Player 2 draws a card");
        player2Card = deck.draw();
        System.out.println("Player 2 drew the " + player2Card);
        System.out.println("There are "+deck.size()+" cards in the deck");
    }
}
