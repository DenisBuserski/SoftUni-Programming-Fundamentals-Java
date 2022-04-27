import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        List<String> matches = new ArrayList<>();

        for (int i = 1; i <= numberOfInputs; i++) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(": ");
            String firstPart = inputArray[0];
            String secondPart = inputArray[1];
            String[] firstPartArray = firstPart.split(" ");
            String[] secondPartArray = secondPart.split(" ");
            List<Integer> printNumbers = new ArrayList<>();

            String validRegex = "(?<valid>[\\*\\@])(?<word>[A-Z]{1}[a-z]{2,})\\1";
            Pattern validPattern = Pattern.compile(validRegex);
            Matcher validMatcher = validPattern.matcher(input);

            if (validMatcher.find()) {
                String validInput = validMatcher.group();
                if (secondPartArray.length < 2) {
                    if (validInput.equals(firstPartArray[firstPartArray.length - 1])) {
                        if (!matches.contains(validInput)) {
                            matches.add(validInput);

                            String secondPartValidation = "\\|*[\\[]{1}(?<letter>[A-z])[\\]]\\|*";
                            Pattern secondPartValidationPattern = Pattern.compile(secondPartValidation);
                            Matcher secondPartValidationMatcher = secondPartValidationPattern.matcher(secondPart);

                            while (secondPartValidationMatcher.find()) {
                                String number = secondPartValidationMatcher.group("letter");
                                int asciiNumber = number.charAt(0);
                                printNumbers.add(asciiNumber);
                            }

                            System.out.printf("%s: %s%n", validMatcher.group("word"), printNumbers.toString().replaceAll("[\\[\\],]", ""));
                        } else {
                            matches.add(validInput);
                            System.out.printf("Valid message not found!%n");
                        }
                    } else {
                        matches.add(validInput);
                        System.out.printf("Valid message not found!%n");
                    }
                } else {
                    matches.add(validInput);
                    System.out.printf("Valid message not found!%n");
                }
            } else {
                System.out.printf("Valid message not found!%n");
            }
        }
        
    }
}
