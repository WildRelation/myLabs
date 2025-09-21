package cardmodel;

public class PileMain {

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();

        // create two hands in a card game
        Pile hand1 = new Pile();
        Pile hand2 = new Pile();

        // deal five cards to each hand
        for(int i = 0; i < 5; i++) {
            hand1.add(deck.dealCard());
            hand2.add(deck.dealCard());
        }
        System.out.println("first hand : "+ hand1);
        System.out.println("second hand: " + hand2);

        //hand1.noOfRank(cardmodel.Rank.TWO);
        System.out.println("Yoy have "+ hand1.noOfSuit(Suit.HEARTS) + "cards of rank HEARTHS ");





        // move the first card in the first hand to the second hand
        Card c = hand1.remove(0);
        hand2.add(c);
        System.out.println("first hand : "+ hand1);
        System.out.println("second hand: " + hand2);

        // clear both hands
        hand1.clear();
        hand2.clear();
        System.out.println("first hand : "+ hand1);
        System.out.println("second hand: " + hand2);
    }
}