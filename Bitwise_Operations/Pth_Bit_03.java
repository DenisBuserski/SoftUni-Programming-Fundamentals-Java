import java.util.Scanner;

public class Pth_Bit_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int mask = 1 << position;
        int result = (number & mask) >> position;
        System.out.println(result);
    }
}
