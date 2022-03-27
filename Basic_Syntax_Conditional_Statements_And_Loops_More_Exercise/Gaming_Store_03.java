package BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());

        double gamePrice = 0;
        double moneySpend = 0;

        String gameName = "";
        while (!gameName.equals("Game Time")) {
            gameName = scanner.nextLine();
            if (money <= 0) {
                System.out.println("Out of money!");
                break;
            }

            if (gameName.equals("Game Time")) {
                break;
            }


            switch (gameName) {
                case "OutFall 4":
                    gamePrice = 39.99;
                    if (money < gamePrice) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought OutFall 4");
                        money -= gamePrice;
                        moneySpend += gamePrice;
                    }
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    if (money < gamePrice) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought CS: OG");
                        money -= gamePrice;
                        moneySpend += gamePrice;
                    }
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    if (money < gamePrice) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Zplinter Zell");
                        money -= gamePrice;
                        moneySpend += gamePrice;
                    }
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    if (money < gamePrice) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought Honored 2");
                        money -= gamePrice;
                        moneySpend += gamePrice;
                    }
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    if (money < gamePrice) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch");
                        money -= gamePrice;
                        moneySpend += gamePrice;
                    }
                    break;
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    if (money < gamePrice) {
                        System.out.println("Too Expensive");
                    } else {
                        System.out.println("Bought RoverWatch Origins Edition");
                        money -= gamePrice;
                        moneySpend += gamePrice;
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;

            }



        }
        if (money > 0) {

            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpend, money);
        }


    }
}
