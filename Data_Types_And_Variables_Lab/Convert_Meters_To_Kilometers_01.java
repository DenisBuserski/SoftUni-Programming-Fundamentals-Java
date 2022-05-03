import java.util.Scanner;

public class Convert_Meters_To_Kilometers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double meters = Double.parseDouble(scanner.nextLine());

        double km = meters / 1000;

        System.out.printf("%.2f", km);
    }
}
