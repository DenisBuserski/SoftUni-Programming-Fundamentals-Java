import java.util.Scanner;

public class Math_Operations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1 = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();
        double number2 = Double.parseDouble(scanner.nextLine());

        result(number1, command, number2);
    }
        
    private static void result(double number1, String command, double number2) {
        double result = 0;

        switch (command) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        System.out.printf("%.0f", result);
    }
        
}
