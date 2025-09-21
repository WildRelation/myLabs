package cardmodel;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private static final ArrayList<Card> protoDeck = new ArrayList<>();
    static{
        for(Suit s: Suit.values()){
            for(Rank r : Rank.values()){
                protoDeck.add(new Card(r, s));
            }
        }
    }

    ArrayList<Card> theCards;

    public Deck() {
        theCards = new ArrayList<>();
        fill();
    }

    public void fill() {
        theCards.clear();
        theCards.addAll(protoDeck);
    }


    public int getSize() {
        return theCards.size();
    }


    public Card dealCard() {
        return theCards.remove(theCards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(theCards);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (!theCards.isEmpty()) {
            builder.append(theCards.getFirst().toShortString());
            for (int i = 1; i < theCards.size(); i++) {
                builder.append(", ").append(theCards.get(i).toShortString());
            }
        }
        builder.append("]");

        return builder.toString();
    }
}