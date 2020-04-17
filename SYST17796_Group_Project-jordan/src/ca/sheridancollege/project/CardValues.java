/**
 * CardValues.java
 * 
 * Jordan Graham & Shi Hu 2020-04-10
 * 
 * an enum class for the value of cards in respect to the card game WAR
 */
package ca.sheridancollege.project;

/**
 *
 * @author jrgra
 */
public enum CardValues {
    ACE(14,"Ace"), // aces are high
    TWO(2,"Two"),
    THREE(3,"Three"),
    FOUR(4,"Four"),
    FIVE(5,"Five"),
    SIX(6,"Six"),
    SEVEN(7,"Seven"),
    EIGHT(8,"Eight"),
    NINE(9,"Nine"),
    TEN(10,"Ten"),
    JACK(11,"Jack"),
    QUEEN(12,"Queen"),
    KING(13,"King");

    private final int val; // first value
    private final String name; // second value

    
    /**
     * Constructor
     * @param val the value of the card
     * @param name the name of the card
     */
    private CardValues(int val, String name){
        this.val = val;
        this.name = name;
    }

    /**
     * Getter for the value of the card
     * @return the value of the card
     */
    public int getVal() {
        return val;
    }

    /**
     * Getter for the name of a card
     * @return the name of the card
     */
    public String getName() {
        return name;
    }
}
