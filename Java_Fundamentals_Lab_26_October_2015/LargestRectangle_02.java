package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Lab_26_October_2015;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestRectangle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String[]> matrix = new ArrayList<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {

            String[] tokens = input.replace(',', ' ').trim().split(" ");
            String[] matrixRow = new String[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                matrixRow[i] = tokens[i];
            }
            matrix.add(matrixRow);

        }

        int maxRectangleArea = 0;
        int[] maxRectangleAreaAxes = new int[4];

        //get through all possible rectangles and if they are larger than previous found save its position
        for (int y1 = 0; y1 < matrix.size(); y1++) {
            for (int x1 = 0; x1 < matrix.get(y1).length; x1++) {
                for (int y2 = y1; y2 < matrix.size(); y2++) {
                    for (int x2 = x1; x2 < matrix.get(y2).length; x2++) {

                        int[] rectanleAreaAxes = new int[] {x1, y1, x2, y2};
                        int rectangleArea = (x2 + 1 - x1 + 1) * (y2 + 1 - y1 + 1);

                        if (isValidRectangle(rectanleAreaAxes[0], rectanleAreaAxes[1], rectanleAreaAxes[2], rectanleAreaAxes[3], matrix) && maxRectangleArea < rectangleArea) {
                            maxRectangleArea = rectangleArea;
                            maxRectangleAreaAxes = rectanleAreaAxes;
                        }

                    }
                }
            }
        }


        markCells(maxRectangleAreaAxes, matrix);

        //print
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).length; j++) {
                System.out.printf("%5s", matrix.get(i)[j]);
            }
            System.out.println();
        }


    }

    //check if rectangle is valid (all cells have same value)
    static boolean isValidRectangle(int x1, int y1, int x2, int y2, ArrayList<String[]> matrix) {

        String stringToCompare = matrix.get(y1)[x1];

        for (int i = x1; i <= x2; i++) {
            if (!matrix.get(y1)[i].equals(stringToCompare) || !matrix.get(y2)[i].equals(stringToCompare))
                return false;
        }

        for (int i = y1 + 1; i < y2; i++) {
            if (!matrix.get(i)[x1].equals(stringToCompare) || !matrix.get(i)[x2].equals(stringToCompare))
                return false;
        }

        return true;
    }

    //add square brackets to cells that are the largest reactangle
    static void markCells(int[] markedCellRectPos, ArrayList<String[]> matrix) {
        int x1, x2, y1, y2;

        x1 = markedCellRectPos[0];
        x2 = markedCellRectPos[2];
        y1 = markedCellRectPos[1];
        y2 = markedCellRectPos[3];

        for (int i = x1; i <= x2; i++) {
            matrix.get(y1)[i] = "[" + matrix.get(y1)[i] + "]";

            if(y2 != y1)
                matrix.get(y2)[i] = "[" + matrix.get(y2)[i] + "]";
        }

        for (int i = y1 + 1; i < y2; i++) {
            matrix.get(i)[x1] = "[" + matrix.get(i)[x1] + "]";

            if(x2 != x1)
                matrix.get(i)[x2] = "[" + matrix.get(i)[x2] + "]";
        }
    }
}



