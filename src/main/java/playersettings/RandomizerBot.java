package playersettings;

import java.util.Random;

public class RandomizerBot implements PlayStrategy {

    @Override
    public GameChoice play() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1;

        switch (randomNumber) {
            case 1 -> {
                return GameChoice.ROCK;
            }
            case 2 -> {
                return GameChoice.PAPER;
            }
            default -> {
                return GameChoice.SCISSORS;
            }
        }
    }

}
