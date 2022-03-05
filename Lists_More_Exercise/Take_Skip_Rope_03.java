package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Integer> numbersList = new ArrayList<>();
        List<Character> nonNumbersList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char currIndex = input.charAt(i);

            if (input.charAt(i) >= 48 && input.charAt(i) <= 57) {
                numbersList.add(Integer.parseInt(String.valueOf(currIndex)));
            } else {
                nonNumbersList.add(input.charAt(i));
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbersList.get(i));
            } else {
                skipList.add(numbersList.get(i));
            }
        }


        StringBuilder result = new StringBuilder();

        int timesToIterate = numbersList.size() / 2;

        for (int i = 0; i < timesToIterate; i++) {

            int takeListCurrIndex = takeList.get(i);
            for (int takeIndex = 0; takeIndex < takeListCurrIndex; takeIndex++) {
                if (nonNumbersList.size() == 0) {
                    break;
                }
                result.append(nonNumbersList.get(0));
                nonNumbersList.remove(0);
            }

            int skipListCurrIndex = skipList.get(i);
            if (skipListCurrIndex > 0) {
                if (nonNumbersList.size() == 0) {
                    break;
                }
                nonNumbersList.subList(0, skipListCurrIndex).clear();
            }
        }
        System.out.println(result);


    }
}
