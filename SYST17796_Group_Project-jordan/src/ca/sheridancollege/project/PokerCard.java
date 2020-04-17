/*
    PokerCard.java
    Author: Jordan Graham & Shi Hu
    Date: 2020-04-10

    Description
    Class which extends card and represents a Poker Card. can get the value of
    the card and the string representation of the Card
    */

package ca.sheridancollege.project;

/**
 *
 * @author jrgra
 */
public class PokerCard extends Card {
    private CardValues value;
    private String suit;
    private final String[] SUITS = {"Hearts", "Diamonds", "Spades", 
        "Clubs"};
    
    /**
     * constructor for a PokerCard
     * @param val the index of the CardValue enum representing the value of the
     * poker card
     * @param suitNumber the index number for the suit of the card in SUITS
     */
    public PokerCard(int val, int suitNumber) {
        this.value = CardValues.values()[val];
        this.suit = SUITS[suitNumber];
    }
    
    /**
     * getter for the card value
     * @return the value of the card
     */
    @Override
    public int getCardValue() {
        return value.getVal();
    }
    
    /**
     * toString method
     * @return the string representation of the card
     */
    @Override
    public String toString(){
        String cardString = value.getName() + " of " + suit;
        return cardString;
    }
}
