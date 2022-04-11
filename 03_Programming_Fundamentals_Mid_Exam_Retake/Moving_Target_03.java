import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Moving_Target_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String targets = scanner.nextLine();
        List<Integer> targetsList = Arrays.stream(targets.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String [] inputArray = input.split("\\s+");

            switch (inputArray[0]) {
                case "Shoot":
                    int shotIndex = Integer.parseInt(inputArray[1]);
                    int power = Integer.parseInt(inputArray[2]);

                    if (shotIndex < targetsList.size() && shotIndex >= 0) {
                        targetsList.set(shotIndex, targetsList.get(shotIndex) - power);
                        if (targetsList.get(shotIndex) <= 0) {
                            targetsList.remove(shotIndex);
                        }
                    }
                    break;
                case "Add":
                    int indexToAdd = Integer.parseInt(inputArray[1]);
                    int value = Integer.parseInt(inputArray[2]);
                    
                    if (indexToAdd < targetsList.size() && indexToAdd >= 0) {
                        targetsList.add(indexToAdd, value);
                    } else {
                        System.out.printf("Invalid placement!%n");
                    }
                    break;
                case "Strike":
                    int index = Integer.parseInt(inputArray[1]);
                    int radius = Integer.parseInt(inputArray[2]);

                    if (index - radius >= 0 && index + radius < targetsList.size()) {
                        targetsList.subList(index - radius, index + radius + 1).clear();
                    } else {
                        System.out.printf("Strike missed!%n");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        
        for (int index = 0; index <= targetsList.size() - 1; index++) {
            if (index != targetsList.size() - 1) {
                System.out.print(targetsList.get(index) + "|");
            } else {
                System.out.print(targetsList.get(index));

            }
        }

    }
}
