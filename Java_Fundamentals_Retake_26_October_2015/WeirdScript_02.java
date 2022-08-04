package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Retake_26_October_2015;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WeirdScript_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int keyNumber = Integer.parseInt(scanner.nextLine());
        keyNumber = keyNumber - 1;
        int charCode = keyNumber % 26;

        char keyLetter = (keyNumber / 26) % 2 == 0
                ? (char)('a' + charCode)
                : Character.toUpperCase((char)('a' + charCode));

        String key = "" + keyLetter + keyLetter;
        StringBuilder sb = new StringBuilder();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            sb.append(line);
            line = scanner.nextLine();
        }

        String message = sb.toString();
        String pattern = key + "(.*?)" + key;
        Pattern pat = Pattern.compile(pattern);
        Matcher match = pat.matcher(message);

        while (match.find()) {
            if (match.group(1).length() > 0) {
                System.out.println(match.group(1));
            }
        }
    }
}
