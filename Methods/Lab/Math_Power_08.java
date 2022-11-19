import java.text.DecimalFormat;
import java.util.Scanner;

public class Math_Power_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));
    }

    public static double mathPower(double number, int power) {
        double result = 1;
        result = Math.pow(number, power);
        return result;
    }

}
