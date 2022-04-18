package ProgrammingFundamentalsMidExam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shoppingList = scanner.nextLine();
        List<String>  shoppingList1 = Arrays.stream(shoppingList.split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String [] inputArray = input.split("\\s+");
            String command = inputArray[0];
            String item = inputArray[1];

            switch (command) {
                case "Urgent":
                    if (!shoppingList1.contains(item)) {
                        shoppingList1.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList1.contains(item)) {
                        shoppingList1.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = inputArray[2];
                    int index = shoppingList1.indexOf(item);
                    if (shoppingList1.contains(item)) {
                        shoppingList1.set(index, newItem);
                    }
                    break;
                case "Rearrange":
                    int lastIndex = shoppingList1.size();
                    if (shoppingList1.contains(item)) {
                        shoppingList1.remove(item);
                        shoppingList1.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(shoppingList1.toString().replaceAll("[\\[\\]]", ""));

    }
}
