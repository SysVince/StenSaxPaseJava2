package playersettings;

import playersettings.PlayStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participant {
    private String name;
    private PlayStrategy playable;
    private int score = 0;
    private List<Integer> playerRankings = new ArrayList<>();


    public Participant(String name, PlayStrategy playable) {
        this.name = name;
        this.playable = playable;
    }

    public String getName() {
        return name;
    }

    public PlayStrategy getPlayable() {
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

        return Collections.min(playerRankings);
    }

    public void addPlayerRank(int playerRank) {
        playerRankings.add(playerRank);
    }

    public int getLowestPlayerRank() {
        return Collections.max(playerRankings);
    }

    public double getAveragePlayerRank() {

        return Math.round(playerRankings.stream()
                .mapToDouble(x -> x)
                .average()
                .orElse(0.0) * 100) / 100.00;
    }

    public List<Integer> getPlayerRankings() {
        return playerRankings;
    }
}
