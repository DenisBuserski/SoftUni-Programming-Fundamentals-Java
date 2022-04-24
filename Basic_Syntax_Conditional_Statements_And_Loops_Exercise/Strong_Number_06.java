package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number;

        int sumFact = 0;

        while (number != 0) {
            int digit = number % 10;

            int fact = 1;

            for (int i = 1; i <= digit; i++) {
                fact = fact * i;
            }
            sumFact += fact;
            //4. премахваме последната цифра от числото
            number /= 10;
        }

        if (sumFact == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
