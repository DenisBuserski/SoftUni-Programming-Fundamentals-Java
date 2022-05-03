package DataTypesAndVariablesLab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            String numberFromUser = scanner.nextLine();
            BigDecimal number = new BigDecimal(numberFromUser);
            sum = sum.add(number);
        }

        System.out.println(sum);


    }
}
