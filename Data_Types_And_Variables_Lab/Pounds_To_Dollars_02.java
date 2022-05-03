import java.util.Scanner;

public class Pounds_To_Dollars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

        double course = 1.31;

        double dollars = pounds * course;

        System.out.printf("%.3f", dollars);
    }
}
