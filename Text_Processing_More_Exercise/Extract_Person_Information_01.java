import java.util.Scanner;

public class Extract_Person_Information_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            int indexOfNameStart = input.indexOf('@');
            int indexOfNameEnd = input.indexOf('|');
            String name = input.substring(indexOfNameStart + 1, indexOfNameEnd);
            int indexOfAgeStart = input.indexOf('#');
            int indexOfAgeEnd = input.indexOf('*');
            String age = input.substring(indexOfAgeStart + 1, indexOfAgeEnd);

            System.out.printf("%s is %s years old.%n", name, age);

        }
    }
}
