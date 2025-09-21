package cardmodel;

import java.util.ArrayList;

public class Pile {

    private final ArrayList<Card> theCards;

    public Pile() {
        this.theCards = new ArrayList<>();
    }

    public int getSize() {
        return theCards.size();
    }

    public void clear() {
        theCards.clear();
    }

    public void add(Card c) {
        theCards.add(c);
    }

    public void add(ArrayList<Card> cards){
        theCards.addAll(cards);
    }

    public Card get(int position) {
        return theCards.get(position);
    }

    public ArrayList<Card> getCards(){
        return new ArrayList<>(theCards);
    }

    public Card remove(int position) {
        Card c = theCards.remove(position);
        return c;
    }

    public boolean remove(Card card){
        return theCards.remove(card);
    }

    /*public cardmodel.Pile(ArrayList<cardmodel.Card> initialCards) {
            // initialCards might be manipulated outside this class - make a copy
            ArrayList<cardmodel.Card> copy = new ArrayList<>(initialCards); // alt. copy = theCards.clone();
            this.theCards = copy;
        }
        */

    public int noOfSuit(Suit suit){
        int counter = 0;
        for(Card card: theCards){
            if(card.getSuit() == suit) counter++;
        }
        return counter;
    }

    public int noOfRank(Rank rank){
        int counter = 0;
        for(Card card: theCards){
            if(card.getRank() == rank) counter++;
        }
        return counter;
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
