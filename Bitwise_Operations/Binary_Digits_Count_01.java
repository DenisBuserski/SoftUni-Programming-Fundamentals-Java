import java.util.Scanner;

public class Binary_Digits_Count_01 {
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
