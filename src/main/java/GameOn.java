import aipersonality.*;

import java.util.*;
import java.util.stream.Stream;

public class GameOn {
    List<String> tournamentRanking = new ArrayList<>();


    public void gameSetup() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        GameOn gameOn = new GameOn();
      //  Participant timerNoob = new Participant("TimerNoob", new DateTimerBot());
        Participant timerPro = new Participant("TimerPro", new DateTimerBotV2());
        Participant theRandomizer = new Participant("TheRandomizer", new RandomizerBot());


        System.out.println("Welcome to Stone-Paper-Scissors Diamond Tournament!");
        System.out.println("What's your player name?");
        String playerName = scanner.next();
        Participant player = new Participant(playerName,new Player());

        Participant theVocalist = new Participant("TheVocalist", new VocalistBot(playerName));


        System.out.println("****LET THE GAMES BEGIN!!****");
        gameOn.playGame(theRandomizer,player);
        Thread.sleep(1000);
        gameOn.playGame(timerPro,player);
        Thread.sleep(1000);
        gameOn.playGame(theVocalist,player);
        Thread.sleep(1000);
        gameOn.playGame(theVocalist,theRandomizer);
        Thread.sleep(1000);
        gameOn.playGame(timerPro,theRandomizer);
        Thread.sleep(1000);
        gameOn.playGame(theVocalist,timerPro);

        System.out.println("randomizer:"+theRandomizer.getScore());
        System.out.println("timerpro:"+timerPro.getScore());
        System.out.println("thevocalist:"+theVocalist.getScore());
        System.out.println("player:"+player.getScore());

        List<Participant> sortMatchup = Stream.of(theRandomizer, timerPro, theVocalist, player)
                .sorted(Comparator.comparing(Participant::getScore).reversed())
                .toList();

        System.out.println("\nWelcome to the finals!\n");
        playOff(sortMatchup.get(0),sortMatchup.get(1));

        System.out.println("\nWelcome to the bronze place playoff!\n");
        playOff(sortMatchup.get(2),sortMatchup.get(3));


        tournamentRanking.forEach(System.out::println);




    }

    public void playGame(Participant player1, Participant player2) {


        System.out.printf("\n%s vs %s\n",player1.getName(),player2.getName());

            GameChoice play1 = player1.getPlayable().play();
            GameChoice play2 = player2.getPlayable().play();
            System.out.println(player1.getName() +" chose: "+ play1);
            System.out.println(player2.getName() +" chose: "+ play2);

            if (play1 == play2) {
                System.out.println("It is a tie!");
                player1.setScore(1);
                player2.setScore(1);
            } else if ((play1.equals(GameChoice.ROCK) && play2.equals(GameChoice.SCISSORS)) ||
                    (play1.equals(GameChoice.SCISSORS) && play2.equals(GameChoice.PAPER)) ||
                    (play1.equals(GameChoice.PAPER) && play2.equals(GameChoice.ROCK))) {
                System.out.println(player1.getName() + " won the game");
                player1.setScore(3);
            } else {
                System.out.println(player2.getName() + " won the game");
                player2.setScore(3);
            }
        }

    public void playOff(Participant player1, Participant player2) {
        int tries = 0;

        System.out.printf("%s vs %s\n",player1.getName(),player2.getName());

        while (tries<6) {
            GameChoice play1 = player1.getPlayable().play();
            GameChoice play2 = player2.getPlayable().play();
            System.out.println(player1.getName() + " chose: " + play1);
            System.out.println(player2.getName() + " chose: " + play2);

            if (play1 == play2) {
                System.out.println("It is a tie!");
                System.out.println("We need a winner there cannot be a tie!");
                tries++;
                if(tries ==5){
                    System.out.println("A TIE AGAIN SO ROLL THE DICE THE WINNERRR!");
                    Random random = new Random();
                   int randomNum = random.nextInt(2)+1;
                    if (randomNum == 1) {
                        System.out.println(player1.getName() + " Won the match!");
                        tournamentRanking.add(player1.getName());
                        tournamentRanking.add(player2.getName());
                    } else {
                        System.out.println(player2.getName() + " Won the match!");
                        tournamentRanking.add(player2.getName());
                        tournamentRanking.add(player1.getName());
                    }
                }
            } else if ((play1.equals(GameChoice.ROCK) && play2.equals(GameChoice.SCISSORS)) ||
                    (play1.equals(GameChoice.SCISSORS) && play2.equals(GameChoice.PAPER)) ||
                    (play1.equals(GameChoice.PAPER) && play2.equals(GameChoice.ROCK))) {
                System.out.println(player1.getName() + " Won the match!");
                tournamentRanking.add(player1.getName());
                tournamentRanking.add(player2.getName());

                break;
            } else {
                System.out.println(player2.getName() + " Won the match!");
                tournamentRanking.add(player2.getName());
                tournamentRanking.add(player1.getName());
                break;
            }
        }
    }


}

