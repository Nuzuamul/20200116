/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shihu
 */
public class WarPlayerTest {
    
    public WarPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of play method, of class WarPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        WarPlayer instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDead method, of class WarPlayer.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        WarPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.isDead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWinningsPile method, of class WarPlayer.
     */
    @Test
    public void testGetWinningsPile() {
        System.out.println("getWinningsPile");
        WarPlayer instance = null;
        GeneralDeck expResult = null;
        GeneralDeck result = instance.getWinningsPile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearCard method, of class WarPlayer.
     */
    @Test
    public void testClearCard() {
        System.out.println("clearCard");
        WarPlayer instance = null;
        instance.clearCard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeck method, of class WarPlayer.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        WarPlayer instance = null;
        PlayerDeck expResult = null;
        PlayerDeck result = instance.getDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCard method, of class WarPlayer.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        WarPlayer instance = null;
        Card expResult = null;
        Card result = instance.getCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDying method, of class WarPlayer.
     */
    @Test
    public void testIsDying() {
        System.out.println("isDying");
        WarPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.isDying();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
