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

        ArrayList<PlayingCard> deck = new ArrayList<>();
        ArrayList<PlayingCard> player1 = new ArrayList<>();
        ArrayList<PlayingCard> player2 = new ArrayList<>();

        String[] suits = {PlayingCard.SPADES, PlayingCard.CLUBS, PlayingCard.DIAMONDS, PlayingCard.HEARTS};


        for (String suit: suits) {
            for (int i = 2; i<=14; i++){
                deck.add(new PlayingCard(suit,i));
            }
        }

        deck.add(new PlayingCard(PlayingCard.HEARTS, 10));
        deck.add(new PlayingCard(PlayingCard.HEARTS, 10));
        deck.add(new PlayingCard(PlayingCard.HEARTS, 10));
        deck.add(new PlayingCard(PlayingCard.HEARTS, 10));
        deck.add(new PlayingCard(PlayingCard.HEARTS, 10));
        deck.add(new PlayingCard(PlayingCard.HEARTS, 10));


        tester.shuffle(deck);
        //tester.printDeck(deck);

        while(!deck.isEmpty()){
            player1.add(deck.remove(0));
            if(!deck.isEmpty())
                player2.add(deck.remove(0));
        }
        //System.out.println("---------------------------");
        //tester.printDeck(player1);
        //System.out.println("---------------------------");
        //tester.printDeck(player2);

        while(true){
            if(player1.isEmpty() || player2.isEmpty())
                break;
            else{
                if(player1.get(0).equals(player2.get(0))) {
                    System.out.println("GAME IS OVER: Both players have the same card");
                    break;
                }
                else if(player1.get(0).compareTo(player2.get(0)) == -1)
                    System.out.println("Player 1 card is less than Player 2 card");
                else if(player1.get(0).compareTo(player2.get(0)) == 0)
                    System.out.println("Player 1 and 2 card have the same face");

                else if(player1.get(0).compareTo(player2.get(0)) == 1)
                    System.out.println("Player 1 card is grater than player 2 Card");

                player1.remove(0);
                player2.remove(0);
            }
        }

    }

    public void printDeck(ArrayList<PlayingCard> deck){
        for(int i = 0; i<=deck.size() - 1; i++){
            System.out.println(deck.get(i).toString());
        }
    }

    public void shuffle(ArrayList<PlayingCard> deck) {

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
}
