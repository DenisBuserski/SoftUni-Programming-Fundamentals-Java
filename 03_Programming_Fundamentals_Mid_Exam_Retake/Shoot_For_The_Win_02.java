import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shoot_For_The_Win_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> inputList = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int targetCount = 0;

        String index = scanner.nextLine();
        while (!index.equals("End")) {
            int indexInt = Integer.parseInt(index);

            if (indexInt <= inputList.size() - 1) {
                targetCount++;
                int previousNum = inputList.get(indexInt);
                inputList.set(indexInt, -1);

                for (int i = 0; i <= inputList.size() - 1; i++) {
                    int number = inputList.get(i);
                    if (inputList.get(i) > 0) {
                        if (number > previousNum) {
                            number -= previousNum;
                            inputList.set(i, number);
                        } else if (inputList.get(i) <= previousNum) {
                            number += previousNum;
                            inputList.set(i, number);
                        }
                    }
                }
            }

            index = scanner.nextLine();
        }
        
        System.out.printf("Shot targets: %d -> ", targetCount);
        System.out.print(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
