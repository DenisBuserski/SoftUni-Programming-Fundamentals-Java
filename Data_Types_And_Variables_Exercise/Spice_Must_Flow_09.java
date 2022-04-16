package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int crewConsumption = 26;
        int daysCount = 0;
        int totalAmount = 0;

        if (startingYield >= 100) {
            while (startingYield >= 100) {
                totalAmount += startingYield - crewConsumption;
                startingYield -= 10;
                daysCount++;
            }
            totalAmount -= 26;
        }
        System.out.println(daysCount);
        System.out.println(totalAmount);

    }
}
