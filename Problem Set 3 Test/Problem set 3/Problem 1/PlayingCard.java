/* Problem set 3 - Problem 1

Name: Jose Ramos
Date: October 6, 2019

-- OBJECTIVE --

Create a PlayingCard class that implements the Comparable interface. Your class should also include an equals method.
Create a tester class and test your Card and its compareTo method.
Reference: - https://www.javatpoint.com/Comparable-interface-in-collection-framework
*/

public class PlayingCard implements Comparable<PlayingCard>{
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
        this.face = face;
        this.suit = suit;
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

    public boolean equals(PlayingCard other){
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

    @Override
    public int compareTo(PlayingCard card) {

        if(card.face > this.face)
            return 1;

        else if(card.face < this.face)
            return -1;

        else
            return 0;
    }
}
