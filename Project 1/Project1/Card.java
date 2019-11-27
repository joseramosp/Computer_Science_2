/*
 * Jose Ramos
 * Student ID: 00299444
 * CIS 252 - T-7847
 * September 27/2019
 * Project 1
 * -----------------------
 * Objectives:
 * This class is part of the "Project 1" assignment. To see the objectives of this lab please read the readme.txt file
 * This cass is used to create a Card object that is used in others classes (An ArrayList and an array of Card).
 */

public class Card
{
    public static final String CLUBS = "Clubs";
    public static final String HEARTS = "Hearts";
    public static final String DIAMONDS = "Diamonds";
    public static final String SPADES = "Spades";
    public static final int ACE = 14;
    public static final int KING = 13;
    public static final int QUEEN = 12;
    public static final int JACK = 11;

    private String suit;
    private int face;

    public Card(String suit, int face){
        this.suit = suit;
        this.face = face;
    }

    public String getSuit(){
        return suit;
    }

    public void setSuit(String suit){
        this.suit = suit;
    }

    public int getFace(){
        return face;
    }

    public void setFace(int face){
        this.face = face;
    }

    public String toString(){
        return "Card{" + "suit=" + suit + ", face=" + face + '}';
    }

    public boolean equals(Card other){
        boolean result = false;
        try{
            boolean suitMatch = this.suit.equals(other.getSuit());
            boolean faceMatch = this.face == other.getFace();

            if(suitMatch && faceMatch){
                result = true;
            }
        }
        catch (NullPointerException e){
            result = false;
        }
        return result;
    }
}
