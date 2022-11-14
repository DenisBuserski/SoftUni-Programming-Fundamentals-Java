import java.util.Scanner;

public class Orders_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOrdersReceived = Integer.parseInt(scanner.nextLine());
        double result = 0;
        double totalResult = 0;

        for (int i = 0; i < numberOfOrdersReceived; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            double capsulesCount = Double.parseDouble(scanner.nextLine());

            result = ((days * capsulesCount) * pricePerCapsule);
            totalResult += result;
            System.out.printf("The price for the coffee is: $%.2f%n", result);
            result = 0;
        }

        System.out.printf("Total: $%.2f", totalResult);

    }
}
