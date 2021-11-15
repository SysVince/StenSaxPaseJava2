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
        DateTimerBot dateTimerBot = new DateTimerBot();
        GameChoice gameChoice = dateTimerBot.play();
        assertEquals(SCISSORS, gameChoice);
    }

    @Test
    @Ignore
    public void testDateTimer2() {
        DateTimerBotV2 dateTimerBotV2 = new DateTimerBotV2();
        GameChoice gameChoice = dateTimerBotV2.play();
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