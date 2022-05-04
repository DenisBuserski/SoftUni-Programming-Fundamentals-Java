import java.util.Scanner;

public class Lower_Or_Upper_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);

        if (Character.isLowerCase(firstChar)) {
            System.out.println("lower-case");
        } else if (Character.isUpperCase(firstChar)) {
            System.out.println("upper-case");
        }

    }
}
