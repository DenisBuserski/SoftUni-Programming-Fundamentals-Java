import java.util.Scanner;

public class The_Imitation_Game_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String [] commandArray = command.split("\\|");
            String commandName = commandArray[0];

            switch (commandName) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandArray[1]);

                    for (int i = 0; i < numberOfLetters; i++) {
                        char symbol = encryptedMessage.charAt(i);
                        encryptedMessage = encryptedMessage.concat(String.valueOf(symbol));
                    }
                    StringBuilder encryptedMessage2 = new StringBuilder(encryptedMessage);
                    encryptedMessage = encryptedMessage2.delete(0, numberOfLetters).toString();
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArray[1]);
                    String value = commandArray[2];
                    StringBuilder encryptedMessage1 = new StringBuilder(encryptedMessage);
                    encryptedMessage1.insert(index, value);
                    encryptedMessage = encryptedMessage1.toString();
                    break;
                case "ChangeAll":
                    String substring = commandArray[1];
                    String replacement = commandArray[2];
                    encryptedMessage = encryptedMessage.replace(substring, replacement);
                    break;
            }
            
            command = scanner.nextLine();
        }
        
        System.out.printf("The decrypted message is: %s", encryptedMessage);
    }
}
