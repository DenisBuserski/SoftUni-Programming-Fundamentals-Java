package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        double sumCoins = 0;

        while (!"Start".equals(input = scanner.nextLine())) {
            double coins = Double.parseDouble(input);

            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sumCoins += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
        }
        String input2 = "";
        double productPrice = 0;
        double totalProductsPrice = 0;
        while (!input2.equals("End")) {
            input2 = scanner.nextLine();

            if (input2.equals("End")) {
                break;
            }

            if (input2.equals("Nuts")) {
                productPrice = 2;
                totalProductsPrice += productPrice;
                if (totalProductsPrice <= sumCoins) {
                    System.out.println("Purchased Nuts");
                }
                else {
                    totalProductsPrice -= productPrice;
                    System.out.println("Sorry, not enough money");
                }
            }
            else if (input2.equals("Water")) {
                productPrice = 0.7;
                totalProductsPrice += productPrice;
                if (totalProductsPrice <= sumCoins) {
                    System.out.println("Purchased Water");
                }
                else {
                    totalProductsPrice -= productPrice;
                    System.out.println("Sorry, not enough money");
                }
            }
            else if (input2.equals("Crisps")) {
                productPrice = 1.5;
                totalProductsPrice += productPrice;
                if (totalProductsPrice <= sumCoins) {
                    System.out.println("Purchased Crisps");
                }
                else {
                    totalProductsPrice -= productPrice;
                    System.out.println("Sorry, not enough money");
                }
            }
            else if (input2.equals("Soda")) {
                productPrice = 0.8;
                totalProductsPrice += productPrice;
                if (totalProductsPrice <= sumCoins) {
                    System.out.println("Purchased Soda");
                }
                else {
                    totalProductsPrice -= productPrice;
                    System.out.println("Sorry, not enough money");
                }
            }
            else if (input2.equals("Coke")) {
                productPrice = 1;
                totalProductsPrice += productPrice;
                if (totalProductsPrice <= sumCoins) {
                    System.out.println("Purchased Coke");
                }
                else {
                    totalProductsPrice -= productPrice;
                    System.out.println("Sorry, not enough money");
                }
            }
            else {
                System.out.println("Invalid product");
            }
        }
        double change = sumCoins - totalProductsPrice;
        if (change >= 0) {
            System.out.printf("Change: %.2f", change);
        }

    }

}

