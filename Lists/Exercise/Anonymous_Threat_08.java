import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Anonymous_Threat_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lineOfChars = getMyCollection(scanner);

        String input = scanner.nextLine();
        while (!"3:1".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    mergeMyLine(lineOfChars, startIndex, endIndex);
                    break;
                case "divide":
                    int indexDivide = Integer.parseInt(tokens[1]);
                    int divideTimes = Integer.parseInt(tokens[2]);

                    List<String> dividedString = new ArrayList<>();
                    String currentElement = lineOfChars.get(indexDivide);
                    int substringsLength = currentElement.length() / divideTimes;
                    int count = 0;
                    String separatedElement = "";
                    int counterAdded = 0;

                    for (int i = 0; i < currentElement.length(); i++) {
                        char symbol = currentElement.charAt(i);
                        separatedElement += symbol;
                        count++;

                        if (count == substringsLength && counterAdded + 1 < divideTimes) {
                            dividedString.add(separatedElement);
                            count = 0;
                            counterAdded++;
                            separatedElement = "";
                        }
                    }
                    
                    dividedString.add(separatedElement);
                    lineOfChars.remove(indexDivide);

                    for (int i = dividedString.size() - 1; i >= 0; i--) {
                        lineOfChars.add(indexDivide, dividedString.get(i));
                    }
                    break;
            }
            
            input = scanner.nextLine();
        }

        for (String lineOfChar : lineOfChars) {
            System.out.print(lineOfChar + " ");
        }

    }

    private static void mergeMyLine(List<String> lineOfChars, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        
        if (endIndex > lineOfChars.size() - 1) {
            endIndex = lineOfChars.size() - 1;
        }
        
        int counter = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            String concat = lineOfChars.get(counter) + lineOfChars.get(counter + 1);
            lineOfChars.set(counter, concat);
            lineOfChars.remove(counter + 1);
        }
    }

    private static List<String> getMyCollection(Scanner scanner) {
        String input = scanner.nextLine();
        String[] split = input.split("\\s+");
        List<String> characters = new ArrayList<>();
        
        for (String elements : split) {
            String firstElement = elements;
            characters.add(firstElement);
        }
        return characters;
    }
    
}
