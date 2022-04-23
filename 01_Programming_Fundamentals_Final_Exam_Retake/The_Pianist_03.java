import java.util.*;

public class The_Pianist_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> pieces = new HashMap<>();

        for (int i = 1; i <= numberOfPieces; i++) {
            String pieceInfo = scanner.nextLine();
            String [] pieceInfoArray = pieceInfo.split("\\|");
            String piece = pieceInfoArray[0];
            String composer = pieceInfoArray[1];
            String key = pieceInfoArray[2];

            pieces.put(piece, Arrays.asList(composer, key));
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String [] commandArray = command.split("\\|");
            String commandName = commandArray[0];
            String piece = commandArray[1];

            switch (commandName) {
                case "Add":
                    String composer = commandArray[2];
                    String key = commandArray[3];

                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        pieces.put(piece, Arrays.asList(composer, key));
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commandArray[2];

                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).set(1, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            
            command = scanner.nextLine();
        }

        pieces.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n", kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
    }
}
