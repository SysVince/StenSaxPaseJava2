import aipersonality.DateTimerAI;
import aipersonality.RandomizerAI;
import aipersonality.VocalistAI;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AIPlayer aiPlayer1 = new AIPlayer("Timerv1", new DateTimerAI());
        AIPlayer aiPlayer2 = new AIPlayer("TheVocalist", new VocalistAI());
        AIPlayer aiPlayer3 = new AIPlayer("TheRandomizer", new RandomizerAI());



        GameOn gameOn = new GameOn();
        System.out.println("Välkommen till StenSaxPåse Diamond Tournament");

        gameOn.playGame();

    }


}



















