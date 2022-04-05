package TextProcessingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        int inputSize = input.size();

        for (int i = 0; i <= inputSize; i++) {
            String letter = input.get(i);

            if (i + 1 > input.size() - 1) {
                break;
            }

            if (letter.equals(input.get(i + 1))) {
                input.remove(i + 1);
                i--;
            }
        }
        System.out.print(input.toString().replaceAll("[\\[\\], ]", ""));
    }
}
