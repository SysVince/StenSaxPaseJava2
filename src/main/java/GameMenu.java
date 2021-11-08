import java.util.Scanner;

public class GameMenu {

    public void menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        GameOn gameOn = new GameOn();
        Highscore highscore = new Highscore();
        boolean run = true;

        System.out.println("Stone Paper Scissors Game 3000");
        while (run) {
            System.out.println("""
                    
                    1: To play the game
                    2: To view tournament scores and player stats
                    3: To Exit the game
                     """);
            switch (scanner.nextInt()) {
                case 1 -> gameOn.gameSetup();
                case 2 -> {
                    System.out.println("Showing highscore and stats");
                    //highscore.showTournamentHistory();
                }
                case 3 -> {
                    System.out.println("Exiting game");
                    run = false;
                }

            }

        }


    }
}
