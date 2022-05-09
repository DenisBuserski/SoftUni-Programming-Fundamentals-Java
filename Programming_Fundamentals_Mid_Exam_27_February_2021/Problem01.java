package ProgrammingFundamentalsMidExam27February2021;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        double totalApron = apronPrice * (Math.ceil(numberOfStudents * 1.2));
        double totalEgg = eggPrice * 10 * numberOfStudents;
        int freePackages = numberOfStudents / 5;
        double totalFlour = 0;
        if (freePackages == 0) {
            totalFlour = flourPrice * numberOfStudents;
        } else {
            totalFlour = flourPrice * (numberOfStudents - freePackages);
        }
        double totalPriceProducts = totalApron + totalEgg + totalFlour;

        if (totalPriceProducts <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalPriceProducts);
        } else {
            double result = totalPriceProducts - budget;
            System.out.printf("%.2f$ more needed.", result);
        }

    }
}
