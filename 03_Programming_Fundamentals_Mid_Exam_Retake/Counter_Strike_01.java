import java.util.Scanner;

public class Counter_Strike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String stringDistance = scanner.nextLine();
        int winsCount = 0;

        while (!stringDistance.equals("End of battle")) {
            int distance = Integer.parseInt(stringDistance);

            if (initialEnergy >= distance) {
                initialEnergy -= distance;
                winsCount++;
                int currentWins = winsCount;
                if (winsCount % 3 == 0) {
                    initialEnergy += currentWins;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", winsCount, initialEnergy);
                break;
            }

            stringDistance = scanner.nextLine();
        }

        if (stringDistance.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d", winsCount, initialEnergy);
        }

    }
}
