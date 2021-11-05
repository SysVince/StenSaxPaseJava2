package aipersonality;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static aipersonality.GameChoice.ROCK;
import static aipersonality.GameChoice.SCISSORS;
import static org.junit.Assert.*;

public class DateTimerAITest {

    @Test
    @Ignore
    public void testDateTimer() {
        DateTimerAI dateTimerAI = new DateTimerAI();
        GameChoice gameChoice = dateTimerAI.play();
        assertEquals(SCISSORS, gameChoice);
    }

    @Test
    @Ignore
    public void testDateTimer2() {
        DateTimerAI_2 dateTimerAI_2 = new DateTimerAI_2();
        GameChoice gameChoice = dateTimerAI_2.play();
        assertEquals(ROCK, gameChoice);
    }

    @Test
    @Ignore
    public void testRandomizer() {
        RandomizerAI randomizerAI = new RandomizerAI();
        GameChoice gameChoice = randomizerAI.play();
        assertEquals(SCISSORS,gameChoice);
    }

    @Test
    public void testVocalist(){
        VocalistAI vocalistAI = new VocalistAI("femvokaleer");
        GameChoice gameChoice = vocalistAI.play();
        assertEquals(SCISSORS,gameChoice);
    }





}