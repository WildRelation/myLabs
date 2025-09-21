package cardmodel;

public class Card implements Comparable<Card>{

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRankValue() {
        return rank.getValue();
    }

    public int getSuitValue() {
        return suit.ordinal(); // default values, 0, 1, 2, 3
    }


    @Override
    public String toString() {
        String info = rank + " of " + suit;
        return info;
    }

    public String toShortString() {
        String info = "";
        switch (rank) {
            case ACE:
                info += 'A';
                break;
            case KING:
                info += 'K';
                break;
            case QUEEN:
                info += 'Q';
                break;
            case JACK:
                info += 'J';
                break;
            default:
                info += getRankValue();
        }
        switch (suit) {
            case SPADES:
                info += '♠';
                break;
            case HEARTS:
                info += '❤';
                break;
            case CLUBS:
                info += '♣';
                break;
            case DIAMONDS:
                info += '♦';
                break;
            default:
                ;
        }
        return info;
    }

    @Override
    public int compareTo(Card o) {
        int result = this.suit.ordinal() - o.suit.ordinal();
        if(result == 0){
            result = this.getRankValue() - o.getRankValue();
        }
        return result;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Card)) return false;
        Card c = (Card) o;
        //return this.suit == c.suit && this.rank == c.rank;
        return this.compareTo(c) == 0;
    }
}