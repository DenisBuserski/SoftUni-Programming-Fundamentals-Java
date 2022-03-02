import java.util.Scanner;

public class 01_Black_Flag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double target = Double.parseDouble(scanner.nextLine());

        double gatheredPlunder = 0;
        for (int i = 1; i <= days; i++) {
            gatheredPlunder += dailyPlunder;

            if (i % 3 == 0) {
                gatheredPlunder += 0.5 * dailyPlunder;
            }
            if (i % 5 == 0) {
                gatheredPlunder = 0.7 * gatheredPlunder;
            }
        }

        if (gatheredPlunder >= target) {
            System.out.printf("Ahoy! %.2f plunder gained.", gatheredPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (gatheredPlunder / target) * 100);
        }

    }
}
