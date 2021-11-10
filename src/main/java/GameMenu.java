import aipersonality.DateTimerBotV2;
import aipersonality.Player;
import aipersonality.RandomizerBot;
import aipersonality.VocalistBot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameMenu {

    List<Participant> participants = new ArrayList<>();


    public void menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Participant timerPro = new Participant("TimerPro", new DateTimerBotV2());
        Participant theRandomizer = new Participant("TheRandomizer", new RandomizerBot());

        System.out.println("Stone Paper Scissors Game 3000");
        System.out.println("Enter your player name");
        String playerName = scanner.next();
        Participant player = new Participant(playerName, new Player());
        Participant theVocalist = new Participant("TheVocalist", new VocalistBot(playerName));

        participants = Arrays.asList(timerPro, theRandomizer, player, theVocalist);
        GameOn gameOn = new GameOn(participants);
        Highscore highscore = new Highscore(participants);

        boolean run = true;

        while (run) {
            System.out.println("""
                    
                    1: To play the game
                    2: To view tournament scores and player stats
                    3: To Exit the game
                     """);
            switch (scanner.nextInt()) {
                case 1 -> gameOn.gameSetup();
                case 2 -> {
                    System.out.println("Showing highscore and stats");
                    highscore.getPlayerStats();
                    gameOn.showHighscore();
                }
                case 3 -> {
                    System.out.println("Exiting game");
                    run = false;
                }

            }

        }

    }

}
