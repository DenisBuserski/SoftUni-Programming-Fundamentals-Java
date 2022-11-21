import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Merging_Lists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int size = Math.min(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }
        
        printTheRest(firstList, size);
        printTheRest(secondList, size);
    }

    private static void printTheRest(List<Integer> numbers, int beginIndex) {
        for (int i = beginIndex; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
    
}
