import java.util.Scanner;

public class Print_Part_Of_ASCII_Table_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstChar = Integer.parseInt(scanner.nextLine());
        int secondChar = Integer.parseInt(scanner.nextLine());

        for (int i = firstChar; i <= secondChar; i++) {
            System.out.printf("%c ", (char) i);
        }

    }
}
