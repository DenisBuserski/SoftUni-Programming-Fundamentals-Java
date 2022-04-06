package ProgrammingFundamentalsMidExamRetake01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> inputList = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());
        int moves = 0;


        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandArray = command.split("\\s+");
            int index1N = Integer.parseInt(commandArray[0]);
            int index2N = Integer.parseInt(commandArray[1]);
            moves++;

            if (index1N == index2N || index1N < 0 || index2N >= inputList.size() || index1N >= inputList.size() || index2N < 0) {
                int middle = inputList.size() / 2;
                inputList.add(middle, "-" + moves + "a");
                inputList.add(middle, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");

            } else {
                for (int i = 0; i <= inputList.size() - 1; i++) {
                    String firstIndex = inputList.get(index1N);
                    String secondIndex = inputList.get(index2N);

                    if (firstIndex.equals(secondIndex)) {
                        inputList.remove(firstIndex);
                        inputList.remove(secondIndex);
                        System.out.printf("Congrats! You have found matching elements - %s!%n", firstIndex);
                        break;
                    } else if (!firstIndex.equals(secondIndex)) {
                        System.out.printf("Try again!%n");
                        break;
                    }
                }
            }
            if (inputList.isEmpty()) {
                System.out.printf("You have won in %d turns!%n", moves);
                break;
            }

            command = scanner.nextLine();
        }

        if (command.equals("end") && !inputList.isEmpty()) {
            System.out.printf("Sorry you lose :(%n");
            System.out.print(inputList.toString().replaceAll("[\\[\\],]", ""));
        }


    }
}
