package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Player;

public class Bug2 {
    private Player _player;
    private int _ballance  = 5;
    private int _bet       = 5;

    @Before
    public void setUp() throws Exception {
        _player = new Player ("Loic", _ballance);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        //execute
        boolean resault = _player.balanceExceedsLimitBy(_bet);
        
        //assert
        assertTrue(resault);
    }

}
