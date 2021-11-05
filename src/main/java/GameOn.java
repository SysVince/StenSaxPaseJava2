import aipersonality.GameChoice;
import aipersonality.Playable;

import java.util.Random;
import java.util.Scanner;

public class GameOn {

    public void playGame(AIPlayer player1, AIPlayer player2) {
        System.out.println("****LET THE GAMES BEGIN!!****");

        System.out.printf("%s vs %s\n",player1.getName(),player2.getName());



            GameChoice play1 = player1.getPlayable().play();
            GameChoice play2 = player2.getPlayable().play();
            System.out.println(player1.getName() +" chose: "+ play1);
            System.out.println(player2.getName() +" chose: "+ play2);


            if (play1 == play2) {
                System.out.println("It is a tie!");
            } else if ((play1.equals(GameChoice.ROCK) && play2.equals(GameChoice.SCISSORS)) ||
                    (play1.equals(GameChoice.SCISSORS) && play2.equals(GameChoice.PAPER)) ||
                    (play1.equals(GameChoice.PAPER) && play2.equals(GameChoice.ROCK))) {
                System.out.println(player1.getName() + " won the game");
            } else System.out.println(player2.getName() + " won the game");
        }


}

