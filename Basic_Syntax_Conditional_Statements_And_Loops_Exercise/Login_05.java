package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        String reversePassword = "";
        int tries = 0;

        while (!username.equals(password)) {
            password = scanner.nextLine();
            tries++;


            for (int i = password.length() - 1; i >= 0; i--) {
                reversePassword = reversePassword + password.charAt(i);
            }
            if (username.equals(reversePassword)) {
                System.out.printf("User %s logged in.", username);
                break;
            }
            if (tries == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }

            if (!username.equals(password)) {
                System.out.println("Incorrect password. Try again.");
                reversePassword = "";
            }
            if (username.equals(password)) {
                System.out.println("Incorrect password. Try again.");
                password = "";
                reversePassword = "";
            }
        }
    }
}

