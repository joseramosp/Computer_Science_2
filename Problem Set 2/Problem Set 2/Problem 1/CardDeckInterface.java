public interface CardDeckInterface {
    //return the top card on the deck
    public default Card draw() {
        return null;
    }

    //shuffle the deck
    public void shuffle();

    //the number of cards remaining in the deck
    public int size();
}
