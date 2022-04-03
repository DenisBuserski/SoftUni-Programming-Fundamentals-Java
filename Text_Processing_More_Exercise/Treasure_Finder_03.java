package TextProcessingMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> key = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        StringBuilder type = new StringBuilder();
        StringBuilder coordinates = new StringBuilder();

        while (!input.equals("find")) { // Прочитаме редовете

            int keyCount = 0;
            for (int i = 0; i <= input.length() - 1; i++) {

                if (keyCount == key.size()) {
                    keyCount = 0;
                }
                int currentNumber = key.get(keyCount);
                int newNUmber = input.charAt(i) - currentNumber;
                keyCount++;

                char newLetter = (char) newNUmber;
                String letter = Character.toString(newLetter);

                output.append(letter);

            }
            String outputWord = output.toString();
            for (int i = 0; i <= outputWord.length() - 1; i++) {
                if (outputWord.charAt(i) == '&') {
                    for (int i1 = i + 1; output.charAt(i1) != '&'; i1++) {
                        if (i1 == '&') {
                            break;
                        }
                        char typeLetter = outputWord.charAt(i1);
                        type.append(Character.toString(typeLetter));
                    }
                    break;
                }
            }
            for (int i = 0; i <= outputWord.length() - 1; i++) {
                if (outputWord.charAt(i) == '<') {
                    for (int i1 = i; output.charAt(i1) != '>'; i1++) {
                        if (i1 == '>') {
                            break;
                        }
                        char coordinatesLetter = outputWord.charAt(i1);
                        coordinates.append(Character.toString(coordinatesLetter));
                    }
                }
            }
            System.out.printf("Found %s at %s%n", type, coordinates.replace(0,1,""));

            output = new StringBuilder();
            type = new StringBuilder();
            coordinates = new StringBuilder();
            input = scanner.nextLine();
        }
    }
}
