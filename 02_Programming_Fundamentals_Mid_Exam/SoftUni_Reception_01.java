import java.util.Scanner;

public class SoftUni_Reception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = Integer.parseInt(scanner.nextLine());
        int employee2 = Integer.parseInt(scanner.nextLine());
        int employee3 = Integer.parseInt(scanner.nextLine());
        int totalPeople = Integer.parseInt(scanner.nextLine());

        // Every 4th hour 1 hour break -> +1 hour
        int totalWorkForOneHour = employee1 + employee2 + employee3;
        int time = 0;

        while (totalPeople > 0) {
            totalPeople -= totalWorkForOneHour;
            time++;
            if (time % 4 == 0) {
                time++;
            }
        }

        System.out.printf("Time needed: %dh.", time);
    }
}
