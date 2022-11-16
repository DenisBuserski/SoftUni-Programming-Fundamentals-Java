import java.util.Scanner;

public class Triples_Of_Latin_Letters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            char firstChar = (char) ('a' + i);
            
            for (int j = 0; j < n; j++) {
                char secondChar = (char) ('a' + j);

                for (int z = 0; z < n; z++) {
                    char thirdChar = (char) ('a' + z);

                    System.out.printf("%c%c%c%n", firstChar, secondChar, thirdChar);
                }
            }
        }

    }
}
