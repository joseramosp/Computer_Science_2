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

enum TarotGroupName {
    MAJOR_ARCANA("Mayor Arcana"), MINOR_ARCANA("Minor Arcana");

    private String arcana;

    public String getArcana(){
        return this.arcana;
    }

    TarotGroupName(String arcana){
        this.arcana = arcana;
    }
}

enum TarotSuitName{
    WAND("Wand"), PENTACLE("Pentacle"), CUP("Cup"), Sword("Sword");

    private String suit;

    public String getSuit(){
        return this.suit;
    }

    TarotSuitName(String suit){
        this.suit = suit;
    }
}

enum TarotFaceName{

    PAGE(15), ACE(14), KING(13), QUEEN(12), JACK(11), TEN(10), NINE(9), EIGHT(8), SEVEN(7), SIX(6), FIVE(5), FOUR(4),
    THREE(3), TWO(2);

    private int face;

    public int getFaceName(){
        return this.face;
    }

    TarotFaceName(int face){
        this.face = face;
    }

}

public class TarotCard extends Card {

    public TarotCard(String suit, int face, String tarotGroup) {
        super(suit, face);
        this.tarotGroup = tarotGroup;
    }

    private String tarotGroup;

    public TarotCard() {
        super();
    }

    public String getTarotGroup() {
        return tarotGroup;
    }

    public void setTarotGroup(String tarotGroup) {
        this.tarotGroup = tarotGroup;
    }
}
