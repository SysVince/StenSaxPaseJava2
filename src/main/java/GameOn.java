import aipersonality.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class GameOn extends Highscore{

    Highscore highscore;
    List<Participant> participants;
    List<Participant> participantsSorted = new ArrayList<>();



    public GameOn(List<Participant> participants) {
        this.participants = participants;

    }

    public void gameSetup(Highscore highscore) throws InterruptedException {
        this.highscore = highscore;


        System.out.println("Welcome to Stone-Paper-Scissors Diamond Tournament!");



        System.out.println("****LET THE GAMES BEGIN!!****");
        playGame(participants.get(2), participants.get(0));
//        Thread.sleep(500);
        playGame(participants.get(2), participants.get(1));
//        Thread.sleep(500);
        playGame(participants.get(2), participants.get(3));
//        Thread.sleep(500);
        playGame(participants.get(3), participants.get(0));
//        Thread.sleep(500);
        playGame(participants.get(3), participants.get(1));
//        Thread.sleep(500);
        playGame(participants.get(0), participants.get(1));

        //Ska fixas
        System.out.println(participants.get(0).getName() + ":" + participants.get(0).getScore());
        System.out.println(participants.get(1).getName() + ":" + participants.get(1).getScore());
        System.out.println(participants.get(2).getName() + ":" + participants.get(2).getScore());
        System.out.println(participants.get(3).getName() + ":" + participants.get(3).getScore());


        //Sorterar för att matcha de med högst poäng mot varandra osv.
        List<Participant> sortMatchup = participants
                .stream()
                .sorted(Comparator.comparing(Participant::getScore).reversed())
                .toList();

        for (Participant participant : participants ){
            participant.resetScore();
        }


        System.out.println("\nWelcome to the finals!\n");
        playOff(sortMatchup.get(0), sortMatchup.get(1));


        System.out.println("\nWelcome to the bronze place playoff!\n");
        playOff(sortMatchup.get(2), sortMatchup.get(3));



        int j=1;
        for (Participant participant: participantsSorted){
            participant.addPlayerRank(j);
            j++;
        }

// DESSA streams e bara tests...för att se

//        participants.stream()
//                .forEach(x->System.out.println("GameOnTEST om poängen e kvar:"+x.getScore()));


//        int j=1;
//        participantsSorted.stream()
//                .forEach(x->x.addPlayerRank(j));

//        participantsSorted.stream()
//                .forEach(x->System.out.println("GameOn PartSorted om poäng e kvar:"+x.getPlayerRankings()+x.getName()));

//        participants.stream()
//                .forEach(x->System.out.println("testar highestrank finns:"+x.getHighestPlayerRank()+x.getName()));

        //Ska fixas
        participantsSorted.forEach(x -> System.out.println("participant sorted:"+x.getName()));

        highscore.rankPlayers(participantsSorted);
        participantsSorted.clear();
    }



    public void playGame(Participant player1, Participant player2) {

        System.out.printf("\n%s VS %s\n", player1.getName(), player2.getName());

        GameChoice play1 = player1.getPlayable().play();
        GameChoice play2 = player2.getPlayable().play();
        System.out.println(player1.getName() + " chose: " + play1);
        System.out.println(player2.getName() + " chose: " + play2);

        if (play1 == play2) {
            System.out.println("It is a tie!");
            player1.addScore(1);
            player2.addScore(1);
        } else if ((play1.equals(GameChoice.ROCK) && play2.equals(GameChoice.SCISSORS)) ||
                (play1.equals(GameChoice.SCISSORS) && play2.equals(GameChoice.PAPER)) ||
                (play1.equals(GameChoice.PAPER) && play2.equals(GameChoice.ROCK))) {
            System.out.println(player1.getName() + " Won the game");
            player1.addScore(3);
        } else {
            System.out.println(player2.getName() + " Won the game");
            player2.addScore(3);
        }
    }

    public void playOff(Participant player1, Participant player2) {
        int tries = 0;

        System.out.printf("%s vs %s\n", player1.getName(), player2.getName());

        //Tillfällig test för tie matcher, skall checkas igen
        while (tries < 6) {
            GameChoice play1 = player1.getPlayable().play();
            GameChoice play2 = player2.getPlayable().play();
            System.out.println(player1.getName() + " chose: " + play1);
            System.out.println(player2.getName() + " chose: " + play2);

            if (play1 == play2) {
                System.out.println("It is a tie!");
                System.out.println("We need a winner there cannot be a tie!");
                tries++;
                if (tries == 5) {
                    System.out.println("A TIE AGAIN SO ROLLLL THE DICE THE WINNERRRRRR!");
                    Random random = new Random();
                    int randomNum = random.nextInt(2) + 1;
                    if (randomNum == 1) {
                        System.out.println(player1.getName() + " Won the match!");
                        participantsSorted.add(player1);
                        participantsSorted.add(player2);
                    } else {
                        System.out.println(player2.getName() + " Won the match!");
                        participantsSorted.add(player2);
                        participantsSorted.add(player1);
                    }
                }

            } else if ((play1.equals(GameChoice.ROCK) && play2.equals(GameChoice.SCISSORS)) ||
                    (play1.equals(GameChoice.SCISSORS) && play2.equals(GameChoice.PAPER)) ||
                    (play1.equals(GameChoice.PAPER) && play2.equals(GameChoice.ROCK))) {
                System.out.println(player1.getName() + " Won the match!");
                participantsSorted.add(player1);
                participantsSorted.add(player2);

                break;
            } else {
                System.out.println(player2.getName() + " Won the match!");
                participantsSorted.add(player2);
                participantsSorted.add(player1);
                break;
            }
        }
    }


}

