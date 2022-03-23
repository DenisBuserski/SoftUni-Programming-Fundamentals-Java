import java.util.Scanner;

public class Data_Type_Finder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String type = "";
            
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) { // boolean
                type = "boolean";
            } else if (input.length() == 1) { // char; int
                char symbol = input.charAt(0);
                if (symbol < 47 || symbol > 58) {
                    type = "character";
                } else {
                    type = "integer";
                }
            } else { // string; double; int
                boolean isString = false;
                boolean isFloat = false;

                for (int i = 0; i < input.length(); i++) {
                    char currentSymbol = input.charAt(i);
                    if (currentSymbol < 45 || currentSymbol > 57) {
                        isString = true;
                    }

                    if (currentSymbol == 46) {
                        isFloat = true;
                    }
                }

                if (isString) {
                    type = "string";
                } else {
                    if (isFloat) {
                        type = "floating point";
                    } else {
                        type = "integer";
                    }
                }
            }
            System.out.printf("%s is %s type%n", input, type);

            input = scanner.nextLine();
        }
        
    }
}
