import java.util.Scanner;

public class Bit_At_Position_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int mask = 1 << 1;

        int result = (input & mask)>>1;
        System.out.println(result);

    }
}
