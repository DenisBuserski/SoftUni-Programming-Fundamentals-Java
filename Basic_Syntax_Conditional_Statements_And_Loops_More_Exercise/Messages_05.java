package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lettersInWord = Integer.parseInt(scanner.nextLine());

        String letter = "";
        String word = "";

        for (int letters = 1; letters <= lettersInWord; letters++) {
            String digits = scanner.nextLine();

            int wordLength = digits.length();

            if (wordLength == 1) {
                if (digits.equals("0")) {
                    letter = " ";
                } else if (digits.equals("2")) {
                    letter = "a";
                } else if (digits.equals("3")) {
                    letter = "d";
                } else if (digits.equals("4")) {
                    letter = "g";
                } else if (digits.equals("5")) {
                    letter = "j";
                } else if (digits.equals("6")) {
                    letter = "m";
                } else if (digits.equals("7")) {
                    letter = "p";
                } else if (digits.equals("8")) {
                    letter = "t";
                } else if (digits.equals("9")) {
                    letter = "w";
                }
            } else if (wordLength == 2) {
                if (digits.equals("22")) {
                    letter = "b";
                } else if (digits.equals("33")) {
                    letter = "e";
                } else if (digits.equals("44")) {
                    letter = "h";
                } else if (digits.equals("55")) {
                    letter = "k";
                } else if (digits.equals("66")) {
                    letter = "n";
                } else if (digits.equals("77")) {
                    letter = "q";
                } else if (digits.equals("88")) {
                    letter = "u";
                } else if (digits.equals("99")) {
                    letter = "x";
                }
            } else if (wordLength == 3) {
                if (digits.equals("222")) {
                    letter = "c";
                } else if (digits.equals("333")) {
                    letter = "f";
                } else if (digits.equals("444")) {
                    letter = "i";
                } else if (digits.equals("555")) {
                    letter = "l";
                } else if (digits.equals("666")) {
                    letter = "o";
                } else if (digits.equals("777")) {
                    letter = "r";
                } else if (digits.equals("888")) {
                    letter = "v";
                } else if (digits.equals("999")) {
                    letter = "y";
                }
            } else if (wordLength == 4) {
                if (digits.equals("7777")) {
                    letter = "s";
                } else if (digits.equals("9999")) {
                    letter = "z";
                }
            }
            word += letter;
        }
        System.out.println(word);


    }
}
