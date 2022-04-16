package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfKegs = Integer.parseInt(scanner.nextLine());
        String bestKeg = "";
        double max = Double.MIN_VALUE;

        for (int i = 1; i <= numberOfKegs; i++) {
            String kegName = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double result = Math.PI * (radius * radius) * height;

            if (result > max) {
                max = result;
                bestKeg = kegName;
            }
        }
        System.out.println(bestKeg);
    }
}
