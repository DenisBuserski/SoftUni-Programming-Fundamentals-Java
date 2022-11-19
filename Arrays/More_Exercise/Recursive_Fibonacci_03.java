import java.util.Scanner;

public class Recursive_Fibonacci_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[] fibonacci = new long[n];

        if (n >= 1 && n <= 50) {
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == 1) {
                    fibonacci[i] = 1;
                } else {
                    fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
                }
            }
            System.out.println(fibonacci[n - 1]);
        } else {
            System.out.println(n);
        }
        
    }
}
