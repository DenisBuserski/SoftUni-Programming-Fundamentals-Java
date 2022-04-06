package ProgrammingFundamentalsMidExamRetake01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            if ((lift[i] < 4)) {
                if (people >= 4 - lift[i]) {
                    people -= 4 - lift[i];
                    lift[i] = 4;
                } else {
                    lift[i] += people;
                    people = 0;
                }
            }
        }
        boolean full = IntStream.range(0, lift.length).noneMatch(i -> lift[i] != 4);
        if (people == 0 && !full) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0 && full) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
        System.out.print(Arrays.toString(lift).replaceAll("[\\[\\]]", "").replaceAll(", ", " "));


    }
}
