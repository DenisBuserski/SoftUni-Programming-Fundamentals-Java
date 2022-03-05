package ListsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> times = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int finishTime = times.size() / 2;

        double timeFirstCar = 0;
        double timeSecondCar = 0;
        for (int index = 0; index < finishTime; index++) {
            int time = times.get(index);
            if (time == 0) {
                timeFirstCar *= 0.8;
            } else {
                timeFirstCar += time;
            }
        }
        for (int index = times.size() - 1; index > finishTime; index--) {
            int time = times.get(index);
            if (time == 0) {
                timeSecondCar *= 0.8;
            } else {
                timeSecondCar += time;
            }
        }

        if (timeFirstCar < timeSecondCar) {
            System.out.printf("The winner is left with total time: %.1f", timeFirstCar);
        } else {
            System.out.printf("The winner is right with total time: %.1f", timeSecondCar);
        }


    }
}
