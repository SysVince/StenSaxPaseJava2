package playersettings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VocalistBot implements PlayStrategy {
    String playerName;
    int playerVocals = 0;

    public VocalistBot(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public GameChoice play() {
        Pattern pattern = Pattern.compile("[aouåeiyäöAOUÅEIYÄÖ]");
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
