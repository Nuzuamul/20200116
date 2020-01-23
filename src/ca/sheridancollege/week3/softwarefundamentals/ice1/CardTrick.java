/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author 
 */
import java.util.*;

public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        for (Card magicHand1 : magicHand) {
            double r = Math.random();
            int suitProb = (int)(4 * r);
            magicHand1.setSuit(Card.SUITS[suitProb]);
            double valueProb0 = 130 * r;
            int valueProb = (int)valueProb0 / 10;
            magicHand1.setValue(valueProb);
        }
        
        
        Scanner scan = new Scanner(System.in);
        
        for (int i = 0; i < magicHand.length; i++)
        {
            int chance = magicHand.length - i;
            System.out.println("Please enter the card in your mind (e.g.: Sp" 
            + "ade 12)" + ". You have " + chance + "chances left!");
        
             String scanS = scan.next();
             int scanV = scan.nextInt();
        
            Card guess = new Card();
            guess.setSuit(scanS);
            guess.setValue(scanV);
            if (guess.equals(magicHand[i])) {
                System.out.println("MAGIC!");
                break;
            }
            System.out.println("No magic! Try again");
            
            //c.setValue(insert call to random number generator here)
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            
        }
        
       
        //insert code to ask the user for Card value and suit, create their card
        // and search magicHand here
        //Then report the result here
    }
    
}