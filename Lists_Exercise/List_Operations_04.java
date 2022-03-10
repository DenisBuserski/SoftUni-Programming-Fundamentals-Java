package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    int addNumber = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if (isValidIndex(index, numbers.size())) {
                        numbers.add(index, addNumber);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(tokens[1]);
                    if (isValidIndex(indexRemove, numbers.size())) {
                        numbers.remove(indexRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    if (direction.equals("right")) {
                        for (int i = 1; i <= count; i++) {
                            int lastNumber = numbers.get(numbers.size() - 1);
                            numbers.remove(numbers.size() - 1);
                            numbers.add(0, lastNumber);


                        }

                    } else if (direction.equals("left")) {
                        for (int i = 1; i <= count; i++) {
                            int firstNumber = numbers.get(0);
                            numbers.remove(0);
                            numbers.add(firstNumber);

                        }
                    }

                    break;
            }


            input = scanner.nextLine();
        }
        printList(numbers);


    }

    private static void printList(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static boolean isValidIndex(int index, int length) {
        if (index >= 0 && index <= length - 1) {
            return true;
        } else {
            return false;
        }
    }
}
