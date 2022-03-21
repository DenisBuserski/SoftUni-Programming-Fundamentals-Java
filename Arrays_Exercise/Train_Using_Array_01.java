import java.util.Scanner;

public class Train_Using_Array_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = 0;
        for (int number : numbers) {
            System.out.println(number + " ");
            sum += number;
        }

        System.out.println();
        System.out.println(sum);
    }
}
