package BitwiseOperationsLab;

import java.util.Scanner;

public class BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int binaryNumber = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while (number > 0) {
            int leftover = number % 2;
            if (leftover == binaryNumber) {
                count++;
            }
            number /= 2;
        }
        System.out.println(count);
    }
}
