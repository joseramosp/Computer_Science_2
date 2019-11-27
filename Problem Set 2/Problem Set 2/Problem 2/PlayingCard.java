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

public class PlayingCard extends Card{
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

    public PlayingCard(String suit, int face) {
        super(suit, face);
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
