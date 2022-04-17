import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballsNumber = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int maxSnow = Integer.MIN_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int maxQuality = Integer.MIN_VALUE;
        double snowballValue = 0;
        int snowballSnow = 0;
        int snowballTime = 0;
        int snowballQuality = 0;

        for (int i = 1; i <= snowballsNumber; i++) {
            snowballSnow = Integer.parseInt(scanner.nextLine());
            snowballTime = Integer.parseInt(scanner.nextLine());
            snowballQuality = Integer.parseInt(scanner.nextLine());

            snowballValue = Math.pow((snowballSnow / snowballTime), snowballQuality);

            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, maxValue, maxQuality);
    }
}
