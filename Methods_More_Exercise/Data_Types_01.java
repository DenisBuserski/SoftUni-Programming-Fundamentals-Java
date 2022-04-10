import java.util.Scanner;

public class Data_Types_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        switch (command) {
            case "int":
                int number = Integer.parseInt(scanner.nextLine());
                integerType(number);
                break;
            case "real":
                double number1 = Double.parseDouble(scanner.nextLine());
                realType(number1);
                break;
            case "string":
                String input = scanner.nextLine();
                stringType(input);
                break;
        }
    }

    private static void stringType(String input) {
        System.out.printf("$%s$", input);
    }

    private static void realType(double number1) {
        System.out.printf("%.2f", number1 * 1.5);
    }

    private static void integerType(int number) {
        System.out.println(number * 2);
    }
    
}
