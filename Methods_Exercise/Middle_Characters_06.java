import java.util.Scanner;

public class Middle_Characters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        oddWord(word); // нечетен
        evenWord(word); // четен
    }

    private static void oddWord(String word) {
        if (word.length() % 2 != 0) {
            char middleLetter = word.charAt(word.length() / 2);
            String letter = String.valueOf(middleLetter);
            System.out.println(letter);
        }
    }
    
    private static void evenWord(String word) {
        if (word.length() % 2 == 0) {
            char middleLetter1 = word.charAt(word.length() / 2);
            char middleLetter2 = word.charAt((word.length() / 2) - 1);
            String letter1 = String.valueOf(middleLetter1);
            String letter2 = String.valueOf(middleLetter2);
            System.out.println(letter2 + letter1);
        }
    }
    
}
