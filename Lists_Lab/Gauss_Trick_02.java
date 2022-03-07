package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {

            if (i == numbers.size() - 1) {
                break;
            }
            int currentElement = numbers.get(i);
            int oppositeElement = numbers.get((numbers.size()) - 1);

            numbers.set(i, currentElement + oppositeElement);
            numbers.remove(numbers.size() - 1);
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
