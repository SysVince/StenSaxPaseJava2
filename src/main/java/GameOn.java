import java.util.Random;
import java.util.Scanner;

public class GameOn {

    public void playGame(){
        Scanner scanner = new Scanner(System.in);
        boolean fortsatta = true;
        while (fortsatta) {

            System.out.println("1: för att spela -- 2: för att avsluta");
            int player = scanner.nextInt();

            switch (player) {
                case 1 -> {
                    System.out.println("1: för sten, 2: för sax, 3: för påse");
                    int playerNumber = scanner.nextInt();

                    Random rand = new Random();

                    int compNumber = rand.nextInt(3)+1;
                    System.out.println("datorns nummer:" + compNumber);

                    System.out.println(compNumber);

                    if (playerNumber == compNumber) {
                        System.out.println("Det blev lika");
                    } else if ((playerNumber == 1 && compNumber == 2) || (playerNumber == 2 && compNumber == 3) || (playerNumber == 3 && compNumber == 1)) {
                        System.out.println("Du vann!");
                    } else System.out.println("Du förlorade!");

                }
                case 2 -> fortsatta = false;
            }
        }
    }
}
