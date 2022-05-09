package MethodsExercise;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        printResult(number1, number2, number3);
    }

    private static void printResult(int number1, int number2, int number3) {
        int result = 0;
        if (number1 < number2 && number1 < number3) {
            result = number1;
        } else if (number2 < number1 && number2 < number3) {
            result = number2;
        } else {
            result = number3;
        }
        System.out.println(result);
    }
}