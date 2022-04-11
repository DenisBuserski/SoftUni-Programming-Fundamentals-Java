import java.util.*;

public class Ranking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> contestsPasswordsMap = new TreeMap<>();
        TreeMap<String, HashMap<String, Integer>> contestantMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String[] contests = input.split(":");
            contestsPasswordsMap.putIfAbsent(contests[0], contests[1]);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            String[] submission = input.split("=>");
            
            String contestName = submission[0],
                    contestPass = submission[1],
                    userName = submission[2];
            int userPoints = Integer.parseInt(submission[3]);

            if (contestsPasswordsMap.containsKey(contestName) && contestsPasswordsMap.containsValue(contestPass)) {
                contestantMap.putIfAbsent(userName, new HashMap<>());

                HashMap<String, Integer> userNameMap = contestantMap.get(userName);
                userNameMap.putIfAbsent(contestName, userPoints);

                if (userNameMap.get(contestName) < userPoints) {
                    userNameMap.put(contestName, userPoints);
                }

            }
            input = scanner.nextLine();
        }

        printBestUser(contestantMap);
        printAllUsers(contestantMap);

    }

    public static void printBestUser(TreeMap<String, HashMap<String, Integer>> contestantMap) {
        String bestUser = "";
        int userScore = 0, bestUserScore = 0;

        for (Map.Entry<String, HashMap<String, Integer>> X : contestantMap.entrySet()) {
            HashMap<String, Integer> temp = X.getValue();
            userScore += temp.values().stream().mapToInt(integer -> integer).sum();
            if (userScore >= bestUserScore) {
                bestUserScore = userScore;
                bestUser = X.getKey();
            }
            userScore = 0;
        }
        System.out.printf("Best candidate is %s with total %d points.%nRanking: %n", bestUser, bestUserScore);
    }

    public static void printAllUsers(TreeMap<String, HashMap<String, Integer>> contestantMap) {
        contestantMap.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s%n" , e.getKey());
                    e.getValue().entrySet()
                            .stream()
                            .sorted(Comparator.comparingInt(k -> -k.getValue()))
                            .forEach(k -> System.out.printf("#  %s -> %d%n", k.getKey(), k.getValue()));
                });
    }
    
}
