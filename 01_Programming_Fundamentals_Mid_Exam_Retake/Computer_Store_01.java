import java.util.Scanner;

public class Computer_Store_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalPriceWithoutTax = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double priceWithoutTax = Double.parseDouble(input);

            if (priceWithoutTax < 0) {
                System.out.println("Invalid price!");
            } else {
                totalPriceWithoutTax += priceWithoutTax;
            }

            input = scanner.nextLine();
        }

        double tax = totalPriceWithoutTax * 0.2;
        double finalPrice = totalPriceWithoutTax + tax;

        if (finalPrice == 0) {
            System.out.println("Invalid order!");
        } else if (input.equals("special")) {
            finalPrice -= finalPrice * 0.1;
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", totalPriceWithoutTax, tax, finalPrice);
        } else if (input.equals("regular")) {
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n", totalPriceWithoutTax, tax, finalPrice);
        }

    }
}
