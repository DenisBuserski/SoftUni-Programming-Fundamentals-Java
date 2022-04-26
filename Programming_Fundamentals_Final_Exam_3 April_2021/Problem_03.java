package ProgrammingFundamentalsFinalExam3April2021;

import java.util.*;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityPerUser = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        Map<String, List<Integer>> userData = new HashMap<>();

        while (!input.equals("Statistics")) {
            String[] inputArray = input.split("=");
            String commandName = inputArray[0];

            switch (commandName) {
                case "Add":
                    String username = inputArray[1];
                    int sentMessages = Integer.parseInt(inputArray[2]);
                    int receivedMessages = Integer.parseInt(inputArray[3]);

                    if (!userData.containsKey(username)) {
                        userData.put(username, Arrays.asList(sentMessages, receivedMessages));
                    }
                    break;
                case "Message":
                    String sender = inputArray[1];
                    String receiver = inputArray[2];

                    if (userData.containsKey(sender) && userData.containsKey(receiver)) {
                        int currentSent = userData.get(sender).get(0);
                        int currentReceived1 = userData.get(sender).get(1);
                        int newSent = currentSent + 1;
                        userData.put(sender, Arrays.asList(newSent, currentReceived1));

                        int currentSent1 = userData.get(receiver).get(0);
                        int currentReceived = userData.get(receiver).get(1);
                        int newReceived = currentReceived + 1;
                        userData.put(receiver, Arrays.asList(currentSent1, newReceived));

                        int totalMessageS = userData.get(sender).get(0) + userData.get(sender).get(1);
                        int totalMessageR = userData.get(receiver).get(1) + userData.get(receiver).get(0);

                        if (totalMessageS >= capacityPerUser) {
                            userData.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        } else if (totalMessageR >= capacityPerUser) {
                            userData.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case "Empty":
                    String usernameEmpty = inputArray[1];

                    if (userData.containsKey(usernameEmpty)) {
                        userData.remove(usernameEmpty);
                    } else if (usernameEmpty.equals("All")) {
                        userData.clear();
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        int numberOfUsers = 0;
        for (String user : userData.keySet()) {
            numberOfUsers++;
        }
        System.out.printf("Users count: %d%n", numberOfUsers);

        userData.entrySet().stream().sorted((left, right) -> {
            int result = right.getValue().get(1).compareTo(left.getValue().get(1));
            if(result == 0){
                result = left.getKey().compareTo(right.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1)));



    }
}
