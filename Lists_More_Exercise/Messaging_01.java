import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String messageInput = scanner.nextLine();
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < messageInput.length(); i++) {
            message.append(messageInput.charAt(i));
        }

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            int sumOfDigits = getSumOfDigits(number);
            char currCharacter;

            if (sumOfDigits > message.length() - 1) {
                sumOfDigits -= message.length();
            }

            currCharacter = message.charAt(sumOfDigits);
            System.out.print(currCharacter);

            message.deleteCharAt(sumOfDigits);
        }
    }

    private static int getSumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            int currDigit = number % 10;
            sum += currDigit;
            number /= 10;
        }
        return sum;
    }
}
