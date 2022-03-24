package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int nLines = Integer.parseInt(scanner.nextLine());

        int number = 0;
        int newNumber = 0;
        String result = "";

        for (int i = 1; i <= nLines; i++) {
            char letter = scanner.nextLine().charAt(0);
            number = letter;
            newNumber = number + key;

            char newLetter = (char) newNumber;

            result += newLetter;
        }
        System.out.println(result);
    }
}
