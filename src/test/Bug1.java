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
    
    private int _ballance  = 50;
    private int _bet       = 5;
    
    private Dice dice1_, dice2_, dice3_;

    @Before
    public void setUp() throws Exception {
        _player = new Player ("Loic", _ballance);
        
        dice1_ = mock(Dice.class);
        dice2_ = mock(Dice.class);
        dice3_ = mock(Dice.class);
    }

    @Test
    public void testBug1() {
        //arrange
        when(dice1_.getValue()).thenReturn(DiceValue.ANCHOR);
        when(dice2_.getValue()).thenReturn(DiceValue.CROWN);
        when(dice3_.getValue()).thenReturn(DiceValue.CROWN);
        
        _game = new Game(dice1_, dice2_, dice3_);
        
        //execute
        _game.playRound(_player, DiceValue.ANCHOR, _bet);
        _ballance += _bet;
        
        //assert
        assertEquals(_ballance, _player.getBalance());
    }
}
