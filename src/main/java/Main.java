import aipersonality.DateTimerAI;
import aipersonality.RandomizerAI;
import aipersonality.VocalistAI;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameOn gameOn = new GameOn();
        AIPlayer timerNoob = new AIPlayer("TimerNoob", new DateTimerAI());
        AIPlayer theRandomizer = new AIPlayer("TheRandomizer", new RandomizerAI());



        System.out.println("Welcome to Stone-Paper-Scissors Diamond Tournament!");
        System.out.println("What's your player name?");

        String playerName = scanner.next();
        AIPlayer theVocalist = new AIPlayer("TheVocalist", new VocalistAI(playerName));


        gameOn.playGame();

    }


}



















