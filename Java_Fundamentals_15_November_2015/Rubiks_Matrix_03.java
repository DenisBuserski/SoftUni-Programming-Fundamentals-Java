package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_15_November_2015;

import java.util.Scanner;

public class Rubiks_Matrix_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] rubikMatrix = new int[rows][cols];


        for (int index = 0; index < rows * cols; index++) {
            rubikMatrix[index / cols][index % cols] = index + 1;
        }

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= N; i++) {
            String[] commandArgs = scanner.nextLine().split(" ");
            int arrayIndex = Integer.parseInt(commandArgs[0]);
            int moves = Integer.parseInt(commandArgs[2]);

            switch (commandArgs[1]) {
                case "left":
                    moveRow(rubikMatrix, arrayIndex, moves % cols, cols);
                    break;
                case "right":
                    moveRow(rubikMatrix, arrayIndex, cols - moves % cols, cols);
                    break;
                case "up":
                    moveCol(rubikMatrix, arrayIndex, moves % rows, rows);
                    break;
                case "down":
                    moveCol(rubikMatrix, arrayIndex, rows - moves % rows, rows);
                    break;
            }

        }

        rearrange(rubikMatrix, rows, cols);
    }

    private static void moveRow(int[][] matrix, int row, int moves, int cols) {
        int[] tempArr = new int[cols];
        for (int index = 0; index < cols; index++) {
            tempArr[index] = matrix[row][(index + moves) % cols];
        }

        System.arraycopy(tempArr, 0, matrix[row], 0, tempArr.length);
    }

    private static void moveCol(int[][] matrix, int col, int moves, int rows) {
        int[] tempArr = new int[rows];
        for (int index = 0; index < rows; index++) {
            tempArr[index] = matrix[(index + moves) % matrix.length][col];
        }

        for (int i = 0; i < tempArr.length; i++) {
            matrix[i][col] = tempArr[i];
        }
    }

    private static void rearrange(int[][] matrix, int rows, int cols) {
        int expected = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != expected) {
                    for (int x = 0; x < rows; x++) {
                        for (int y = 0; y < cols; y++) {
                            if (matrix[x][y] == expected) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n", row, col, x, y);
                                int temp = matrix[x][y];
                                matrix[x][y] = matrix[row][col];
                                matrix[row][col] = temp;
                            }
                        }
                    }
                } else {
                    System.out.println("No swap required");
                }
                expected++;
            }
        }
    }
}
