package aipersonality;

import java.time.LocalTime;

public class DateTimerBot implements PlayStrategy {


    @Override
    public GameChoice play() {
        LocalTime localTime = LocalTime.now();
        int minute = localTime.getMinute();
        if (minute < 20) {
            return GameChoice.ROCK;
        } else if (minute < 40) {
            return GameChoice.PAPER;
        } else return GameChoice.SCISSORS;

    }
}
