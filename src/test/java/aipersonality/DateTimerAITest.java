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
    public void test1() {
        DateTimerAI dateTimerAI = new DateTimerAI();
        GameChoice gameChoice = dateTimerAI.play();
        assertEquals(SCISSORS, gameChoice);
    }





}