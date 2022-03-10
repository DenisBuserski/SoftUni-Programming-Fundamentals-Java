package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbeOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 1; i <= numbeOfCommands; i++) {
            String command = scanner.nextLine();
            String [] token = command.split(" ");
            String name = token[0];
            String command1 = token[2];

            if (names.contains(name) && command1.equals("going!")) {
                System.out.printf("%s is already in the list!%n", name);
            }
            else if (command1.equals("going!")) {
                names.add(name);
            }
            else if (command1.equals("not")){
                if (names.contains(name)) {
                    names.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }


        }
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s%n", names.get(i));
        }

    }
}
