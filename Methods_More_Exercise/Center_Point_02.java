import java.util.Scanner;

public class Center_Point_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        if (first(x1, y1) >= second(x2, y2)) {
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            System.out.printf("(%d, %d)", x1, y1);
        }

    }

    private static int second(int x2, int y2) {
        return Math.abs(x2 * y2);
    }

    private static int first(int x1, int y1) {
        return Math.abs(x1 * y1);
    }
    
}
