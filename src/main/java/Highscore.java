import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Highscore {

    Map<Integer, List<String>> tournamentHistory = new HashMap<>();
    int id = 1;

    public void addTournamentScore(List<String> tournamentRanked) {


        tournamentHistory.put(id, tournamentRanked);
        id++;
        System.out.println(tournamentHistory);


    }

//    public void showTournamentHistory() {
//        tournamentHistory.forEach((key, value) -> System.out.println(key + ":" + value));
//    }
}


