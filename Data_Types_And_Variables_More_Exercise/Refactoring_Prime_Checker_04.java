package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;
            for (int cepitel = 2; cepitel < i; cepitel++) {
                if (i % cepitel == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %s%n", i, isPrime);
        }

    }
}
