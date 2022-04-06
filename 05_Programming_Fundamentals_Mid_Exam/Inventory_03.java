package ProgrammingFundamentalsMidExam0501;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("Craft!")) {
            String[] commandArray = command.split(" - ");

            switch (commandArray[0]) {
                case "Collect":
                    String itemC = commandArray[1];
                    if (!journal.contains(itemC)) {
                        journal.add(itemC);
                    }
                    break;
                case "Drop":
                    String itemD = commandArray[1];
                    if (journal.contains(itemD)) {
                        journal.remove(itemD);
                    }
                    break;
                case "Renew":
                    String itemR = commandArray[1];
                    int lastIndex = journal.size() - 1;
                    if (journal.contains(itemR)) {
                        journal.remove(itemR);
                        journal.add(lastIndex, itemR);
                    }
                    break;
                case "Combine Items":
                    String items = commandArray[1];
                    String[] itemsArray = items.split(":");
                    String oldItem = itemsArray[0];
                    String newItem = itemsArray[1];
                    if (journal.contains(oldItem)) {
                        int index = journal.indexOf(oldItem) + 1;
                        journal.add(index, newItem);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.print(journal.toString().replaceAll("[\\[\\]]", ""));

    }
}
