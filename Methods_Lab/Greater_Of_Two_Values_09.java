package MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String value1 = scanner.nextLine();
        String value2 = scanner.nextLine();

        switch (type) {
            case "int":
                getMaxInteger(type, value1, value2);
                break;
            case "char":
                getMaxChar(type, value1, value2);
                break;
            case "string":
                getMaxString(type, value1, value2);
                break;
        }
    }

    private static void getMaxInteger(String type, String value1, String value2) {
        int number1 = Integer.parseInt(value1);
        int number2 = Integer.parseInt(value2);
        if (number1 >= number2) {
            System.out.println(number1);
        } else {
            System.out.println(number2);
        }
    }
    private static void getMaxString(String type, String value1, String value2) {
        if (value1.compareTo(value2) >= 0) {
            System.out.println(value1);
        } else {
            System.out.println(value2);
        }
    }
    private static void getMaxChar(String type, String value1, String value2) {
        int charValue1 = value1.charAt(0);
        int charValue2 = value2.charAt(0);
        Math.max(charValue1, charValue2);
        if (charValue1 > charValue2) {
            System.out.println(value1);
        } else {
            System.out.println(value2);
        }
    }


}
