import java.util.Scanner;

public class Repeat_Strings_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        for (String word : words) {
            String repetedWord = repeatWord(word, word.length());
            System.out.print(repetedWord);
        }
    }

    private static String repeatWord(String word, int numberOfRepetitions) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfRepetitions; i++) {
            result.append(word);
        }
        return result.toString();
    }

}
