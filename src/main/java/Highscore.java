import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Highscore {
    Scanner scanner = new Scanner(System.in);

    Map<Integer, String> tournamentHistoryDates = new TreeMap<>();
    List<String> tournamentHistoryRanks = new ArrayList<>();

    List<Participant> participants;

    int idKey = 1;

    public Highscore(List<Participant> participants) {
        this.participants= participants;
    }
    public Highscore(){
    }


    public void addTournamentScore(List<String> tournamentRanked, LocalDateTime dateNow) {

        String tournamentRankedToString = tournamentRanked.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));

        tournamentHistoryRanks.add(tournamentRankedToString);

        tournamentHistoryDates.put(idKey,dateTimeToString(dateNow));
        idKey++;

    }

    public void rankPlayers(List<Participant> participantsSorted) {
        List<String> tournamentRanked = new ArrayList<>();
        int j = 1;
        for (Participant participant : participantsSorted) {
            tournamentRanked.add(j + ":" + participant.getName());
            j++;
        }

        //Endast för att snabbt kunna se resultatet för varje turnering*
        participantsSorted.stream()
                .forEach(x -> System.out.println("Highscore om Ranking finns:" + x.getPlayerRankings() + x.getName()));


        addTournamentScore(tournamentRanked, LocalDateTime.now());
        tournamentRanked.clear();


        //this.participants = participantsSorted;
    }

    public String dateTimeToString(LocalDateTime dateNow) {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String dateTimeString =dateNow.format(myFormat);
        return dateTimeString;
    }

    public void showTournamentHistory() {

        System.out.println("Choose from the list");

        for (Map.Entry<Integer, String> entry : tournamentHistoryDates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        int userInput = scanner.nextInt();
        System.out.println("Tournament result for: "+ tournamentHistoryDates.get(userInput));
        for (String s : tournamentHistoryRanks.get(userInput-1).split(" ")) {
            System.out.println(s);
        }

    }

    public void getPlayerStats() {

        for (Participant participant : participants) {
            System.out.println("* * * * * * * * * *");
            System.out.println(participant.getName() + " highest placement:" + participant.getHighestPlayerRank());
            System.out.println(participant.getName() + " average placement:" + participant.getAveragePlayerRank());
            System.out.println(participant.getName() + " lowest placement :" + participant.getLowestPlayerRank());

        }

    }

}




