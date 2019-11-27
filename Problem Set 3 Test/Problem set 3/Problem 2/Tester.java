/* Problem set 3 - Problem 1

Name: Jose Ramos
Date: October 6, 2019

-- OBJECTIVE --

Create a PlayingCard class that implements the Comparable interface. Your class should also include an equals method.
Create a tester class and test your Card and its compareTo method.
Reference: - https://www.javatpoint.com/Comparable-interface-in-collection-framework
*/

import java.util.*;

public class Tester {

    public static void main(String[] args) {
        Tester tester = new Tester();

        CardDeckInterface deck = new HandOfCards();
        HandOfCards hand1 = new HandOfCards();
        HandOfCards hand2 = new HandOfCards();

        deck.fullDeck();
        deck.shuffle();

        for(int i = 0; i<5; i++){
            hand1.add(deck.draw());
            hand2.add(deck.draw());
        }

        hand1.sortHand();
        hand2.sortHand();

        System.out.println("Printing the Hand 1:");
        hand1.printCards();
        System.out.println("--------------------");
        System.out.println("Printing the Hand 2:");
        hand2.printCards();

    }
}
