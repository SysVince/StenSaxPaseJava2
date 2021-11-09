import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class Highscore {

    Map<String, List<String>> tournamentHistory = new TreeMap<>();
    List<String> tournamentRanked = new ArrayList<>();
    List<Participant> participants;
    int id = 1;

    public void addTournamentScore(List<String> tournamentRanked, LocalDateTime dateNow) {

        tournamentHistory.put(dateTimeToString(dateNow), new ArrayList<>(tournamentRanked));

    }

    public void rankPlayers(List<Participant> participantsSorted) {

        int j = 1;
        for (Participant participant : participantsSorted) {
            tournamentRanked.add(j+":"+participant.getName());
            j++;
        }

        participantsSorted.stream()
                .forEach(x -> System.out.println("Highscore om Ranking finns:" + x.getPlayerRankings() + x.getName()));

        addTournamentScore(new ArrayList<>(tournamentRanked), LocalDateTime.now());
        tournamentRanked.clear();

        this.participants = participantsSorted;
    }

    public String dateTimeToString(LocalDateTime dateNow) {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String dateTimeString = id + ": " + dateNow.format(myFormat);
        id++;
        return dateTimeString;
    }

    public void showTournamentHistory(List<Participant> participants) {
        this.participants = participants;
        // tournamentHistory.forEach((key, value) -> System.out.println(key + ":" + value));
        getHighestScorePlayer();


     //   System.out.println(tournamentHistory);

    }

    public void getHighestScorePlayer() {

        for (Participant participant : participants) {
            System.out.println("**********");
            System.out.println(participant.getName() + " högsta placering:" + participant.getHighestPlayerRank());
            System.out.println(participant.getName() + " lägsta placering:" + participant.getLowestPlayerRank());
            System.out.println(participant.getName() + " snitt placering:" + participant.getAveragePlayerRank());
        }


    }

    public void getLowestScorePlayer() {
        participants
                .stream()
                .forEach(x -> System.out.println(x.getName() + " lägsta placering:" + x.getLowestPlayerRank()));

    }

    public void getAverageScorePlayer() {

    }

}




