/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * September 27/2019
 * Project 1
 * -----------------------
 * Objectives:
 * This class is part of the "Project 1" assignment. To see the objectives of this lab please read the readme.txt file
 * This cass is used to create a deck with an ArrayList of Card. This class implements the CardDeckInterface.
 *
 * NOTE: The method printDeck() was added for testing purposes.
 */

import java.util.*;

public class CardDeckArrayList implements CardDeckInterface{

    // This ArrayList will contain all the cards.
    private ArrayList<Card> deck = new ArrayList<>();

    // This constructor will fill the deck with all the cards.
    public CardDeckArrayList(){

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

    // This method will return the size of the ArrayList deck
    @Override
    public int size() {
        return deck.size();
    }

    // This method is used to print all the cards in the desk, starting from the top
    public void printDeck(){
        for(int i = 0; i<=deck.size() - 1; i++){
            System.out.println(deck.get(i).toString());
        }
    }

}
