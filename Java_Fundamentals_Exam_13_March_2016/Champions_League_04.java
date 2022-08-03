package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_13_March_2016;

import java.util.*;

public class Champions_League_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wins = new TreeMap<>();
        Map<String, Integer> orderedWins = new LinkedHashMap<>();
        Map<String, List<String>> opponents = new TreeMap<>();

        String input;
        while (!"stop".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\|");
            String team1 = tokens[0].trim();
            String team2 = tokens[1].trim();
            String[] result1Arr = tokens[2].trim().split(":");
            int team1HomeGoals = Integer.parseInt(result1Arr[0]);
            int team2AwayGoals = Integer.parseInt(result1Arr[1]);
            String[] result2Arr = tokens[3].trim().split(":");
            int team2HomeGoals = Integer.parseInt(result2Arr[0]);
            int team1AwayGoals = Integer.parseInt(result2Arr[1]);

            int team1TotalGoals = team1HomeGoals + team1AwayGoals;
            int team2TotalGoals = team2HomeGoals + team2AwayGoals;

            wins.putIfAbsent(team1, 0);
            wins.putIfAbsent(team2, 0);
            opponents.putIfAbsent(team1, new ArrayList<>());
            opponents.putIfAbsent(team2, new ArrayList<>());

            if (team1TotalGoals > team2TotalGoals) {
                int team1CurrentWins = wins.get(team1);
                int team2CurrentWins = wins.get(team2);
                wins.put(team1, team1CurrentWins + 1);
                wins.put(team2, team2CurrentWins + 0);
                opponents.get(team1).add(team2);
                opponents.get(team2).add(team1);
            } else if (team1TotalGoals < team2TotalGoals) {
                int team1CurrentWins = wins.get(team1);
                int team2CurrentWins = wins.get(team2);
                wins.put(team2, team2CurrentWins + 1);
                wins.put(team1, team1CurrentWins + 0);
                opponents.get(team2).add(team1);
                opponents.get(team1).add(team2);
            } else if (team1TotalGoals == team2TotalGoals) {

                if (team1AwayGoals > team2AwayGoals) {
                    int team1CurrentWins = wins.get(team1);
                    int team2CurrentWins = wins.get(team2);
                    wins.put(team1, team1CurrentWins + 1);
                    wins.put(team2, team2CurrentWins + 0);
                    opponents.get(team1).add(team2);
                    opponents.get(team2).add(team1);
                } else if (team1AwayGoals < team2AwayGoals) {
                    int team1CurrentWins = wins.get(team1);
                    int team2CurrentWins = wins.get(team2);
                    wins.put(team2, team2CurrentWins + 1);
                    wins.put(team1, team1CurrentWins + 0);
                    opponents.get(team2).add(team1);
                    opponents.get(team1).add(team2);
                }

            }

        }


        wins.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> orderedWins.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : orderedWins.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("- Wins: " + entry.getValue());

            for (Map.Entry<String, List<String>> entry2 : opponents.entrySet()) {
                if (entry2.getKey().equals(entry.getKey())) {
                    Collections.sort(entry2.getValue());
                    System.out.print("- Opponents: " + entry2.getValue().toString().replaceAll("[\\[\\]]", ""));
                    System.out.println();

                }
            }
        }


    }
}
