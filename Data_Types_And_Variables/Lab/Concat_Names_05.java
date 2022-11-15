import java.util.Scanner;

public class Concat_Names_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String name2 = scanner.nextLine();
        String symbol = scanner.nextLine();

        System.out.printf("%s%s%s", name, symbol, name2);
    }
}
