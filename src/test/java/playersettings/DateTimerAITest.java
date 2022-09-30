package playersettings;

import org.junit.Ignore;
import org.junit.Test;

import static playersettings.GameChoice.ROCK;
import static playersettings.GameChoice.SCISSORS;
import static org.junit.Assert.*;

public class DateTimerAITest {

    @Test
    @Ignore
    public void testDateTimer() {
        DateTimerBotOLD dateTimerBotOLD = new DateTimerBotOLD();
        GameChoice gameChoice = dateTimerBotOLD.play();
        assertEquals(SCISSORS, gameChoice);
    }

    @Test
    @Ignore
    public void testDateTimer2() {
        DateTimerBot dateTimerBot = new DateTimerBot();
        GameChoice gameChoice = dateTimerBot.play();
        assertEquals(ROCK, gameChoice);
    }

    @Test
    @Ignore
    public void testRandomizer() {
        RandomizerBot randomizerBot = new RandomizerBot();
        GameChoice gameChoice = randomizerBot.play();
        assertEquals(SCISSORS,gameChoice);
    }

    @Test
    public void testVocalist(){
        VocalistBot vocalistBot = new VocalistBot("NEFARIOOOON");
        GameChoice gameChoice = vocalistBot.play();
        assertEquals(SCISSORS,gameChoice);
    }





}