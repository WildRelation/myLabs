package psmodel;

import cardmodel.*;

import java.util.ArrayList;
import java.util.List;

public class PsLogic implements IPsLogic {
    Deck deck;
    Pile[] piles;
    private Card nextCard;
    private int cardCount;

    private static final int MAX_CARDS_IN_PILE = 5;

    public PsLogic(){
        deck = new Deck();
        piles = new Pile[5];
        for (int i = 0; i < piles.length; i++) {
            piles[i] = new Pile();
        }
    }

    @Override
    public void initNewGame(){
        deck.shuffle();
        nextCard = null;
        cardCount = 0;
    }

    @Override
    public int getCardCount() {
        return cardCount;
    }

    @Override
    public Card pickNextCard() throws IllegalStateException {
        if(nextCard != null){
            throw new IllegalStateException("You must place the current card before drawing another");
        }
        Card dealt = deck.dealCard();
        if(dealt == null){
            throw new IllegalStateException("No more cards in the deck");
        }
        nextCard = dealt;
        cardCount++;
        return nextCard;
    }


    @Override
    public void addCardToPile(int pile) throws IllegalStateException {
        if(nextCard == null){
            throw new IllegalStateException("No card has been drawn");
        }
        if(pile < 0 || pile >= piles.length){
            throw new IllegalStateException("Pile not valid");
        }
        if (piles[pile].getSize() >= MAX_CARDS_IN_PILE){
            throw new IllegalStateException("This pile has already 5 cards. PLease choose another pile");
        }
        piles[pile].add(nextCard);
        nextCard = null; //WATCH THIS
    }

    @Override
    public boolean isGameOver() {
        return cardCount >= 25;
    }

    @Override
    public List<Pile> getPiles() {
        List<Pile> tmp = new ArrayList<>();
        for(Pile pile : piles){
            Pile copy = new Pile();
            copy.add(pile.getCards());
            tmp.add(copy);
        }
        return tmp;
    }

    @Override
    public int getPoints() {
        int totalPoints = 0;
        for(Pile pile : piles){
            PokerCombo pokerCombo = PokerHands.getPokerCombos(pile);
            totalPoints += pokerCombo.getPoints();
        }
        return totalPoints;
    }
}
