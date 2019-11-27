/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * September 27/2019
 * Project 1
 * -----------------------
 * Objectives:
 * This class is part of the "Project 1" assignment. To see the objectives of this lab please read the readme.txt file
 * This cass is used to test the classes CardDeckArray and CardDeckArrayList
 *
 * NOTE: Few lines that are commented were added for testing and debugging purposes.
 */

import com.sun.tools.internal.xjc.model.CArrayInfo;
import java.util.ArrayList;

public class CardDeckTester
{
    public static void main(String[] args)
    {
        //using the interface as the type for the reference variable

        //CardDeckInterface deck = new CardDeckArray();     //Deck created with an array of Card

        CardDeckInterface deck = new CardDeckArrayList();   //Deck created with an ArrayList of Card

        Card player1Card, player2Card;

//        System.out.println("Printing Deck:");
//        deck.printDeck();
//        System.out.println("-----------------------------------------------");
        System.out.println("There are "+deck.size()+" cards in the deck");
        System.out.println("Deck is being shuffled");
        deck.shuffle();

//        System.out.println("-----------------------------------------------");
//        System.out.println("Printing Deck:");
//        deck.printDeck();
//        System.out.println("-----------------------------------------------");
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
