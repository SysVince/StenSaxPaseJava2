import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Highscore {
    Scanner scanner = new Scanner(System.in);

    Map<String, List<String>> tournamentHistory = new TreeMap<>();
    Map<Integer, String> tournamentHistory2 = new TreeMap<>();
    List<String> tournamentSaves = new ArrayList<>();

    List<Participant> participants;
    int id = 1;
    int id2 = 1;

    public Highscore(List<Participant> participants) {
        this.participants= participants;
    }
    public Highscore(){
    }


    public void addTournamentScore(List<String> tournamentRanked, LocalDateTime dateNow) {

        String tournamentRankedToString = tournamentRanked.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));

        tournamentSaves.add(tournamentRankedToString);


       // tournamentHistory.put(dateTimeToString(dateNow), new ArrayList<>(tournamentRanked));
        tournamentHistory2.put(id2,dateTimeToString(dateNow));
        id2++;
       // tournamentHistory.clear();

    }

    public void rankPlayers(List<Participant> participantsSorted) {
        List<String> tournamentRanked = new ArrayList<>();
        int j = 1;
        for (Participant participant : participantsSorted) {
            tournamentRanked.add(j + ":" + participant.getName());
            j++;
        }

        participantsSorted.stream()
                .forEach(x -> System.out.println("Highscore om Ranking finns:" + x.getPlayerRankings() + x.getName()));



        addTournamentScore(tournamentRanked, LocalDateTime.now());
        tournamentRanked.clear();


        this.participants = participantsSorted;
    }

    public String dateTimeToString(LocalDateTime dateNow) {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        //String dateTimeString = id + ": " + dateNow.format(myFormat);
        String dateTimeString =dateNow.format(myFormat);
        id++;
        return dateTimeString;
    }

    public void showTournamentHistory() {
        // tournamentHistory.forEach((key, value) -> System.out.println(key + ":" + value));
        //getPlayerStats();
       // System.out.println(tournamentHistory);

//        for (Entry<String, String> entry : tree.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//
//            System.out.printf("%s : %s\n", key, value);
//        }

//        for (Map.Entry<Integer, Map<String, List<String>>> entry : tournamentHistory2.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
//        }

//        for (Map.Entry<K, V> entry : myMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
//        }
        System.out.println("Välj från listan");

        for (Map.Entry<Integer, String> entry : tournamentHistory2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        int userInput = scanner.nextInt();
        System.out.println("Tournament resultatet för: "+tournamentHistory2.get(userInput));
        for (String s : tournamentSaves.get(userInput-1).split(" ")) {
            System.out.println(s);
        }






    }

    public void getPlayerStats() {

        for (Participant participant : participants) {
            System.out.println("**********");
            System.out.println(participant.getName() + " högsta placering:" + participant.getHighestPlayerRank());
            System.out.println(participant.getName() + " snitt placering :" + participant.getAveragePlayerRank());
            System.out.println(participant.getName() + " lägsta placering:" + participant.getLowestPlayerRank());

        }

    }


}




