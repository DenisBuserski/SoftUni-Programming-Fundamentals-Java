package ProgrammingFundamentalsMidExam27February2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> priceRatings = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int entryPointIndex = Integer.parseInt(scanner.nextLine());
        String itemType = scanner.nextLine();

        int leftSum = 0;
        int rightSum = 0;
        switch (itemType) {
            case "cheap":
                int entryPoint = priceRatings.get(entryPointIndex);
                for (int indexL = 0; indexL < entryPointIndex; indexL++) {
                    if (priceRatings.get(indexL) < entryPoint) {
                        leftSum += priceRatings.get(indexL);
                    }
                }
                for (int indexR = entryPointIndex + 1; indexR < priceRatings.size(); indexR++) {
                    if (priceRatings.get(indexR) < entryPoint) {
                        rightSum += priceRatings.get(indexR);
                    }
                }
                break;
            case "expensive":
                int entryPointR = priceRatings.get(entryPointIndex);
                for (int indexL = 0; indexL < entryPointIndex; indexL++) {
                    if (priceRatings.get(indexL) >= entryPointR) {
                        leftSum += priceRatings.get(indexL);
                    }
                }
                for (int indexR = entryPointIndex + 1; indexR < priceRatings.size(); indexR++) {
                    if (priceRatings.get(indexR) >= entryPointR) {
                        rightSum += priceRatings.get(indexR);
                    }
                }
                break;
        }
        if (leftSum >= rightSum) {
            System.out.printf("Left - %d", leftSum);
        } else {
            System.out.printf("Right - %d", rightSum);
        }
    }
}
