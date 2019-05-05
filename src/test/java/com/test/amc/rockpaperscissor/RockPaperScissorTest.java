package com.test.amc.rockpaperscissor;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RockPaperScissorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValueForRock() {
        RockPaperScissor rockPaperScissor = RockPaperScissor.valueOf(1);
        assertEquals(rockPaperScissor, RockPaperScissor.ROCK);
    }
    @Test
    public void testValueForPaper() {
        RockPaperScissor rockPaperScissor = RockPaperScissor.valueOf(2);
        assertEquals(rockPaperScissor, RockPaperScissor.PAPER);
    }
    @Test
    public void testValueForScissor() {
        RockPaperScissor rockPaperScissor = RockPaperScissor.valueOf(3);
        assertEquals(rockPaperScissor, RockPaperScissor.SCISSOR);
    }

    @Test
    public void testValueForInvalidValue() {
        thrown.expect(IllegalArgumentException.class);
        RockPaperScissor rockPaperScissor = RockPaperScissor.valueOf(4);
    }



}
