import java.util.*;

public class Word_Synonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPairs = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymDictionary = new LinkedHashMap<>();

        for (int i = 0; i < countOfPairs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonymDictionary.putIfAbsent(word, new ArrayList<>());
            synonymDictionary.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : synonymDictionary.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
        
    }
}
