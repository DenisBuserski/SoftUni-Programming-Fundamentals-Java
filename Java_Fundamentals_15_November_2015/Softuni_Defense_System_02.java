package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_15_November_2015;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Softuni_Defense_System_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalLiters = 0;

        String input;
        while (!"OK KoftiShans".equals(input = scanner.nextLine())) {
            Pattern pattern = Pattern.compile("(?<name>[A-Z]{1}[a-z]+).*?(?<alcohol>[A-Z]{1}[a-z]*[A-Z]{1}).*?(?<liters>[0-9]*[L]{1})");
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String alcohol = matcher.group("alcohol").toLowerCase();
                int liters = Integer.parseInt(matcher.group("liters").substring(0, matcher.group("liters").length() - 1));
                totalLiters += liters;

                System.out.printf("%s brought %d liters of %s!%n", name, liters, alcohol);
            }
        }


        System.out.printf("%.3f softuni liters", totalLiters / 1000);

    }
}
