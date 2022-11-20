import java.util.Arrays;
import java.util.Scanner;

public class Top_Number_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        isTop(n);
    }
    
    private static void isTop(int n) {
        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;
            boolean hasOdd = false;

            while (number != 0) {
                int currentDigit = number % 10;
                sum += currentDigit;
                if (currentDigit % 2 != 0) {
                    hasOdd = true;
                }
                number /= 10;
            }

            if (sum % 8 == 0 && hasOdd) {
                System.out.println(i);
            }
        }
        
    }
}
