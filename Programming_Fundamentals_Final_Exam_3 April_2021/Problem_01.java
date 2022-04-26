package ProgrammingFundamentalsFinalExam3April2021;

import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String [] commandArray = command.split(" ");
            String commandName = commandArray[0];

            switch (commandName) {
                case "Translate":
                    String substitute = commandArray[1];
                    String replacement = commandArray[2];

                    if (input.contains(substitute)) {
                        input = input.replace(substitute, replacement);
                    }
                    System.out.println(input);
                    break;
                case "Includes":
                    String includedString = commandArray[1];
                    if (input.contains(includedString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String startString = commandArray[1];
                    String [] inputArray = input.split(" ");
                    if (inputArray[0].equals(startString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    input = input.toLowerCase();
                    System.out.println(input);
                    break;
                case "FindIndex":
                    String find = commandArray[1];
                    System.out.println(input.lastIndexOf(find));
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int count = Integer.parseInt(commandArray[2]);
                    int endIndex = startIndex + count;
                    String remove = input.substring(startIndex, endIndex);
                    input = input.replace(remove, "");
                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
