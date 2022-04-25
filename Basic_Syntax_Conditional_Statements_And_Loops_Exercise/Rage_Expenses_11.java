package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headset = 0;
        int mouse = 0;
        int keyboard = 0;
        int display = 0;
        for (int i = 1; i <= lostGamesCount; i++) {

            if (i % 2 == 0) {
                headset++;
            }
            if (i % 3 == 0) {
                mouse++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboard++;
                if (keyboard % 2 == 0) {
                    display++;
                }
            }
        }

        double total = (headsetPrice * headset) + (mousePrice * mouse) + (keyboardPrice * keyboard) + (displayPrice * display);

        System.out.printf("Rage expenses: %.2f lv.", total);
    }
}
