/*
    GeneralDeck.java
    Author: Jordan Graham & Shi Hu
    Date: 2020-04-10

    Description
    A general deck class with the capability to add one or more cards, and clear
    the deck.
    */

package ca.sheridancollege.project;

import java.util.List;

/**
 *
 * @author jrgra
 */
public class GeneralDeck extends GroupOfCards {
    
    // constructor
    public GeneralDeck(int size) {
        super(size);
    }
    
    /**
     * Method to add a list of cards to the deck
     * @param cardPile the list of cards to add to the deck
     */
    public void addCards(List<Card> cardPile){
        for (Card card : cardPile) {
            //calls @addCard(Card card)
            addCard(card);
        }
    }
    
    /**
     * Method to add card to the deck
     * @param card the card to add to the deck
     */
    public void addCard(Card card) {
        super.showCards().add(card);
        // update the size of the deck
        super.setSize(super.showCards().size());
    }
    
    
    /**
     * Method to that empties the deck 
     */
    public void clearDeck(){
        super.showCards().clear();
        super.setSize(0);
    }
}
