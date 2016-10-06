package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Dice;
import game.DiceValue;
import game.Game;
import game.Player;

public class Bug3 {
    private Game _game;

    @Before
    public void setUp() throws Exception {
        _game = new Game(new Dice(), new Dice(), new Dice());
    }

    @After
    public void tearDown() throws Exception {
        _game = null;
    }

    
    
    /* I had some trouble with this test and it will fail occasionally
     * but not because of the bug.
     * 
     * Given that we are working with random numbers, i had to try to 
     * find a balance between sample size, computational time and 
     * an acceptable tolerance. */
    @Test
    public void test() {
        //arrange
        int totalWins    = 0;
        int sampleSize   = 10000;
        double tolerance = 0.01;
        double expectedOdds  = 0.42;
        
        //execute
        for (int i = 0; i < sampleSize; i++) {
            int winnings = _game.playRound(
                    new Player ("Loic", 5),
                    DiceValue.getRandom(),
                    5);
            
            if (winnings > 0) {
                totalWins++;
            }
        }
        double actualOdds = (double) totalWins / sampleSize;

        //assert
        assertEquals(expectedOdds, actualOdds, tolerance);
        
    }

}
