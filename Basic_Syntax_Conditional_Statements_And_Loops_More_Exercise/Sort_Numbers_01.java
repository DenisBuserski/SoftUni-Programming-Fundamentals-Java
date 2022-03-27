package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int first = 0;
        int second = 0;
        int third = 0;

        if (num1 > num2 && num1 > num3) {
            first = num1;
            if (num2 > num3) {
                second = num2;
                third = num3;
            } else {
                second = num3;
                third = num2;
            }
        }
        if (num2 > num1 && num2 > num3) {
            first = num2;
            if (num1 > num3) {
                second = num1;
                third = num3;
            } else {
                second = num3;
                third = num1;
            }
        }
        if (num3 > num1 && num3 > num2) {
            first = num3;
            if (num1 > num2) {
                second = num1;
                third = num2;
            } else {
                second = num2;
                third = num1;
            }
        }
        System.out.printf("%d%n%d%n%d", first, second, third);


    }
}
