import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<furniture>\\w+)<<(?<prise>\\d+.\\d*)!(?<quantity>\\d+)";
        String input = scanner.nextLine();

        System.out.println("Bought furniture:");
        double result = 0;

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String furniture = matcher.group("furniture");
                String prise = matcher.group("prise");
                double priseNum = Double.parseDouble(prise);
                String quantity = matcher.group("quantity");
                double quantityNum = Double.parseDouble(quantity);
                result += priseNum * quantityNum;

                System.out.printf("%s%n", furniture);
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total money spend: %.2f", result);
    }
}
