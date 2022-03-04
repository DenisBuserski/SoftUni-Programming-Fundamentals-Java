package RegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            StringBuilder newInput = new StringBuilder();

            for (int index = 0; index <= input.length() - 1; index++) {
                char currentSymbol = input.charAt(index);
                char newLetter = (char) (currentSymbol - key);
                newInput.append(newLetter);
            }

            String regex = "\\@(?<name>[A-Za-z]+)[^\\@\\-\\!\\:\\>]+[\\!](?<behaviour>[G|N])[\\!]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(newInput);

            while (matcher.find()) {
                String name = matcher.group("name");
                String behavior = matcher.group("behaviour");

                if (behavior.equals("G")) {
                    System.out.println(name);
                }
            }
            input = scanner.nextLine();
        }
    }
}
