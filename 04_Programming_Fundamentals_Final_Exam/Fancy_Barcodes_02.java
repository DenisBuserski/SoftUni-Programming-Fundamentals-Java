import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fancy_Barcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String barcode = scanner.nextLine();
            String validBarcode = "";

            String regex = "(?<match>\\@\\#+)(?<barcode>[A-Z]{1}[A-Za-z0-9]{4,}[A-Z]{1})\\@{1}\\#+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                validBarcode = matcher.group();
                StringBuilder output = new StringBuilder();
                for (int index = 0; index <= validBarcode.length() - 1; index++) {
                    char symbol = validBarcode.charAt(index);
                    if (Character.isDigit(symbol)) {
                        output.append(symbol);
                    }
                }

                if (output.toString().isEmpty()) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.printf("Product group: %s%n", output);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
        
    }
}
