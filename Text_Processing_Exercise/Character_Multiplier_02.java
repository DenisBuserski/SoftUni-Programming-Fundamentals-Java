import java.util.Scanner;

public class Character_Multiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        String word1 = inputArray[0];
        String word2 = inputArray[1];

        if (word1.length() == word2.length()) {
            equalLengthWords(word1, word2);
        } else if (word1.length() > word2.length()) {
            word1Bigger(word1, word2);
        } else {
            word2Bigger(word1, word2);
        }
    }

    private static void word2Bigger(String word1, String word2) {
        int sumTotal = 0;
        for (int i = 0; i <= word1.length() - 1; i++) {
            int number1 = word1.charAt(i);
            int number2 = word2.charAt(i);
            sumTotal += number1 * number2;
        }
        for (int i = word1.length(); i <= word2.length() - 1; i++) {
            int number2Left = word2.charAt(i);
            sumTotal += number2Left;
        }
        System.out.println(sumTotal);
    }

    private static void word1Bigger(String word1, String word2) {
        int sumTotal = 0;
        for (int i = 0; i <= word2.length() - 1; i++) {
            int number1 = word1.charAt(i);
            int number2 = word2.charAt(i);
            sumTotal += number1 * number2;
        }
        for (int i = word2.length(); i <= word1.length() - 1; i++) {
            int number1Left = word1.charAt(i);
            sumTotal += number1Left;
        }
        System.out.println(sumTotal);
    }

    private static void equalLengthWords(String word1, String word2) {
        int sumTotal = 0;
        for (int i = 0; i <= word1.length() - 1; i++) {
            int number1 = word1.charAt(i);
            int number2 = word2.charAt(i);
            sumTotal += number1 * number2;
        }
        System.out.println(sumTotal);
    }
    
}
