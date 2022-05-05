package DataTypesAndVariablesLab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int number = i;
            int num = number;

            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }

            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.printf("%d -> True%n", num);
            }
            else {
                System.out.printf("%d -> False%n", num);
            }

        }

    }
}
