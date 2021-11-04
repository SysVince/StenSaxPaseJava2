import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean avsluta = true;
        System.out.println("Välkommen till StenSaxPåse Diamond Tournament");

        while (avsluta) {

            System.out.println("1: för att spela -- 2: för att avsluta");

            switch (scanner.nextInt()) {
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
                case 2 -> avsluta = false;
            }
        }

    }
}



















