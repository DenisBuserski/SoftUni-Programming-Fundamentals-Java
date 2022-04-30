package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class MultiplicationTable20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        do {
            System.out.printf("%d X %d = %d%n", num1, num2, num1 * num2);
            num2++;
        }
        while (num2 <= 10);
    }
}
