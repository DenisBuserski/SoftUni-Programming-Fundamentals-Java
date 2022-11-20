import java.util.Scanner;

public class Vowels_Count_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        printVowels(word);
    }

    private static void printVowels(String word) {
        //a e i o u
        int vowelsSum = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            switch (letter) {
                case 97:
                    vowelsSum++;
                    break;
                case 101:
                    vowelsSum++;
                    break;
                case 105:
                    vowelsSum++;
                    break;
                case 111:
                    vowelsSum++;
                    break;
                case 117:
                    vowelsSum++;
                    break;
                case 65:
                    vowelsSum++;
                    break;
                case 69:
                    vowelsSum++;
                    break;
                case 'I':
                    vowelsSum++;
                    break;
                case 79:
                    vowelsSum++;
                    break;
                case 85:
                    vowelsSum++;
                    break;
            }
        }
        
        System.out.println(vowelsSum);
    }
}
