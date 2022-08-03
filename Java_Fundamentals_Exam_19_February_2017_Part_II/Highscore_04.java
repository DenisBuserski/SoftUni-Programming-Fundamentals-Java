package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_19_February_2017_Part_II;

import java.util.*;

public class Highscore_04 {
    private final static String RESULT_PRINT = "*   %s <-> %d";
    private final static String GET_PLAYER_STATS = "%s - (%d)";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> data = new LinkedHashMap<>();
        Map<String, List<String>> duelsMap = new LinkedHashMap<>();

        String line;
        while (!"osu!".equals(line = scanner.nextLine())){
            String[] players = line.split("<->");
            String player1 = players[0].split(" ")[1];
            Integer player1Score = Integer.parseInt(players[0].split("\\s+")[0]);
            String player2 = players[1].split(" ")[0];
            Integer player2Score = Integer.parseInt(players[1].split("\\s+")[1]);

            data.putIfAbsent(player1, 0L);
            duelsMap.putIfAbsent(player1, new LinkedList<>());
            data.putIfAbsent(player2, 0L);
            duelsMap.putIfAbsent(player2, new LinkedList<>());

            if (player1Score > player2Score){
                data.replace(player1, data.get(player1) + (player1Score - player2Score));
                String player1String = String.format(RESULT_PRINT, player2, player1Score - player2Score);
                duelsMap.get(player1).add(player1String);
                data.replace(player2, data.get(player2) + (player2Score - player1Score));
                String player2String = String.format(RESULT_PRINT, player1, player2Score - player1Score);
                duelsMap.get(player2).add(player2String);
            }
            if (player2Score > player1Score){
                data.replace(player2, data.get(player2) + (player2Score - player1Score));
                String player2String = String.format(RESULT_PRINT, player1, player2Score - player1Score);
                duelsMap.get(player2).add(player2String);
                data.replace(player1, data.get(player1) + (player1Score - player2Score));
                String player1String = String.format(RESULT_PRINT, player2, player1Score - player2Score);
                duelsMap.get(player1).add(player1String);
            }
        }

        data.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(x -> {
            System.out.println(String.format(GET_PLAYER_STATS, x.getKey(), x.getValue()));
            for (String duelsData : duelsMap.get(x.getKey())) {
                System.out.println(duelsData);
            }
        });
    }
}