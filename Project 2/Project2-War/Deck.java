/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * October 10/2019
 * Project 2
 * -----------------------
 * Objectives:
 * This class is part of the "Project 2" assignment. To see the objectives of this lab please read the readme.txt file
 * This cass is used to create a deck with an ArrayList of Card. This class implements the DeckInterface.
 *
 * NOTE: The method addToDeck() was added to handle the cards that are draw form the players.
 */

import java.util.*;

public class Deck implements DeckInterface{

    // This ArrayList will contain all the cards.
    private ArrayList<Card> deck = new ArrayList<>();

    // This constructor will fill the deck with all the cards.
    public Deck(){

        String suit[] = {Card.CLUBS,Card.DIAMONDS,Card.HEARTS,Card.SPADES};

        for(int i = 0; i<4; i++){
            for(int j = 2; j<=14; j++){
                deck.add(new Card(suit[i], j));
            }
        }
    }

    // This method will return the Card on the top of the deck and remove it from the deck.
    @Override
    public Card draw() {
        if(deck.isEmpty()){
            return null;
        }
        return deck.remove(0);
    }

    // This method will shuffle the deck
    @Override
    public void shuffle() {

        for(int i = 0; i<deck.size(); i++){
            Random rand = new Random();
            int index1 = rand.nextInt(deck.size() - 1);
            int index2 = rand.nextInt(deck.size() - 1);
            Card card1 = deck.remove(index1);
            Card card2 = deck.remove(index2);
            Card tempCard = card1;
            card1 = card2;
            card2 = tempCard;

            deck.add(index1, card1);
            deck.add(index2, card2);
        }
    }
    public void addToDeck(Card card){
        deck.add(card);
    }

    // This method will return the size of the ArrayList deck
    @Override
    public int size() {
        return deck.size();
    }

}
