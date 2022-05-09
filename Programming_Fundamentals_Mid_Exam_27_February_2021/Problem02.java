package ProgrammingFundamentalsMidExam27February2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> weaponName = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String [] commandArray = command.split(" ");
            String firstCommand = commandArray[0];
            String secondCommand = commandArray[1];

            switch (firstCommand) {
                case "Move":
                    if (secondCommand.equals("Left")) {
                        int indexL = Integer.parseInt(commandArray[2]);
                        if (indexL < 0 || indexL >= weaponName.size()) {
                            break;
                        } else {
                            int newIndexL = indexL - 1;
                            if (newIndexL < 0 || newIndexL >= weaponName.size()) {
                                break;
                            } else {
                                weaponName.add(newIndexL, weaponName.remove(indexL));
                            }
                        }
                    } else if (secondCommand.equals("Right")) {
                        int indexR = Integer.parseInt(commandArray[2]);
                        if (indexR < 0 || indexR >= weaponName.size()) {
                            break;
                        } else {
                            int newIndexR = indexR + 1;
                            if (newIndexR < 0 || newIndexR >= weaponName.size()) {
                                break;
                            } else {
                                weaponName.add(newIndexR, weaponName.remove(indexR));
                            }
                        }
                    }
                    break;
                case "Check":
                    if (secondCommand.equals("Even")) {
                        for (int index = 0; index < weaponName.size(); index++) {
                            if (index % 2 == 0) {
                                System.out.print(weaponName.get(index) + " ");
                            }
                        }
                    } else if (secondCommand.equals("Odd")) {
                        for (int index = 0; index < weaponName.size(); index++) {
                            if (index % 2 != 0) {
                                System.out.print(weaponName.get(index) + " ");
                            }
                        }

                    }
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
        String weapon = String.join("", weaponName);
        System.out.printf("You crafted %s!", weapon);


    }
}
