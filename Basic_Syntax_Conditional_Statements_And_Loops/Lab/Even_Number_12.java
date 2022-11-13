import java.util.Scanner;

public class Even_Number_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number % 2 == 0) {
            System.out.printf("The number is: %d", Math.abs(number));
        }

        while (number % 2 != 0) {
            System.out.println("Please write an even number.");
            number = Integer.parseInt(scanner.nextLine());

            if (number % 2 == 0) {
                System.out.printf("The number is: %d", Math.abs(number));
                break;
            }
        }

    }
}
