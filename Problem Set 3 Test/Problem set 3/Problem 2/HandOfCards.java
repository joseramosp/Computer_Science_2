import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class HandOfCards implements CardDeckInterface{

    private ArrayList<PlayingCard> deck = new ArrayList<>();

    @Override
    public PlayingCard draw() {
        if(deck.isEmpty()){
            return null;
        }
        return deck.remove(0);
    }

    @Override
    public void shuffle() {
        for(int i = 0; i<deck.size(); i++){
            Random rand = new Random();
            int index1 = rand.nextInt(deck.size() - 1);
            int index2 = rand.nextInt(deck.size() - 1);
            PlayingCard card1 = deck.remove(index1);
            PlayingCard card2 = deck.remove(index2);
            PlayingCard tempCard = card1;
            card1 = card2;
            card2 = tempCard;

            deck.add(index1, card1);
            deck.add(index2, card2);
        }
    }

    @Override
    public int size() {
        return deck.size();
    }

    @Override
    public void printCards() {
        for(int i = 0; i<=deck.size() - 1; i++){
            System.out.println(deck.get(i).toString());
        }
    }

    @Override
    public void fullDeck() {
        String suit[] = {PlayingCard.CLUBS,PlayingCard.DIAMONDS,PlayingCard.HEARTS,PlayingCard.SPADES};

        if(!deck.isEmpty())
            deck.clear();

        for(int i = 0; i<4; i++){
            for(int j = 2; j<=14; j++){
                deck.add(new PlayingCard(suit[i], j));
            }
        }
    }

    public void add(PlayingCard card){
        deck.add(card);
    }

    public void sortHand(){
        for(int i = 0; i<deck.size(); i++){
            for(int j = 0; j<deck.size() - 2; j++){
                if(deck.get(j).getFace()<deck.get(j + 1).getFace())
                   deck.add(j+2,deck.remove(j));
            }
        }
    }

}
