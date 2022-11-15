import java.util.Scanner;

public class Refactor_Volume_Of_Pyramid_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length, width, height = 0;

        System.out.print("Length: ");
        System.out.print("Width: ");
        System.out.print("Height: ");
        length = Double.parseDouble(scanner.nextLine());
        width = Double.parseDouble(scanner.nextLine());
        height = Double.parseDouble(scanner.nextLine());

        double result = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", result);
    }
}
