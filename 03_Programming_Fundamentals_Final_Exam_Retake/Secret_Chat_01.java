import java.util.Scanner;

public class Secret_Chat_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Reveal")) {
            String[] commandArray = command.split(":\\|:");
            String commandName = commandArray[0];

            switch (commandName) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArray[1]);
                    StringBuilder space = new StringBuilder(input);
                    input = space.insert(index, " ").toString();
                    System.out.printf("%s%n", input);
                    break;
                case "Reverse":
                    String substringToReverse = commandArray[1];
                    StringBuilder substring1 = new StringBuilder(substringToReverse);
                    String reversedSubstring = substring1.reverse().toString();

                    if (input.contains(substringToReverse)) {
                        input = input.replaceFirst(substringToReverse, "");
                        input = input.concat(reversedSubstring);
                        System.out.printf("%s%n", input);
                    } else {
                        System.out.printf("error%n");
                    }
                    break;
                case "ChangeAll":
                    String substring = commandArray[1];
                    String replacement = commandArray[2];
                    input = input.replace(substring, replacement);
                    System.out.printf("%s%n", input);
                    break;
            }

            command = scanner.nextLine();
        }
        
        System.out.printf("You have a new text message: %s%n", input);
    }
}
