import aipersonality.Playable;

public class AIPlayer {
   private String name;
    private Playable playable;

    public AIPlayer(String name, Playable playable) {
        this.name = name;
        this.playable = playable;
    }

    public String getName() {
        return name;
    }

    public Playable getPlayable() {
        return playable;
    }
}
