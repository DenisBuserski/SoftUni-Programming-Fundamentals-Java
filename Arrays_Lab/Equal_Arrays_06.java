package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        String[] splittedInput = input.split(" ");
        int secondArray[] = new int[splittedInput.length];
        for (int i = 0; i < splittedInput.length; i++) {
            secondArray[i] = Integer.parseInt(splittedInput[i]);
        }


        int sum = 0;
        boolean areIdentical = true;

        for (int i = 0; i < firstArray.length; i++) {
            sum += firstArray[i];

            if (firstArray[i] != secondArray[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areIdentical = false;
                break;
            }
        }
        if (areIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }

    }
}
