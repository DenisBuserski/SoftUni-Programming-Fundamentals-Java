package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_19_February_2017_Part_I;

import java.util.Scanner;

public class Shockwave_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];


        String command;
        while (!"Here We Go".equals(command = scanner.nextLine())) {
            String[] coordinates = command.split("\\s+");
            int X1 = Integer.parseInt(coordinates[0]);
            int Y1 = Integer.parseInt(coordinates[1]);
            int X2 = Integer.parseInt(coordinates[2]);
            int Y2 = Integer.parseInt(coordinates[3]);

            move(matrix, X1, Y1, X2, Y2);

        }

        printMatrix(matrix);

    }

    private static void move(int[][] matrix, int X1, int Y1, int X2, int Y2) {
        for (int row = X1; row <= X2; row++) {
            for (int col = Y1; col <= Y2; col++) {
                matrix[row][col] += 1;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}