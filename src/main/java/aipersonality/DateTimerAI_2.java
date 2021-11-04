package aipersonality;

import java.time.LocalTime;

public class DateTimerAI_2 implements Personality {

//TODO; modulus 0 1 2 för minut

    @Override
    public GameChoice play() {
        LocalTime localTime = LocalTime.now();
        int minute = localTime.getMinute();
        if (minute % 3 == 0) {
            return GameChoice.ROCK;
        } else if (minute % 3 == 1) {
            return GameChoice.PAPER;
        } else return GameChoice.SCISSORS; //minute % 3 == 2


    }
}
