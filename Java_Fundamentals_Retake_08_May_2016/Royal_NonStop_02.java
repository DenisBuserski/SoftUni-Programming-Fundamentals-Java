package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Retake_08_May_2016;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class Royal_NonStop_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int maxRow = Integer.parseInt(dimensions[0]);
        int maxColumn = Integer.parseInt(dimensions[1]);

        double[] productPrices = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        BigDecimal totalMoney = BigDecimal.ZERO;
        int totalCustomers = 0;

        String inputLine;
        while (!"Royal Close".equals(inputLine = scanner.nextLine())) {
            BigDecimal currentSum = BigDecimal.ZERO;
            int initialRow = Integer.parseInt(inputLine.split(" ")[0]);
            int initialColumn = Integer.parseInt(inputLine.split(" ")[1]);

            if (initialRow >= initialColumn) {
                for (int currentColumn = initialColumn; currentColumn >= 0; currentColumn--) {
                    BigDecimal rowValue = new BigDecimal(initialRow + 1);
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);

                    BigDecimal productPrice = new BigDecimal(productPrices[initialRow % 2]);
                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }

                for (int currentRow = initialRow - 1; currentRow > 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[currentRow % 2]);
                    BigDecimal productSum = rowValue.multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
            } else {
                for (int currentRow = initialRow; currentRow >= 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal colValue = new BigDecimal(initialColumn + 1);

                    BigDecimal productPrice = new BigDecimal(productPrices[currentRow % 2]);
                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }

                for (int currentColumn = initialColumn - 1; currentColumn > 0; currentColumn--) {
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[0]);
                    BigDecimal productSum = colValue.multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
            }

            totalMoney = totalMoney.add(currentSum);
            totalCustomers++;
        }


        System.out.println(totalMoney.setScale(6, RoundingMode.HALF_EVEN));
        System.out.println(totalCustomers);
    }

}
