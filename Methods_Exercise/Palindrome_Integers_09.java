package MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        while (!number.equals("END")) {
            int firstDigit = 0;
            int lastDigit = 0;
            int secondDigit = 0;
            int preLastDigit = 0;

            for (int index = 0; index < number.length(); index++) {

                if (number.length() <= 3) {
                    firstDigit = number.charAt(0);
                    lastDigit = number.charAt(number.length() - 1);
                }
                else {
                    firstDigit = number.charAt(0);
                    lastDigit = number.charAt(number.length() - 1);
                    secondDigit = number.charAt(1);
                    preLastDigit = number.charAt(number.length() - 2);
                }
            }
            if (firstDigit == lastDigit && secondDigit == preLastDigit) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
            number = scanner.nextLine();
        }
    }
}
