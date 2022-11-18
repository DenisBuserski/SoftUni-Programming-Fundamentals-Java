import java.util.Scanner;

public class Zig_Zag_Arrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] line1 = new String[n];
        String[] line2 = new String[n];

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String firstElement = array[0];
            String secondElement = array[1];

            if ((i + 1) % 2 == 0) {
                line2[i] = firstElement;
                line1[i] = secondElement;
            } else {
                line1[i] = firstElement;
                line2[i] = secondElement;
            }
        }
        
        System.out.println(String.join(" ", line1));
        System.out.println(String.join(" ", line2));
    }
}
