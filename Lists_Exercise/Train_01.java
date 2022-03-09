package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagnos = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.equals("end")) {
                break;
            }

            String[] tokens = command.split(" ");
            String command1 = tokens[0];

            if (command1.equals("Add")) {
                wagnos.add(Integer.valueOf(tokens[1]));
            } else {
                int numberOfPassengers = Integer.parseInt(command1);

                for (int i = 0; i < wagnos.size(); i++) {

                    int sum = numberOfPassengers + wagnos.get(i);
                    if (sum <= maxCapacity) {
                        wagnos.set(i, sum);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }
        System.out.print(wagnos.toString().replaceAll("[\\[\\],]", ""));
    }
}
