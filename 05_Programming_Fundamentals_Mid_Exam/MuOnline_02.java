import java.util.Scanner;

public class MuOnline_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split("\\|");
        int baseHealth = 100;
        int baseBitcoins = 0;
        int bestRoom = 0;

        for (int i = 0; i <= inputArray.length - 1; i++) {
            String room = inputArray[i];
            String[] roomArray = room.split("\\s+");
            String commandOrMonster = roomArray[0];

            if (commandOrMonster.equals("potion")) {
                int healthAmount = Integer.parseInt(roomArray[1]);
                baseHealth += healthAmount;
                if (baseHealth <= 100) {
                    System.out.printf("You healed for %d hp.%n", healthAmount);
                    System.out.printf("Current health: %d hp.%n", baseHealth);
                } else {
                    int healthBefore = baseHealth - healthAmount;
                    int newAmount = 100 - healthBefore;
                    baseHealth = 100;
                    System.out.printf("You healed for %d hp.%n", newAmount);
                    System.out.printf("Current health: %d hp.%n", baseHealth);
                }
            } else if (commandOrMonster.equals("chest")) {
                int bitcoinsAmount = Integer.parseInt(roomArray[1]);
                int newBitcoins = baseBitcoins + bitcoinsAmount;
                baseBitcoins = newBitcoins;
                System.out.printf("You found %d bitcoins.%n", bitcoinsAmount);
            } else {
                int damage = Integer.parseInt(roomArray[1]);
                baseHealth -= damage;

                if (baseHealth > 0) {
                    System.out.printf("You slayed %s.%n", commandOrMonster);
                } else {
                    System.out.printf("You died! Killed by %s.%n", commandOrMonster);
                    bestRoom = i + 1;
                    break;
                }
            }
        }

        if (bestRoom > 0) {
            System.out.printf("Best room: %d%n", bestRoom);
        } else {
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", baseBitcoins);
            System.out.printf("Health: %d%n", baseHealth);
        }
    }
}
