import java.util.Scanner;

public class Refactor_Sum_Of_Odd_Numbers_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        
        for (int i = 1; i <= n; i++) {
            int oddNumber = 2 * i - 1;
            sum += oddNumber;
            System.out.printf("%d%n", oddNumber);
        }
        
        System.out.printf("Sum: %d", sum);
    }
}
