import java.util.Random;
import java.util.Scanner;

public class GameOn {

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;
        while (isPlaying) {

            System.out.println("1: to play -- 2: To exit game");
            int player = scanner.nextInt();

            switch (player) {
                case 1 -> {
                    System.out.println("1: for stone, 2: for paper, 3: scissors");
                    int playerNumber = scanner.nextInt();

                    Random rand = new Random();

                    int compNumber = rand.nextInt(3)+1;
                    switch (compNumber){
                        case 1 -> System.out.println("Computer chose stone");
                        case 2 -> System.out.println("Computer chose paper");
                        case 3 -> System.out.println("Computer chose scissors");
                    }
                    System.out.println("datorns nummer:" + compNumber);

                    if (playerNumber == compNumber) {
                        System.out.println("It is a tie!");
                    } else if ((playerNumber == 1 && compNumber == 2) || (playerNumber == 2 && compNumber == 3) || (playerNumber == 3 && compNumber == 1)) {
                        System.out.println("You won! Yay!");
                    } else System.out.println("You lost! Oh no!");
                }
                case 2 -> isPlaying = false;
            }
        }
    }
}
