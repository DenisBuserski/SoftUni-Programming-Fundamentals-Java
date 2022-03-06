import java.util.*;
import java.util.stream.Collectors;

public class Mixed_Up_Lists_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int smallerList = Math.min(firstList.size(), secondList.size());
        List<Integer> mixedList = mixTheLists(smallerList, firstList, secondList);
        List<Integer> sortedResult = new ArrayList<>();

        if (firstList.isEmpty()) {
            getTheNumbersInRange(secondList, mixedList, sortedResult);
        } else {
            getTheNumbersInRange(firstList, mixedList, sortedResult);
        }
    }

    private static List<Integer> mixTheLists(int smallerList, List<Integer> firstList, List<Integer> secondList) {
        List<Integer> mixedList = new ArrayList<>();
        for (int i = 0; i < smallerList; i++) {
            mixedList.add(firstList.get(0));
            mixedList.add(secondList.get(secondList.size() - 1));
            firstList.remove(0);
            secondList.remove(secondList.size() - 1);
        }
        return mixedList;
    }

    private static void getTheNumbersInRange(List<Integer> list, List<Integer> result, List<Integer> sortedResult) {
        for (Integer number : result) {
            if (number > Math.min(list.get(0), list.get(1)) && number < Math.max(list.get(0), list.get(1))) {
                sortedResult.add(number);
            }
        }
        Collections.sort(sortedResult);
        for (Integer numbers : sortedResult) {
            System.out.print(numbers + " ");
        }
    }
    
}
