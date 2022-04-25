package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsabersPriceForOne = Double.parseDouble(scanner.nextLine());
        double robesPriceForOne = Double.parseDouble(scanner.nextLine());
        double beltsPriceForOne = Double.parseDouble(scanner.nextLine());

        double lightsaberStudents = Math.ceil(students * 1.1);
        double lightsabersPrice = lightsabersPriceForOne * lightsaberStudents;
        double robesPrice = robesPriceForOne * students;
        double beltsPrice = beltsPriceForOne * (students - students / 6);

        double totalPrice = lightsabersPrice + robesPrice + beltsPrice;

        if (money >= totalPrice) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else if (money < totalPrice) {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - money);
        }


    }
}
