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
                    int compNumber = rand.nextInt(3) + 1;
                    System.out.println("datorns nummer:" + compNumber);

                    System.out.println(compNumber);

                    if (playerNumber == compNumber) {
                        System.out.println("Det blev lika");
                    } else if (playerNumber == 1 && compNumber == 2) {
                        System.out.println("Du vann! Du valde sten och datorn valde sax");
                    } else if (playerNumber == 1) {
                        System.out.println("Du förlorade! Du valde sten och datorn valde påse");
                    } else if (playerNumber == 2 && compNumber == 1) {
                        System.out.println("Du förlorade! Du valde sax och datorn valde sten");
                    } else if (playerNumber == 2) {
                        System.out.println("Du vann! du valde sax och datorn valde påse");
                    } else if (playerNumber == 3 && compNumber == 1) {
                        System.out.println("Du vann! DU valde påse och datorn valde sten");
                    } else if (playerNumber == 3) {
                        System.out.println("Du förlorade! Du valde påse och datorn valde sax");
                    } else
                        System.out.println("Det blev något fel!");
                }
                case 2 -> avsluta = false;
            }

        }

    }
}

