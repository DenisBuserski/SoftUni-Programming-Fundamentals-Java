package DataTypesAndVariablesLab;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();

        System.out.printf("%s %s %s", c, b, a);
    }
}
