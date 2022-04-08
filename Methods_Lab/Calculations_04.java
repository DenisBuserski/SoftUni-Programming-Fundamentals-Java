package MethodsLab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                addResult(command, number1, number2);
                break;
            case "multiply":
                multiplyResult(command, number1, number2);
                break;
            case "subtract":
                subtractResult(command, number1, number2);
                break;
            case "divide":
                divideResult(command, number1, number2);
                break;
        }


    }

    private static void addResult(String command, int number1, int number2) {
        int result = number1 + number2;
        System.out.println(result);
    }

    private static void multiplyResult(String command, int number1, int number2) {
        int result = number1 * number2;
        System.out.println(result);
    }

    private static void subtractResult(String command, int number1, int number2) {
        int result = number1 - number2;
        System.out.println(result);
    }

    private static void divideResult(String command, int number1, int number2) {
        int result = number1 / number2;
        System.out.println(result);
    }
}
