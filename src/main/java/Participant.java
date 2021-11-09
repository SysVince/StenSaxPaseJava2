import aipersonality.Playable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Participant {
    private String name;
    private Playable playable;
    private int score = 0;
    List<Integer> playerRankings = new ArrayList<>();



    public Participant(String name, Playable playable) {
        this.name = name;
        this.playable = playable;
    }

    public String getName() {
        return name;
    }

    public Playable getPlayable() {
        return playable;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
    public void resetScore() {
        this.score = 0;
    }

    public int getHighestPlayerRank() {
        return Collections.max(playerRankings);
    }

    public void addPlayerRank(int playerRank) {
        playerRankings.add(playerRank);
    }

    public int getLowestPlayerRank() {
        return Collections.min(playerRankings);
    }

    public double getAveragePlayerRank() {

        double doubleFormatted = Math.round(playerRankings.stream()
                .mapToDouble(x -> x)
                .average()
                .orElse(0.0)*100)/100.00;
        return doubleFormatted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPlayerRankings() {
        return playerRankings;
    }
}
