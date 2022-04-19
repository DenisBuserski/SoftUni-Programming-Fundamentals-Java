import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Count_Chars_In_A_String_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> lettersCount = new LinkedHashMap<>();

        for (int index = 0; index <= text.length() - 1; index++) {
            char currentSymbol = text.charAt(index);
            if (currentSymbol == ' ') {
                continue;
            }

            if (!lettersCount.containsKey(currentSymbol)) {
                lettersCount.put(currentSymbol, 1);
            } else {
                lettersCount.put(currentSymbol, lettersCount.get(currentSymbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : lettersCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
    }
}
