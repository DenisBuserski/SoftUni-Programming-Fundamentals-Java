package MethodsLab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());

        printTriangle(height);
    }

    private static void printTriangle(int height) {
        printTopHalf(height);
        printBottomHalf(height);
    }

    private static void printTopHalf(int height) {
        for (int i = 1; i < height; i++) {
            printSingeLine(i);
        }
    }

    private static void printBottomHalf(int height) {
        for (int  i = height; i >= 1; i--) {
            printSingeLine(i);
        }

    }

    private static void printSingeLine(int length) {
        for (int i = 1; i <= length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
