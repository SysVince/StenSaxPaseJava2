import aipersonality.Playable;

public class Participant {
    private String name;
    private Playable playable;
    private int score = 0;

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

    public void setScore(int score) {
        this.score += score;
    }
    public void resetScore() {
        this.score = 0;
    }
}
