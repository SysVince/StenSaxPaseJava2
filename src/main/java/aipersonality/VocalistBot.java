package aipersonality;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class VocalistBot implements Playable {
    String playerName;
    int playerVocals = 0;

    public VocalistBot(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public GameChoice play() {
        Pattern pattern = Pattern.compile("[aouåeiyäö]");
        Matcher matcher = pattern.matcher(playerName);

        while (matcher.find()) {
            playerVocals++;
        }

        if (playerVocals < 3) {
            return GameChoice.ROCK;
        } else if (playerVocals < 4) {
            return GameChoice.PAPER;
        } else return GameChoice.SCISSORS;
    }
}
