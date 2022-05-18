import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards {
    private ArrayList<Card> deck;
    private static final int NUMBER_OF_CARDS = 52;
    private static final SecureRandom randomNumbers = new SecureRandom();


    public DeckOfCards() {
        deck = new ArrayList<Card>();
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        // populate deck with Card objects
        for (int count = 0; count < NUMBER_OF_CARDS; count++)
            deck.add( new Card(faces[count % 13], suits[count / 13]));
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
        // for each Card, pick another random Card (0-51) and swap them
        for(int first = 0; first < deck.size(); first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card
            Card temp = deck.get(first);
            deck.set(first,deck.get(second));
            deck.set(second,temp);
        }
    }

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (!deck.isEmpty())
            return deck.remove(0); // return current card
        return null; // return null to indicate that all Cards were dealt
    }

    // check if it's empty deck
    public boolean checkEmpty () {
        return deck.size()==0;
    }

    // add one card to deck
    public void cardAdd(Card card) {
        deck.add(card);
    }

    // add temp deck to deck
    public void deckAdd(DeckOfCards  temp) {
        while (!temp.checkEmpty())
            deck.add(temp.dealCard());
    }

    public void deckClear() {
        deck.clear();
    }

} // End class DeckOfCards
