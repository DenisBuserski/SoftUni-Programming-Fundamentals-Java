package BitwiseOperationsLab;

import java.util.Arrays;
import java.util.Scanner;

public class OddTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            result = result ^ numbers[i];
        }
        System.out.println(result);



    }
}
