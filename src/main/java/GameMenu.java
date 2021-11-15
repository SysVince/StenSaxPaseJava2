import playersettings.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameMenu {

    private List<Participant> participants = new ArrayList<>();


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
        GameStart gameStart = new GameStart(participants);


        boolean run = true;

        while (run) {
            System.out.println("""
                                        
                    1: To play the game
                    2: To view tournament scores and player stats
                    3: To Exit the game
                     """);
            switch (scanner.nextInt()) {
                case 1 -> gameStart.gameSetup();
                case 2 -> {
                    System.out.println("Showing highscore and stats");
                    gameStart.getHighscore().getPlayerStats();
                    gameStart.getHighscore().showTournamentHistory();
                }
                case 3 -> {
                    System.out.println("Exiting game");
                    run = false;
                }

            }

        }

    }

}
