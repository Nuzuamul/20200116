/*
    War.java
    Author: Jordan Graham & Shi Hu
    Date: 2020-04-12

    Description
    The main class for the application, creates an instance of the game WAR
    The game lasts until either the player or the CPU lose all their cards
    ace is highest, except agains 6
    */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author jrgra
 */
public class War extends Game{
    
    
    private final WarPlayer player;
    private final WarPlayer cpu = new WarPlayer("CPU");
    private final ArrayList<Player> players;
    private final GeneralDeck gameDeck;
    Scanner in = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        System.out.println("WAR IS UPON US!");
        System.out.println("CARDS ARE YOUR BLOOD! AND YOUR WARRIORS!");
        System.out.println("DRAW AND COMBAT! THE BIGGER CARD WINS THE ROUND!");
        System.out.println("ACE RULES, BUT FALLS PREY TO 6, SUMMONER OF DEMONS");
        System.out.println("READY NOW? TO DEATH!!!\n");
        
        War game = new War("War");
        game.play();
    }
    
    /**
    * constructor for the game WAR
    * @param name - the name of the game
    */
    public War(String name) {
        // contructs the parent class
        super(name);
        // initialize the game deck
        gameDeck = new GeneralDeck(52);
        // create array of players
        players = new ArrayList<>();
        
        // creates a new player
        System.out.print("Enter player name: ");
        player = new WarPlayer(in.nextLine());
        
        // adds the player and the cpu to the players ArrayList
        players.add(cpu);
        players.add(player);
        // adds the players to the list of players
        super.setPlayers(players);
        
        // populates the gameDeck with PokerCards
        System.out.println("Initializing game deck");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new PokerCard(j, i);
                gameDeck.addCard(card);
            }

        }
        
        //shuffles the game deck
        gameDeck.shuffle();
        System.out.println("Finished initializing game deck");
    }
    
    
    
    /**
    * method to get check if the game is in a state to continue or end
    * @return false if the any of the Players are "dead" (empty deck/winnings 
    * pile, and no card in play)
    */
    public boolean continueGame(){
        for (Player p : super.getPlayers()) {
            // check if p is dead
            if (p.isDead()) {
                return false;
            }
        }
        return true;
    }
    
    /**
    * method to get check if Player p1 wins the round
    * @param p1 is the Player you want to check if they won
    * @param p2 is the opponent
    * @return false if the value of p1's CardInPlay is less than the value of p2
    * CardInPlay (exception: if p1's card is 6, and p2's card is an ace, p1 win)
    * otherwise it returns true
    */
    public boolean winRound(Player p1, Player p2) {
        if (p1.getCard().getCardValue() == 6 && 
                p2.getCard().getCardValue() == 14) {
            return true;
        } else if (p1.getCard().getCardValue() == 14 && 
                p2.getCard().getCardValue() == 6) {
            return false;
        }
        return (p1.getCard().getCardValue() > p2.getCard().getCardValue());
    }
    
    
    /**
    * method that adds the Cards in play to the game deck (and removes them from
    * the player)
    * @param p1 a player
    * @param p2 a player
    * @param gameDeck is the "graveyard" deck
    */
    public void winner(Player p1, Player p2, GeneralDeck gameDeck){
        gameDeck.addCard(p1.getCard());
        gameDeck.addCard(p2.getCard());
        p1.clearCard();
        p2.clearCard();
    }
    
    /**
    * method that declares the winner of the game
    */
    @Override
    public void declareWinner(){
        //only the not-dead player is the winner
        for (Player p : super.getPlayers()) {
            if (!(p.isDead())) {
                System.out.printf("%s IS THE WINNER!", p.getPlayerID());
                break;
            }
        }
    }
    
    /**
    * method that plays the game
    */
    @Override
    public void play(){
        // adds the players to the list of players
        super.setPlayers(players);
        
        // populates the gameDeck with PokerCards
        System.out.println("Initializing game deck");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new PokerCard(j, i);
                gameDeck.addCard(card);
            }

        }
        
        //shuffles the game deck
        gameDeck.shuffle();
        System.out.println("Finished initializing game deck");
        System.out.println("Initializing Player decks");
        
        // adding cards to both the player and the cpu decks
        player.getDeck().addCards(gameDeck.showCards().subList(0, 
                gameDeck.getSize() / 2));

        cpu.getDeck().addCards(gameDeck.showCards().subList(gameDeck.getSize() 
                / 2, gameDeck.getSize()));

        gameDeck.clearDeck();
        System.out.println("Finished initializing Player decks");
        
        //prompts the user to start the game with enter
        System.out.println("Press enter to start the game");
        in.nextLine();
        
        // while neither player is dead
        while (continueGame()) {
            
            // both player and cpu draw a card and display the card
            player.play();
            System.out.printf("%s has drawn %s \n", player.getPlayerID(), 
                    player.getCard());
            cpu.play();
            System.out.printf("%s has drawn %s \n", cpu.getPlayerID(), 
                    cpu.getCard());
            
            // checks if the player wins the round
            if (winRound(player, cpu)) {
                // adds the cards to the gamedeck then the game deck to the
                // player deck
                winner(player, cpu, gameDeck);
                player.getWinningsPile().addCards(gameDeck.showCards().subList(0
                        , gameDeck.getSize()));
                // empties the game deck
                gameDeck.showCards().clear();
                System.out.printf("%s wins round\n", player.getPlayerID());
            } else if (winRound(cpu, player)) { // if the cpu wins
                // adds the cards to the gamedeck then the game deck to the
                // cpu deck
                winner(cpu, player, gameDeck);
                cpu.getWinningsPile().addCards(gameDeck.showCards().subList(0, 
                        gameDeck.getSize()));
                // empties the game deck
                gameDeck.showCards().clear();
                System.out.println("CPU wins round");
            } else {
                // if its a draw, check to see if either the cpu or player is
                // dying, if so, dont add the card to the gameDeck
                if (!(player.isDying())) {
                    gameDeck.addCard(player.getCard());
                    player.clearCard();
                }
                if (!(cpu.isDying())) {
                    gameDeck.addCard(cpu.getCard());
                    cpu.clearCard();
                }
                System.out.println("DRAW");
            }
            // shows the current status of the game
            System.out.printf("%s's deck: %d winnings: %d \n", 
                    player.getPlayerID(), player.getDeck().getSize(), 
                    player.getWinningsPile().getSize());
            System.out.printf("CPU deck: %d winnings: %d \n", 
                    cpu.getDeck().getSize(),  
                    cpu.getWinningsPile().getSize());
            System.out.println("Press Enter to go to the next round");
            in.nextLine();
        }
        //display the winner
        declareWinner();
    }
}
