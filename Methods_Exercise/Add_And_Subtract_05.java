import java.util.Scanner;

public class Add_And_Subtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        int add = operationAdd(number1, number2);
        int result = operationSubtract(add, number3);
        System.out.println(result);
    }

    private static int operationSubtract(int operationAdd, int number3) {
        return operationAdd - number3;
    }

    private static int operationAdd(int number1, int number2) {
        return number1 + number2;
    }
    
}
