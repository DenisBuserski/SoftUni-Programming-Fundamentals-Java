import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Treasure_Hunt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String treasureChestContent = scanner.nextLine();
        String[] splitChest = treasureChestContent.split("\\|");
        List<String> chestContent = Arrays.stream(splitChest).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandsArray = command.split(" ");
            String currentCommandName = commandsArray[0];

            switch (currentCommandName) {
                case "Loot":
                    for (int i = 1; i < commandsArray.length; i++) {
                        if (!chestContent.contains(commandsArray[i])) {
                            chestContent.add(0, commandsArray[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandsArray[1]);
                    if (dropIndex < 0 || dropIndex >= chestContent.size()) {
                        break;
                    }

                    String itemToDrop = chestContent.remove(dropIndex);
                    chestContent.add(itemToDrop);
                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(commandsArray[1]);

                    List<String> stolenItems = new ArrayList<>();
                    String output = "";
                    if (stealAmount >= chestContent.size()) {
                        output = String.join(", ", chestContent);
                        System.out.println(output);
                        chestContent.clear();
                        break;
                    } else {
                        for (int i = 0; i < stealAmount; i++) {
                            int lastIndex = chestContent.size() - 1;
                            stolenItems.add(0, chestContent.remove(lastIndex));
                        }
                        output = String.join(", ", stolenItems);
                        System.out.println(output);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        int totalSizeOfLoot = 0;
        for (String currentLoot : chestContent) {
            totalSizeOfLoot += currentLoot.length();
        }

        if (totalSizeOfLoot == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averagePrice = 1.0 * totalSizeOfLoot / chestContent.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averagePrice);
        }
    }
}
