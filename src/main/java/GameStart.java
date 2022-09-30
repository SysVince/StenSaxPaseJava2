import playersettings.*;


import java.util.*;


public class GameStart {


    private List<Participant> participants;

    private List<Participant> participantsSorted = new ArrayList<>();
    private Highscore highscore;


    public GameStart(List<Participant> participants) {
        this.participants = participants;
        this.highscore = new Highscore(participants);
    }

    public void gameSetup() throws InterruptedException {

        System.out.println("Welcome to Stone-Paper-Scissors Diamond Tournament!");
        System.out.println("****LET THE GAMES BEGIN!!****");
        Collections.shuffle(participants);
        //Alla möter alla för att samla poäng
        playMatch(participants.get(2), participants.get(0));
        Thread.sleep(500);
        playMatch(participants.get(2), participants.get(1));
        Thread.sleep(500);
        playMatch(participants.get(2), participants.get(3));
        Thread.sleep(500);
        playMatch(participants.get(3), participants.get(0));
        Thread.sleep(500);
        playMatch(participants.get(3), participants.get(1));
        Thread.sleep(500);
        playMatch(participants.get(0), participants.get(1));


        //Sorterar för att matcha de med högst som skall mötas i finalen samt om tredje plats.
        List<Participant> sortMatchup = participants
                .stream()
                .sorted(Comparator.comparing(Participant::getScore).reversed())
                .toList();

        //Resetar score för alla deltagare inför ny turnerning.
        for (Participant participant : participants) {
            participant.resetScore();
        }


        System.out.println("\nWelcome to the finals!\n");
        playOff(sortMatchup.get(0), sortMatchup.get(1));

        System.out.println("\nWelcome to the bronze place playoff!\n");
        playOff(sortMatchup.get(2), sortMatchup.get(3));


        //Sparar varje spelares rank i varje turnering för framtida statistik.
        System.out.println("\nTournament Results!");
        int rank = 1;
        for (Participant participant : participantsSorted) {
            participant.addPlayerRank(rank);
            System.out.println(rank + ": " + participant.getName());
            rank++;
        }

        //Denna lista (participantsSorted) används för att ge player poäng.
        highscore.rankPlayers(participantsSorted);
        participantsSorted.clear();

    }


    public void playMatch(Participant player1, Participant player2) {

        System.out.printf("\n%s VS %s\n", player1.getName(), player2.getName());

        GameChoice player1Choice = player1.getPlayable().play();
        GameChoice player2Choice = player2.getPlayable().play();
        System.out.println(player1.getName() + " chose: " + player1Choice);
        System.out.println(player2.getName() + " chose: " + player2Choice);

        if (player1Choice == player2Choice) {
            System.out.println("It is a tie!");
            player1.addScore(1);
            player2.addScore(1);
        } else if ((player1Choice.equals(GameChoice.ROCK) && player2Choice.equals(GameChoice.SCISSORS)) ||
                (player1Choice.equals(GameChoice.SCISSORS) && player2Choice.equals(GameChoice.PAPER)) ||
                (player1Choice.equals(GameChoice.PAPER) && player2Choice.equals(GameChoice.ROCK))) {
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

        //Tillfällig test för tie matcher bottar mot varandra, skall checkas igen
        while (tries < 6) {
            GameChoice play1Choice = player1.getPlayable().play();
            GameChoice play2Choice = player2.getPlayable().play();
            System.out.println(player1.getName() + " chose: " + play1Choice);
            System.out.println(player2.getName() + " chose: " + play2Choice);

            if (play1Choice == play2Choice) {
                System.out.println("It is a tie!");
                System.out.println("We need a winner there cannot be a tie!");
                tries++;
                if (tries == 5) {
                    System.out.println("A TIE AGAIN SO ROLL THE DICE FOR THE WINNER!");
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

            } else if ((play1Choice.equals(GameChoice.ROCK) && play2Choice.equals(GameChoice.SCISSORS)) ||
                    (play1Choice.equals(GameChoice.SCISSORS) && play2Choice.equals(GameChoice.PAPER)) ||
                    (play1Choice.equals(GameChoice.PAPER) && play2Choice.equals(GameChoice.ROCK))) {
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

    //Highscore class
    public Highscore getHighscore() {
        return highscore;
    }


}
















