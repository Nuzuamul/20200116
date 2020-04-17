/*
    WarPlayer.java
    Author: Jordan Graham & Shi Hu
    Date: 2020-04-12

    Description
    A subclass of the Player class, each player in the game war has a deck,
    winningsPile and a card in play, each player has a status; players with no
    cards at all are "dead" and players whose only card is the one in play are
    considered dying
    */

package ca.sheridancollege.project;

/**
 *
 * @author jrgra
 */
public class WarPlayer extends Player {
    private GeneralDeck winningsPile;
    private PlayerDeck deck;
    private Card cardInPlay;
   
    
    /**
     * constructor for WarPlayer
     * @param name the player's name (ID)
     */
    public WarPlayer(String name) {
        super(name);
        // creates the deck and the winningsPile
        winningsPile = new GeneralDeck(0);
        deck = new PlayerDeck(0);
    }
    

    /**
     * play is a method representing the players "play" for a round, in war each
     * round you draw a card from your deck, if your deck is empty you shuffle 
     * your winningsPile and it becomes your deck, then you draw from it.
     */
    @Override
    public void play(){
        // draws from deck if deck is not empty
        if (deck.showCards().size() > 0) {
            cardInPlay = deck.drawCard();            
        } else if (winningsPile.showCards().size() > 0) {
            // else convert winningsPile to deck and draw if winningsPile is not
            // empty
            deck.addCards(winningsPile.showCards().subList(0, 
                    winningsPile.showCards().size()));
            winningsPile.clearDeck();
            deck.shuffle();
            cardInPlay = deck.drawCard();
        }
    }
    
    
    /**
     * method that returns a boolean value representing if the player is dead or
     * not
     * @return true if the player has no cardInPlay and both deck and 
     * winningsPile are empty, true otherwise
     */
    @Override
    public boolean isDead(){
        if (deck.getSize() == 0 && winningsPile.getSize() == 0 && 
                cardInPlay == null) {
            return true;
        }
        return false;
    }
    
    
    /**
     * getter to access the player's winningsPile
     * @return the winningsPile
     */
    public GeneralDeck getWinningsPile() {
        return winningsPile;
    }

    
    /**
     * method to clear the cardInPlay
     */
    @Override
    public void clearCard() {
        this.cardInPlay = null;
    }

    /**
     * getter that returns the deck
     * @return player's deck
     */
    @Override
    public PlayerDeck getDeck() {
        return deck;
    }

    /**
     * getter to return the cardInPlay
     * @return the card the user drew
     */
    @Override
    public Card getCard() {
        return cardInPlay;
    }
    
    /**
     * method to check if the player is dying
     * @return true if the player's deck and winningsPile are empty, otherwise
     * return false
     */
    @Override
    public boolean isDying(){
        if (deck.getSize() == 0 && winningsPile.getSize() == 0) {
            return true;
        }
        return false;
    }
}
