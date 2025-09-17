import java.util.ArrayList;

public class Pile {

    private ArrayList<Card> theCards;

    public Pile() {
        this.theCards = new ArrayList<>();
    }

    public Pile(ArrayList<Card> initialCards) {
        // initialCards might be manipulated outside this class - make a copy
        ArrayList<Card> copy = new ArrayList<>(initialCards); // alt. copy = theCards.clone();
        this.theCards = copy;
    }

    public int noOfSuit(Suit suit){
        int counter = 0;
        for(Suit s: Suit.values()){
            if(s == suit) counter++;
        }
        return counter;
    }

    public int noOfRank(Rank rank){
        int counter = 0;
        for(Rank r: Rank.values()){
            if(r == rank) counter++;
        }
        return counter;
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

    public Card get(int index) {
        return theCards.get(index);
    }

    public ArrayList<Card> getCards(){
        return new ArrayList<>(theCards);
    }

    public Card remove(int index) {
        Card c = theCards.remove(index);
        return c;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (theCards.size() > 0) {
            builder.append(theCards.get(0).toShortString());
            for (int i = 1; i < theCards.size(); i++) {
                builder.append(", ").append(theCards.get(i).toShortString());
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
