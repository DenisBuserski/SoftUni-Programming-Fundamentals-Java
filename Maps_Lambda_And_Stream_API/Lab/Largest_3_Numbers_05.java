import java.util.Arrays;
import java.util.Scanner;

public class Largest_3_Numbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        Arrays.stream(input)
                .map(Integer::parseInt)
                .sorted((left, right) -> right.compareTo(left))
                .limit(3)
                .forEach(e -> System.out.print(e + " "));
    }
}
