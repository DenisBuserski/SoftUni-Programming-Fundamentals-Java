package MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        switch (product) {
            case "coffee":
                coffeePrice(product, quantity);
                break;
            case "water":
                waterPrice(product, quantity);
                break;
            case "coke":
                cokePrice(product, quantity);
                break;
            case "snacks":
                snacksPrice(product, quantity);
                break;
        }

    }

    private static void coffeePrice(String product, double quantity) {
        System.out.printf("%.2f", quantity * 1.5);
    }
    private static void waterPrice(String product, double quantity) {
        System.out.printf("%.2f", quantity * 1);
    }
    private static void cokePrice(String product, double quantity) {
        System.out.printf("%.2f", quantity * 1.4);
    }
    private static void snacksPrice(String product, double quantity) {
        System.out.printf("%.2f", quantity * 2);
    }
}
