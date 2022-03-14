package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "%(?<customer>[A-Z]{1}[a-z]+)%[^\\\\|\\$\\%\\.]*<(?<product>\\w+)>[^\\\\|\\$\\%\\.]*\\|(?<count>[0-9]+)\\|[^\\\\|\\$\\%\\.]*(?<prise>[1-9]\\d?.\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalPrice = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double prisePerOne = Double.parseDouble(matcher.group("prise"));
                double prise = prisePerOne * count;
                totalPrice += prise;

                System.out.printf("%s: %s - %.2f%n", customer, product, prise);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalPrice);
    }
}
