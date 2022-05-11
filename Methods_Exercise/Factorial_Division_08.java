import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1 = Double.parseDouble(scanner.nextLine());
        double number2 = Double.parseDouble(scanner.nextLine());

        getNumber(number1, number2);
    }
    
    private static void getNumber(double number1, double number2) {
        double factorial1 = 1;
        double factorial2 = 1;
        for (int i = 1; i <= number1; i++) {
            factorial1 *= i;
        }
        for (int i = 1; i <= number2; i++) {
            factorial2 *= i;
        }

        System.out.printf("%.2f", factorial1 / factorial2);
    }

}
