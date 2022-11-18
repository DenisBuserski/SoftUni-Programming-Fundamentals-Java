import java.util.Arrays;
import java.util.Scanner;

public class Common_Elements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words1 = scanner.nextLine().split(" ");
        String[] words2 = scanner.nextLine().split(" ");

        for (String word2 : words2) {
            for (String word1 : words1) {
                if (word2.equals(word1)) {
                    System.out.print(word2 + " ");
                    break;
                }
            }
        }
        
    }
}
