import java.util.Scanner;

public class Activation_Keys_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String startKey = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] inputArray = input.split(">>>");
            String command = inputArray[0];

            switch (command) {
                case "Contains":
                    String substring = inputArray[1];
                    if (startKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", startKey, substring);
                    } else {
                        System.out.printf("Substring not found!%n");
                    }
                    break;
                case "Flip":
                    String secondCommand = inputArray[1];
                    int startIndexF = Integer.parseInt(inputArray[2]);
                    int endIndexF = Integer.parseInt(inputArray[3]);
                    String selectedPart = "";
                    String newInput = "";

                    if (secondCommand.equals("Upper")) {
                        selectedPart = startKey.substring(startIndexF, endIndexF);
                        newInput = selectedPart.toUpperCase();
                        startKey = startKey.replaceAll(selectedPart, newInput);
                        System.out.printf("%s%n", startKey);
                    } else if (secondCommand.equals("Lower")) {
                        selectedPart = startKey.substring(startIndexF, endIndexF);
                        newInput = selectedPart.toLowerCase();
                        startKey = startKey.replaceAll(selectedPart, newInput);
                        System.out.printf("%s%n", startKey);
                    }
                    break;
                case "Slice":
                    String toDelete = "";
                    int startIndex = Integer.parseInt(inputArray[1]);
                    int endIndex = Integer.parseInt(inputArray[2]);
                    toDelete = startKey.substring(startIndex, endIndex);
                    startKey = startKey.replaceAll(toDelete, "");
                    System.out.printf("%s%n", startKey);
                    break;
            }

            input = scanner.nextLine();
        }
        
        System.out.printf("Your activation key is: %s%n", startKey);
    }
}
