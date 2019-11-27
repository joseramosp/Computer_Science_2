/* Problem set 2 - Problem 2

Name: Jose Ramos
Date: September 20, 2019

-- OBJECTIVE --

Look into Tarot cards. You should find their are many similarities between tarot cards and standard playing cards. This
means we can create a generalization - UML chart below. Make a very general Card class. After defining your Card class,
use inheritance through extension to make both the playing card class and the tarot card class. Other design choices
are up to you. Use a CardDeckInterface interface to implement a deck of tarot cards. Write a test program and test your
creation.
*/

import sun.lwawt.macosx.CPrinterDevice;

import java.lang.*;
import java.util.*;

public class TarotDeck extends TarotCard implements CardDeckInterface{

    public TarotDeck(){
        super();
    }

    @Override
    public Card draw() {
        return null;
    }

    @Override
    public void shuffle() {

    }

    @Override
    public int size() {
        return 0;
    }

    public ArrayList<TarotCard> createDeck(ArrayList<TarotCard> deck){

        deck.clear();

        TarotFaceName[] faceNames = TarotFaceName.values();
        TarotGroupName[] groupNames = TarotGroupName.values();
        TarotSuitName[] suitNames = TarotSuitName.values();

        for(TarotSuitName suit : suitNames){
            for(TarotFaceName face : faceNames){
                deck.add(new TarotCard(suit.getSuit(),face.getFaceName(),TarotGroupName.MINOR_ARCANA.getArcana()));
            }
        }

        return deck;
    }

    public void printDeck(ArrayList<TarotCard> deck){

        for(int i = deck.size() - 1; i>=0; i--){
            System.out.println(deck.get(i).toString());
        }
    }

    public static void main(String[] args) {

        TarotDeck test = new TarotDeck();
        TarotCard selector = new TarotCard();

        ArrayList<TarotCard> deck = new ArrayList<TarotCard>();

        test.createDeck(deck);
        test.printDeck(deck);

    }
}
