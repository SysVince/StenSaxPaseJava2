import aipersonality.DateTimerBot;
import aipersonality.RandomizerBot;
import aipersonality.VocalistBot;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameOn gameOn = new GameOn();
        AIPlayer timerNoob = new AIPlayer("TimerNoob", new DateTimerBot());
        AIPlayer theRandomizer = new AIPlayer("TheRandomizer", new RandomizerBot());




        System.out.println("Welcome to Stone-Paper-Scissors Diamond Tournament!");
        System.out.println("What's your player name?");

        String playerName = scanner.next();
        AIPlayer theVocalist = new AIPlayer("TheVocalist", new VocalistBot(playerName));


        gameOn.playGame();

    }


}



















