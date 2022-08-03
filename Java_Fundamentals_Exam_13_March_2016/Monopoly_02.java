package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_13_March_2016;

import java.util.Scanner;

public class Monopoly_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int matrixRows = Integer.parseInt(input[0]);
        int matrixCols = Integer.parseInt(input[1]);

        int totalMoney = 50;
        int countOfHotels = 0;
        int totalTurns = 0;

        String[] matrix = readMatrix(scanner, matrixRows);

        boolean goingRight = true;

        for (int i = 0; i < matrixRows; i++) {

            if (goingRight) {
                for (int j = 0; j < matrixCols; j++) {

                    char currentElem = matrix[i].charAt(j);
                    switch (currentElem) {
                        case 'H':
                            countOfHotels++;
                            System.out.println(String.format("Bought a hotel for %s. Total hotels: %s.", totalMoney, countOfHotels));
                            totalMoney = 0;
                            break;
                        case 'J':
                            System.out.println(String.format("Gone to jail at turn %s.", totalTurns));
                            totalTurns += 2;
                            totalMoney += (countOfHotels * 10) * 2;
                            break;
                        case 'S':
                            int moneyToSpend = (i + 1) * (j + 1);
                            if (moneyToSpend > totalMoney) {
                                moneyToSpend = totalMoney;
                            } else {
                                moneyToSpend = moneyToSpend;
                            }
                            totalMoney -= moneyToSpend;
                            System.out.println(String.format("Spent %s money at the shop.", moneyToSpend));
                            break;
                    }

                    totalMoney += countOfHotels * 10;
                    totalTurns++;
                }

                goingRight = false;
            } else {
                for (int j = matrixCols - 1; j >= 0; j--) {

                    char currentElem = matrix[i].charAt(j);
                    switch (currentElem) {
                        case 'H':
                            countOfHotels++;
                            System.out.println(String.format("Bought a hotel for %s. Total hotels: %s.", totalMoney, countOfHotels));
                            totalMoney = 0;
                            break;
                        case 'J':
                            System.out.println(String.format("Gone to jail at turn %s.", totalTurns));
                            totalTurns += 2;
                            totalMoney += (countOfHotels * 10) * 2;
                            break;
                        case 'S':
                            int moneyToSpend = (i + 1) * (j + 1);
                            moneyToSpend = moneyToSpend > totalMoney ? totalMoney : moneyToSpend;
                            totalMoney -= moneyToSpend;
                            System.out.println(String.format("Spent %s money at the shop.", moneyToSpend));
                            break;
                    }

                    totalMoney += countOfHotels * 10;
                    totalTurns++;
                }

                goingRight = true;
            }
        }

        System.out.println(String.format("Turns %s", totalTurns));
        System.out.println(String.format("Money %s", totalMoney));
    }

    private static String[] readMatrix(Scanner scanner, int rows) {
        String[] result = new String[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = scanner.nextLine();
        }

        return result;
    }
}
