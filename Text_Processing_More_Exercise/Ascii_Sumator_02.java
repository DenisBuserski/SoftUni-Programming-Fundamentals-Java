import java.util.Scanner;

public class Ascii_Sumator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i <= text.length() - 1; i++) {
            char letter = text.charAt(i);

            if (letter > symbol1 && letter < symbol2) {
                newText.append(letter);
            }
        }

        int result = 0;
        for (int i = 0; i <= newText.length() - 1; i++) {
            int number = newText.charAt(i);
            result += number;
        }
        System.out.println(result);
        
    }
}
