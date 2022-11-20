import java.util.Scanner;

public class Multiply_Evens_By_Odds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int multiplyOfEvenAndOdds = getMultipleOfEvensAndOdds(Math.abs(input));
        System.out.println(multiplyOfEvenAndOdds);
    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int evenSum = getSumOfEvenDigits(number);
        int oddSum = getSumOfOddDigits(number);
        return oddSum * evenSum;
    }

    private static int getSumOfEvenDigits(int number) {
        int evenSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) {
                evenSum += digit;
            }
            number = number / 10;
        }
        return evenSum;
    }

    private static int getSumOfOddDigits(int number) {
        int oddSum = 0;
        while (number > 0) {
            int digit = number % 10;
            if (number % 2 == 1) {
                oddSum += digit;
            }
            number = number / 10;
        }
        return oddSum;
    }
    
}
