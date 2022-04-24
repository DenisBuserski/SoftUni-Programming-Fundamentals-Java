import java.util.Scanner;

public class Strong_Number_06 {
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
            // Премахваме последната цифра от числото
            number /= 10;
        }

        if (sumFact == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
