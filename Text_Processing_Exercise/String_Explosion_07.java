import java.util.Scanner;

public class String_Explosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);
            if (curr == '>') {
                sum += Integer.parseInt(String.valueOf(text.charAt(i + 1)));
            }
            if (sum > 0 && curr != '>') {
                text.deleteCharAt(i);
                i--;
                sum--;
            }
        }
        
        System.out.println(text.toString());
    }
}
