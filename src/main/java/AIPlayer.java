import aipersonality.Personality;

public class AIPlayer {
    String name;
    Personality personality;

    public AIPlayer(String name, Personality personality) {
        this.name = name;
        this.personality = personality;
    }

    public String getName() {
        return name;
    }

    public Personality getPersonality() {
        return personality;
    }
}
