import java.util.Scanner;

public class Password_Validator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.next();

        if (!validateLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!validateContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!validateDigitsCount(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (validateLength(password) && validateContent(password) && validateDigitsCount(password)) {
            System.out.println("Password is valid");
        }

    }

    static boolean validateLength (String pass) {
        if (pass.length() >= 6 && pass.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    static boolean validateContent (String pass) {
        for (int index = 0; index <= pass.length() - 1; index++) {
            char currentSymbol = pass.charAt(index);
            boolean isSmallLetter = currentSymbol >= 97 && currentSymbol <= 120;
            boolean isCapitalLetter = currentSymbol >= 65 && currentSymbol <= 90;
            boolean isDigit = currentSymbol >= 48 && currentSymbol <= 57;

            if (!isSmallLetter && !isCapitalLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    static boolean validateDigitsCount(String pass) {
        int countDigits = 0;
        for (int index = 0; index <= pass.length() - 1; index++) {
            char currentSymbol = pass.charAt(index);
            if (Character.isDigit(currentSymbol)) {
                countDigits++;
            }
        }

        if (countDigits >= 2) {
            return true;
        } else {
            return false;
        }
    }
    
}
