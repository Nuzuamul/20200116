/*
    PlayerDeck.java
    Author: Jordan Graham & Shi Hu
    Date: 2020-04-10

    Description
    PlayerDeck is a subclass of GeneralDeck, and has the capability to draw a
    card from the deck
    */

package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author jrgra
 */
public class PlayerDeck extends GeneralDeck {
    
    /**
     * Constructor for a PlayerDeck
     * @param size the size of the deck
     */
    public PlayerDeck(int size) {
        super(size);
        
    }
    
    /**
     * method to draw a card from the deck
     * @return the Card object removed from the deck
     */
    public Card drawCard(){
        // removes the card from the deck
        Card card = super.showCards().remove(0);
        // updates the size
        super.setSize(super.showCards().size());
        return card;
    }
}
