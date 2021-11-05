package aipersonality;

import java.util.Scanner;

public class Player implements Playable{
    @Override
    public GameChoice play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: for rock, 2: for paper, 3: for scissors");
        int playerChoice = scanner.nextInt();
        switch (playerChoice){
            case 1-> {return GameChoice.ROCK;}
            case 2-> {return GameChoice.PAPER;}
            default -> {return GameChoice.SCISSORS;} //case 3
        }
    }
}
