/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * September 27/2019
 * Project 1
 * -----------------------
 * Objectives:
 * This class is part of the "Project 1" assignment. To see the objectives of this lab please read the readme.txt file
 * This interface is implemented in two classes that create an array and an ArrayList of Card.
 *
 * NOTE: The method printDeck() was added for testing purposes.
 */

public interface CardDeckInterface
{
    //return the top card on the deck
    public Card draw();

    //shuffle the deck
    public void shuffle();

    //the number of cards remaining in the deck
    public int size();

    //Prints all the carts in the deck starting on the top
    public void printDeck();
}
