/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * September 27/2019
 * Project 1
 * -----------------------
 * Objectives:
 * This class is part of the "Project 1" assignment. To see the objectives of this lab please read the readme.txt file
 * This cass is used to create a deck with an array of Card. This class implements the CardDeckInterface.
 *
 * NOTE: The method printDeck() was added for testing purposes.
 */

import java.util.*;

public class CardDeckArray implements CardDeckInterface {

    // This variable will keep track of how many cards there is in the deck.
    private int size = 0;

    // This array will contain all the cards with a max size of 52 cards.
    private Card[] deck = new Card[52];

    // This constructor will fill the deck with all the cards.
    public CardDeckArray(){

        String suit[] = {Card.CLUBS,Card.DIAMONDS,Card.HEARTS,Card.SPADES};

        int index = 0;

        for(int i = 0; i<4; i++){
            for(int j = 2; j<=14; j++){
                deck[index++] = new Card(suit[i], j);
                size++;
            }
        }
    }

    // This method will return the Card on the top of the deck and then swipe all the values to the left.
    @Override
    public Card draw() {
        if(deck[0]== null){
            return null;
        }
        Card topCard = deck[0];
        deck[0] = null;
        size--; // Reducing by 1 the size of the deck.

        // Swipe to the left until it reach the end or a null value.
        for(int i = 0; i<size() - 1; i++){
            if(deck[i + 1] == null){
                break;
            }
            deck[i] =  deck[i + 1];
            deck[i + 1] = null;
        }
        return topCard;
    }

    // This method will shuffle the deck
    @Override
    public void shuffle() {

        for(int i = 0; i<size(); i++){
            Random rand = new Random();
            int index1 = rand.nextInt(size() - 1);
            int index2 = rand.nextInt(size() - 1);
            Card tempCard = deck[index1];
            deck[index1] = deck[index2];
            deck[index2] = tempCard;
        }
    }

    // This method will return the variable size
    @Override
    public int size() {
        return this.size;
    }

    // This method is used to print all the cards in the desk, starting from the top
    public void printDeck(){
        for(int i = 0; i<= size() - 1; i++){
            System.out.println(deck[i].toString());
        }
    }
}
