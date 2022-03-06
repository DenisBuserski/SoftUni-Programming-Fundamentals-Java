package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> startingDrumSet = new ArrayList<>();
        for (int index = 0; index < drumSet.size(); index++) {
            startingDrumSet.add(drumSet.get(index));
        }

        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);

            for (int index = 0; index < drumSet.size(); index++) {
                int newDrum = drumSet.get(index) - hitPower;
                int newDrumCost = startingDrumSet.get(index) * 3;

                if (newDrum <= 0) {
                    if (money > newDrumCost) {
                        money -= newDrumCost;
                        drumSet.set(index, startingDrumSet.get(index));
                    } else {
                        if (index == drumSet.size() - 1) {
                            drumSet.remove(index);
                        } else {
                            drumSet.remove(index);
                            startingDrumSet.remove(index);
                            index--;
                        }

                    }
                } else {
                    drumSet.set(index, newDrum);

                }


            }


            input = scanner.nextLine();
        }
        System.out.print(drumSet.toString().replaceAll("[\\[\\],]", ""));
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", money);
    }
}
