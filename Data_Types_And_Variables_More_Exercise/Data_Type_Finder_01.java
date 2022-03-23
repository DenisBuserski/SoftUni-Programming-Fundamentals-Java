package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String type = "";

            // boolean
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                type = "boolean";
            }
            // char; int
            else if (input.length() == 1) {
                char symbol = input.charAt(0);
                if (symbol < 47 || symbol > 58) {
                    type = "character";
                }
                else {
                    type = "integer";
                }
            }
            // string; double; int
            else {
                boolean isString = false;
                boolean isFloat = false;

                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    if (currentSymbol < 45 || currentSymbol > 57) {
                        isString = true;
                    }

                    if (currentSymbol == 46) {
                        isFloat = true;
                    }
                }

                if (isString) {
                    type = "string";
                }
                else {
                    if (isFloat) {
                        type = "floating point";
                    }
                    else {
                        type = "integer";
                    }
                }
            }
            System.out.printf("%s is %s type%n", input, type);

            input = scanner.nextLine();
        }
    }
}
