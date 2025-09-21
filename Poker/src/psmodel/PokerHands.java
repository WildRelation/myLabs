package psmodel;

import cardmodel.Card;
import cardmodel.Pile;
import cardmodel.Rank;
import cardmodel.Suit;

public class PokerHands {


    public static PokerCombo getPokerCombos(Pile p) {
        if (isFourOfAKind(p)) return PokerCombo.FOUR_OF_A_KIND;
        if (isFullHouse(p))   return PokerCombo.FULL_HOUSE;
        if (isFlush(p))       return PokerCombo.FLUSH;
        if (isThreeOfAKind(p)) return PokerCombo.THREE_OF_A_KIND;
        if (isTwoPairs(p))    return PokerCombo.TWO_PAIRS;
        if (isPair(p))        return PokerCombo.PAIR;

        return PokerCombo.NONE;
    }


    private static boolean isPair(Pile p){
        return hasNOfAKind(p, 2) == 1;
    }

    private static boolean isTwoPairs(Pile p) {
        return hasNOfAKind(p, 2) == 2;
    }

    private static boolean isThreeOfAKind(Pile p) {
        return hasNOfAKind(p, 3) == 1;
    }

    private static boolean isFourOfAKind(Pile p) {
        return hasNOfAKind(p, 4) == 1;
    }

    private static boolean isFullHouse(Pile p) {
        return hasNOfAKind(p, 3) == 1 && hasNOfAKind(p, 2) == 1;
    }

    private static boolean isFlush(Pile pile) {
        for (Suit suit : Suit.values()) {
            if (pile.noOfSuit(suit) == 5) {
                return true;
            }
        }
        return false;
    }



    private static int hasNOfAKind(Pile pile, int n) {
        int count = 0;
        for (Rank rank : Rank.values()) {
            if (pile.noOfRank(rank) == n) {
                count++;
            }
        }
        return count;
    }
}
