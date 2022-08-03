package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_13_March_2016;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basic_Markup_Language_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstPattern = "\\<\\s*([\\w]+)\\s+content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\>";
        String secondPattern = "\\<\\s*([\\w]+)\\s+value\\s*\\=\\s*\"([0-9]+)\"\\s*content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\s*\\>";
        Pattern inverseReversePattern = Pattern.compile(firstPattern);
        Pattern repeatPattern = Pattern.compile(secondPattern);
        String inputLine = scanner.nextLine().trim();

        ArrayList<String> output = new ArrayList<String>();

        int lineCount = 1;

        while (!inputLine.equals("<stop/>")) {
            Matcher inverseReverseMatcher = inverseReversePattern.matcher(inputLine);
            Matcher repeatMatcher = repeatPattern.matcher(inputLine);

            if (inverseReverseMatcher.find()) {
                String command = inverseReverseMatcher.group(1).trim();
                String content = inverseReverseMatcher.group(2);
                String result = "";

                if (command.equals("inverse")) {
                    for (int i = 0; i < content.length(); i++) {
                        int charValue = (int) content.charAt(i);
                        if (charValue >= 65 && charValue <= 90) {
                            charValue += 32;
                        } else if (charValue >= 97 && charValue <= 122) {
                            charValue -= 32;
                        }

                        result += (char) charValue;
                    }
                } else if (command.equals("reverse")) {
                    for (int i = content.length() - 1; i >= 0; i--) {
                        result += content.charAt(i);
                    }
                }

                output.add(String.format("%s. %s", lineCount, result));
                lineCount++;
            } else if (repeatMatcher.find()) {
                String command = repeatMatcher.group(1).trim();
                String value = repeatMatcher.group(2).trim();
                String content = repeatMatcher.group(3);
                String result = "";

                Integer parsedValue = Integer.parseInt(value);

                if (parsedValue != 0) {
                    ArrayList<String> repeatedOutput = new ArrayList<String>();
                    for (int i = 0; i < parsedValue; i++) {
                        repeatedOutput.add(String.format("%s. %s", lineCount, content));
                        lineCount++;
                    }

                    result = String.join("\n", repeatedOutput);
                    output.add(result);
                }
            }

            inputLine = scanner.nextLine().trim();
        }

        System.out.println(String.join("\n", output));
    }

}
