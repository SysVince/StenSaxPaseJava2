import playersettings.Participant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Highscore {
    private List<Participant> participants;
    private List<String> tournamentHistoryDates = new ArrayList<>();
    private List<String> tournamentHistoryRanks = new ArrayList<>();
    private int idTime = 1;

    public Highscore(List<Participant> participants) {
        this.participants = participants;
    }


    public void addTournamentScore(List<String> tournamentRanked, LocalDateTime dateNow) {

        String tournamentRankedToString = tournamentRanked.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));

        tournamentHistoryRanks.add(tournamentRankedToString);

        tournamentHistoryDates.add(idTime + ": " + dateTimeToString(dateNow));
        idTime++;

    }

    public void rankPlayers(List<Participant> participantsSorted) {
        List<String> tournamentRanked = new ArrayList<>();
        int idRank = 1;
        for (Participant participant : participantsSorted) {
            tournamentRanked.add(idRank + ":" + participant.getName());
            idRank++;
        }

        //Endast för att snabbt kunna se resultatet för varje turnering* (debugging)
        participantsSorted.stream()
                .forEach(x -> System.out.println("Debugging to check all tournament scores:" + x.getPlayerRankings() + x.getName()));


        addTournamentScore(tournamentRanked, LocalDateTime.now());
        tournamentRanked.clear();


    }

    public String dateTimeToString(LocalDateTime dateNow) {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String dateTimeString = dateNow.format(myFormat);
        return dateTimeString;
    }

    public void showTournamentHistory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the list");

        tournamentHistoryDates.forEach(System.out::println);


        int userInput = scanner.nextInt() - 1;
        System.out.println("Tournament result for: " + tournamentHistoryDates.get(userInput));
        for (String s : tournamentHistoryRanks.get(userInput).split(" ")) {
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




