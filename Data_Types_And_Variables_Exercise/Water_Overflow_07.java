package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int totalLiters = 0;

        for (int i = 1; i <= n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            totalLiters += liters;

            if (totalLiters > 255) {
                System.out.println("Insufficient capacity!");
                totalLiters -= liters;
            }

        }

        System.out.println(totalLiters);

    }
}
