package ProgrammingFundamentalsMidExam02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> inputList = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String [] commandArray = command.split("\\s+");
            String commandName = commandArray[0];

            switch (commandName) {
                case "swap":
                    int index1 = Integer.parseInt(commandArray[1]);
                    int index2 = Integer.parseInt(commandArray[2]);
                    int index1Num = inputList.get(index1);
                    int index2Num = inputList.get(index2);
                    inputList.set(index1, index2Num);
                    inputList.set(index2, index1Num);
                    break;
                case "multiply":
                    int index1a = Integer.parseInt(commandArray[1]);
                    int index2a = Integer.parseInt(commandArray[2]);
                    int index1aNum = inputList.get(index1a);
                    int index2aNum = inputList.get(index2a);
                    int newNum = index1aNum * index2aNum;
                    inputList.set(index1a, newNum);
                    break;
                case "decrease":
                    for (int i = 0; i <= inputList.size() - 1; i++) {
                        int newNum1 = inputList.get(i) - 1;
                        inputList.set(i, newNum1);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
System.out.print(inputList.toString().replaceAll("[\\[\\]]", ""));


    }
}
