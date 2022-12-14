package playersettings;

import java.time.LocalTime;

public class DateTimerBot implements PlayStrategy {


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
