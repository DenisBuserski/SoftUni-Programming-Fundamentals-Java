import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 03_Man_O_War {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> ship = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warship = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealthASection = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.split(" ")[0].equals("Retire")) {
            String[] actions = command.split(" ");

            switch (actions[0]) {
                case "Fire":
                    if (Integer.parseInt(actions[1]) > warship.size() - 1 || Integer.parseInt(actions[1]) < 0) {
                        command = scanner.nextLine();
                        continue;
                    } else {
                        int damage = Integer.parseInt(actions[2]);
                        int result = warship.get(Integer.parseInt(actions[1])) - damage;
                        warship.set(Integer.parseInt(actions[1]), result);
                        if (result <= 0) {
                            System.out.print("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int start = Integer.parseInt(actions[1]);
                    int end = Integer.parseInt(actions[2]);
                    if ((start > ship.size() - 1 || start < 0) || (end > ship.size() - 1 || end < 0)) {
                        command = scanner.nextLine();
                        continue;
                    } else {
                        if (start <= end) {
                            for (int i = start; i <= end; i++) {
                                int damage = Integer.parseInt(actions[3]);
                                int result = ship.get(i) - damage;
                                ship.set(i, result);
                                if (result <= 0) {
                                    System.out.print("You lost! The pirate ship has sunken.");
                                    return;
                                }
                            }
                        }
                    }
                    break;
                case "Repair":
                    if (Integer.parseInt(actions[1]) > ship.size() - 1 || Integer.parseInt(actions[1]) < 0) {
                        command = scanner.nextLine();
                        continue;
                    } else {
                        int health = Integer.parseInt(actions[2]);
                        int repair = health + ship.get(Integer.parseInt(actions[1]));
                        ship.set(Integer.parseInt(actions[1]), repair);
                        if (ship.get(Integer.parseInt(actions[1])) > maxHealthASection) {
                            ship.set(Integer.parseInt(actions[1]), maxHealthASection);
                        }
                    }
                    break;
                case "Status":
                    int counter = 0;
                    for (int i = 0; i <= ship.size() - 1; i++) {
                        int value = ship.get(i);
                        double percent = (1.0 * value / maxHealthASection) * 100;
                        if (percent < 20) {
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.", counter);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
        
        int sumShip = 0;
        int sumWarship = 0;

        for (int i = 0; i <= ship.size() - 1; i++) {
            sumShip += ship.get(i);
        }

        for (int j = 0; j <= warship.size() - 1; j++) {
            sumWarship += warship.get(j);
        }

        System.out.printf("Pirate ship status: %d", sumShip);
        System.out.println();
        System.out.printf("Warship status: %d", sumWarship);

    }
}
