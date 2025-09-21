package psmodel;

public enum PokerCombo {
    NONE(0),
    PAIR(2),
    TWO_PAIRS(5),
    THREE_OF_A_KIND(10),
    FULL_HOUSE(25), //kåk
    FOUR_OF_A_KIND(50),
    FLUSH(20); //färg

    private final int value;
    PokerCombo(int value){
        this.value = value;
    }

    public int getPoints(){
        return value;
    }
}
