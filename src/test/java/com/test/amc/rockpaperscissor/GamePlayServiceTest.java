package com.test.amc.rockpaperscissor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GamePlayServiceTest {

    //private GamePlayService gamePlayService;
    private GamePlayService spyPlayService;

    @Before
    public void init() {
       // gamePlayService = new GamePlayService();
        spyPlayService = spy(GamePlayService.class);
    }

    @Test
    public void testPaperBeatsRock(){
        when(spyPlayService.computerPick()).thenReturn(RockPaperScissor.ROCK);
        String result = spyPlayService.getGameResults(2);
        assertEquals(result,"You win!- - Computer pick was - ROCK");
    }

    @Test
    public void testRockBeatsScissor() {
        when(spyPlayService.computerPick()).thenReturn(RockPaperScissor.SCISSOR);
        String result = spyPlayService.getGameResults(1);
        assertEquals(result,"You win!- - Computer pick was - SCISSOR");

    }

    @Test
    public void testScissorBeatsPaper() {
        when(spyPlayService.computerPick()).thenReturn(RockPaperScissor.PAPER);
        String result = spyPlayService.getGameResults(3);
        assertEquals(result,"You win!- - Computer pick was - PAPER");

    }

    @Test
    public void testGameOnTillComputerWinsIsNot_MoreThanHalf() {
        spyPlayService.setInitialNumberOfGames(5);
        spyPlayService.computerWins.set(2);
        boolean gameOn = spyPlayService.gameOn();
        assertEquals(gameOn,true);
    }

    @Test
    public void testGameOnTillComputerWinsIs_MoreThanHalf() {
        spyPlayService.setInitialNumberOfGames(5);
        spyPlayService.computerWins.set(3);
        boolean gameOn = spyPlayService.gameOn();
        assertEquals(gameOn,false);
    }

    @Test
    public void testGameOnTillUserWinsIsNot_MoreThanHalf() {
        spyPlayService.setInitialNumberOfGames(5);
        spyPlayService.userWins.set(2);
        boolean gameOn = spyPlayService.gameOn();
        assertEquals(gameOn,true);
    }

    @Test
    public void testGameOnTillUserWinsIs_MoreThanHalf() {
        spyPlayService.setInitialNumberOfGames(5);
        spyPlayService.userWins.set(3);
        boolean gameOn = spyPlayService.gameOn();
        assertEquals(gameOn,false);
    }

}
