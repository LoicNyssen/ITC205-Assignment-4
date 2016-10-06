package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import game.Dice;
import game.DiceValue;
import game.Game;
import game.Player;

public class Bug1 {
    private Game   _game   = null;
    private Player _player = null;
    
    private int _balance  = 50;
    private int _bet       = 5;
    
    private Dice _dice1, _dice2, _dice3;

    @Before
    public void setUp() throws Exception {
        _player = new Player ("Loic", _balance);
        
        _dice1 = mock(Dice.class);
        _dice2 = mock(Dice.class);
        _dice3 = mock(Dice.class);
    }

    @Test
    public void testBug1() {
        //arrange
        when(_dice1.getValue()).thenReturn(DiceValue.ANCHOR);
        when(_dice2.getValue()).thenReturn(DiceValue.CROWN);
        when(_dice3.getValue()).thenReturn(DiceValue.CROWN);
        
        _game = new Game(_dice1, _dice2, _dice3);
        
        //execute
        _game.playRound(_player, DiceValue.ANCHOR, _bet);
        _balance += _bet;
        
        //assert
        assertEquals(_balance, _player.getBalance());
    }
}
