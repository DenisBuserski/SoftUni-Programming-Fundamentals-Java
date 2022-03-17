package ArraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        int [] array = new int[numberOfStrings];

        for (int i = 0; i < numberOfStrings; i++) {
            String input = scanner.nextLine();
            int sum = 0;

            for (int j = 0; j < input.length(); j++) {
                char letter = input.charAt(j);

                switch (letter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        sum += letter * input.length();
                        break;
                    default:
                        sum += letter / input.length();
                        break;
                }
            }
            array [i] = sum;

        }
        Arrays.sort(array);
        for (int print : array) {
            System.out.println(print);
        }
    }
}
