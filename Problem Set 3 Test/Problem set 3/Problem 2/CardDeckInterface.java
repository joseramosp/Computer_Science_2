
public interface CardDeckInterface
{
    //return the top card on the deck
    public PlayingCard draw();

    //shuffle the deck
    public void shuffle();

    //the number of cards remaining in the deck
    public int size();

    //Prints all the carts in the deck starting on the top
    public void printCards();

    //Make the deck full
    public void fullDeck();
}
