package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_13_March_2016;

import java.util.*;

public class Arrange_Numbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> sortedNums = new TreeMap<String, String>();

        String[] input = scanner.nextLine().split(", ");

        for (String num : input) {
            String currentNum = "";

            for (int i = 0; i < num.length(); i++) {
                if (i != 0) {
                    currentNum += "-";
                }

                switch (num.charAt(i)) {
                    case '0':
                        currentNum += "zero";
                        break;
                    case '1':
                        currentNum += "one";
                        break;
                    case '2':
                        currentNum += "two";
                        break;
                    case '3':
                        currentNum += "three";
                        break;
                    case '4':
                        currentNum += "four";
                        break;
                    case '5':
                        currentNum += "five";
                        break;
                    case '6':
                        currentNum += "six";
                        break;
                    case '7':
                        currentNum += "seven";
                        break;
                    case '8':
                        currentNum += "eight";
                        break;
                    case '9':
                        currentNum += "nine";
                        break;
                }
            }

            if (sortedNums.containsKey(currentNum)) {
                String newValue = sortedNums.get(currentNum) + ", " + num;
                sortedNums.replace(currentNum, newValue);
            } else {
                sortedNums.put(currentNum, num);
            }

        }

        String output = String.join(", ", sortedNums.values());

        System.out.println(output);
    }
}
