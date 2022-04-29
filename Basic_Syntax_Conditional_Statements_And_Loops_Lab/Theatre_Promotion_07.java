package BasicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = -1;


        switch (typeOfDay) {
            case "Weekday":
                if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                    price = 12;
                }
                else if (age > 18 && age <= 64) {
                    price = 18;
                }
                break;
            case "Weekend":
                if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                    price = 15;
                }
                else if (age > 18 && age <= 64) {
                    price = 20;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                }
                else if (age > 18 && age <= 64) {
                    price = 12;
                }
                else if (age > 64 && age <= 122) {
                    price = 10;
                }
                break;
        }

        if (price == -1) {
            System.out.println("Error!");
        }
        else {
            System.out.println(price + "$");
        }
    }
}
