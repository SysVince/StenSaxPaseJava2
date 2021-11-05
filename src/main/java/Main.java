import aipersonality.*;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        GameOn gameOn = new GameOn();
        AIPlayer timerNoob = new AIPlayer("TimerNoob", new DateTimerBot());
        AIPlayer timerPro = new AIPlayer("TimerPro", new DateTimerBotV2());
        AIPlayer theRandomizer = new AIPlayer("TheRandomizer", new RandomizerBot());





        System.out.println("Welcome to Stone-Paper-Scissors Diamond Tournament!");
        System.out.println("What's your player name?");
        String playerName = scanner.next();
        AIPlayer player = new AIPlayer(playerName,new Player());


        AIPlayer theVocalist = new AIPlayer("TheVocalist", new VocalistBot(playerName));


        gameOn.playGame(theRandomizer,player);
        Thread.sleep(1000);
        gameOn.playGame(timerPro,player);
        Thread.sleep(1000);
        gameOn.playGame(theVocalist,player);
        Thread.sleep(1000);
        gameOn.playGame(theVocalist,theRandomizer);
        Thread.sleep(1000);
        gameOn.playGame(timerPro,theRandomizer);
        Thread.sleep(1000);
        gameOn.playGame(theVocalist,timerPro);


    }


}



















