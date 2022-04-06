package ProgrammingFundamentalsMidExam0501;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lecturesCount = Double.parseDouble(scanner.nextLine());
        double additionalBonus = Double.parseDouble(scanner.nextLine());
        double maxBonus = 0;
        double studentAttendances = 0;

        for (int i = 1; i <= studentsCount; i++) {
            int attendancesForStudent = Integer.parseInt(scanner.nextLine());
            double totalBonus = 0;
            totalBonus = (attendancesForStudent / lecturesCount) * (5 + additionalBonus);

            if (totalBonus >= maxBonus) {
                maxBonus = totalBonus;
                studentAttendances = attendancesForStudent;
            }
        }

        System.out.printf("Max Bonus: %d.%n", (int) Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.", (int) studentAttendances);

    }
}
// {total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})