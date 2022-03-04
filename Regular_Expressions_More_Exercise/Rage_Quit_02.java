package RegularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<word>[\\D]*)(?<times>\\d+)";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(input);

        StringBuilder sb = new StringBuilder();
        while (mat.find()) {
            String word = mat.group("word").toUpperCase();
            int n = Integer.parseInt(mat.group("times"));

            for (int i = 0; i < n; i++) {
                sb.append(word);
            }

        }


        System.out.printf("Unique symbols used: %d%n", sb.chars().distinct().count());
        System.out.println(sb);

    }
}
