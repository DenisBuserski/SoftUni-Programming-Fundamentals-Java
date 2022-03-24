package DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // Прочитане броя на числата

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine(); // Прочитане на всички числа на 1 ред като текст

            for (int j = 0; j <= input.length(); j++) { // Разглеждаме числата като текст
                int spaceBetweenNumbers = 0;

                char space = input.charAt(j); // Прочитаме всеки знак от текста по отделно

                if (space == 32) {
                    spaceBetweenNumbers = j;
                    int secondFirstLetter = spaceBetweenNumbers + 1;
                    String firstNum = "";
                    String secondNum = "";

                    for (int x = 0; x <= spaceBetweenNumbers - 1; x++) {
                        firstNum += input.charAt(x);
                    }
                    for (int z = secondFirstLetter; z < input.length(); z++) {
                        secondNum += input.charAt(z);
                    }

                    String max = ""; // Максималното число като текст
                    long first = Long.parseLong(firstNum);
                    long second = Long.parseLong(secondNum);
                    long maxNum = 0;

                    if (first < 0 && second < 0) {
                        maxNum = Math.min(first, second);
                        if (maxNum == first) {
                            max = secondNum;
                        } else {
                            max = firstNum;
                        }
                    } else if (first < 0 && second > 0) {
                        max = secondNum;
                    } else if (first > 0 && second < 0) {
                        max = firstNum;
                    } else {
                        maxNum = Math.max(first, second);
                        if (maxNum == first) {
                            max = firstNum;
                        } else {
                            max = secondNum;
                        }
                    }

                    int result = 0;
                    long maxNumber = Long.parseLong(max);
                    if (maxNumber < 0) {
                        maxNumber *= -1;
                    }
                    while (maxNumber > 0) {
                        result += maxNumber % 10;
                        maxNumber /= 10;
                    }
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
