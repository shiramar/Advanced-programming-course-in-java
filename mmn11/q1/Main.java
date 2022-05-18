import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        warGame();
    }

    //war game
    public static void warGame() {
        String message;
        int flagWar=0;
        
        DeckOfCards deckA = new DeckOfCards();
        DeckOfCards deckB = new DeckOfCards();
        DeckOfCards temp = new DeckOfCards();

        deckA.deckClear();
        deckB.deckClear();

        temp.shuffle();

        firstDivideDeck(deckA, deckB, temp);

        temp.deckClear();

        while(!deckA.checkEmpty() && !deckB.checkEmpty()) {

            Card cardA = deckA.dealCard();
            Card cardB = deckB.dealCard();

            message = "Player A Card is: " + cardA + "\nPlayer B Card is: " + cardB.toString();
            if (flagWar==1){
                flagWar=0;
                message+="\nIs the third card of the war!!\n";

            }
            if (cardA.numCard() > cardB.numCard()) {
                addWinnerDeck(cardA, cardB, deckA, temp);

                message += "\nIn this round player A won";
                JOptionPane.showMessageDialog(null, message);
            }
            else if (cardA.numCard() < cardB.numCard()) {
                addWinnerDeck(cardB, cardA, deckB, temp);

                message += "\nIn this round player B won";
                JOptionPane.showMessageDialog(null, message);
            }
            // 2 card equals , war
            else {
                message+="\nThe card are equal, there is a war!";
                JOptionPane.showMessageDialog(null, message);

                //the two cards after the war irrelevant
                for (int i = 0; i < 2; i++){

                    if(deckA.checkEmpty()|| deckB.checkEmpty())
                        declearWinner(deckA, deckB);
                    cardA = deckA.dealCard();
                    cardB = deckB.dealCard();

                    temp.cardAdd(cardA);
                    temp.cardAdd(cardB);

                    //if it's the card war, sign it for message
                    if(i==1)
                        flagWar=1;
                }
            }
        }

        declearWinner(deckA, deckB);
    }

    //winner declaration ,at end
    public static void addWinnerDeck(Card cardA, Card cardB, DeckOfCards deck, DeckOfCards temp) {
        temp.cardAdd(cardA);
        temp.cardAdd(cardB);
        deck.deckAdd(temp);
        temp.deckClear();
    }

    //first divide for deck
    public static void firstDivideDeck(DeckOfCards deckA,DeckOfCards deckB, DeckOfCards main) {

        for(int i=0;i<52;i++) {
            if(i%2==0)
                deckA.cardAdd(main.dealCard());
            else
                deckB.cardAdd(main.dealCard());
        }
    }

    //declear about the winner in the end
    public static  void declearWinner (DeckOfCards deckA, DeckOfCards deckB) {
        if(deckA.checkEmpty())
            JOptionPane.showMessageDialog(null,  "Player B won the game!");
        else
            JOptionPane.showMessageDialog(null, "Player A won the game!");
    }

}// End class Main

