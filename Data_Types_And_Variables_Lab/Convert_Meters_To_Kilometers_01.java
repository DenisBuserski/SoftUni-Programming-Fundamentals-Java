package DataTypesAndVariablesLab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double meters = Double.parseDouble(scanner.nextLine());

        double km = meters / 1000;

        System.out.printf("%.2f", km);

    }
}
