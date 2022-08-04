package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Retake_26_October_2015;

import java.util.Scanner;

public class TinySporebat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 5800;
        int collectedGlowcaps = 0;

        String input;
        while (!"Sporeggar".equals(input = scanner.nextLine()) && health > 0) {

            for (int index = 0; index < input.length(); index++) {
                if (input.charAt(index) == 'L') {
                    health += 200;
                } else if (index == input.length() - 1 && Character.isDigit(input.charAt(index))) {
                    collectedGlowcaps += Character.getNumericValue(input.charAt(index));
                } else {
                    health -= input.charAt(index);
                    if (health <= 0) {
                        break;
                    }
                }
            }

        }

        if (health <= 0) {
            System.out.println("Died. Glowcaps: " + collectedGlowcaps);
        } else {
            System.out.println("Health left: " + health);

            if (collectedGlowcaps >= 30) {
                int res = collectedGlowcaps - 30;
                System.out.println("Bought the sporebat. Glowcaps left: " + res);
            } else {
                System.out.println("Safe in Sporeggar, but another " + (30 - collectedGlowcaps) + " Glowcaps needed.");
            }

        }


    }
}
