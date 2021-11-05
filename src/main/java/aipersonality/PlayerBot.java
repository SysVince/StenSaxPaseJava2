package aipersonality;

import java.util.Scanner;

public class PlayerBot implements Playable{
    @Override
    public GameChoice play() {
        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();
        switch (playerChoice){
            case 1-> {return GameChoice.ROCK;}
            case 2-> {return GameChoice.PAPER;}
            default -> {return GameChoice.SCISSORS;} //case 3
        }
    }
}
