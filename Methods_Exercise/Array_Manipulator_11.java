import java.util.Arrays;
import java.util.Scanner;

public class Array_Manipulator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            boolean isEven = input.contains("even");

            switch (commands[0]) {
                case "exchange":
                    numbers = exchangeArrayByIndex(numbers, commands);
                    break;
                case "max":
                    if (isEven) {
                        printMaxEven(numbers, commands);
                    } else {
                        printMaxOdd(numbers, commands);
                    }
                    break;
                case "min":
                    if (isEven) {
                        printMinEven(numbers, commands);
                    } else {
                        printMinOdd(numbers, commands);
                    }
                    break;
                case "first":
                    if (isEven) {
                        printFirstEvenNumbers(numbers, commands);
                    } else {
                        printFirstOddNumbers(numbers, commands);
                    }
                    break;
                case "last":
                    if (isEven) {
                        printLastEvenNumbers(numbers, commands);
                    } else {
                        printLastOddNumbers(numbers, commands);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        printArray(numbers);
    }

    // Разместване на масива след определен индекс, който се подава в командата;
    // Връща масивът с разменени индекси
    private static int[] exchangeArrayByIndex(int[] numbers, String[] commands) {
        int index = Integer.parseInt(commands[1]);
        int[] temp = new int[numbers.length];

        if (index <= numbers.length - 1 && index >= 0) {
            for (int i = 0; i <= index; i++) {
                temp[temp.length - 1 - index + i] = numbers[i];
            }
            for (int startIndex = 0; startIndex < temp.length - 1 - index; startIndex++) {
                temp[startIndex] = numbers[index + 1 + startIndex];
            }
            return temp;
        } else {
            System.out.println("Invalid index");
        }
        return numbers;
    }

    // Принтиране на индекса на най-голямото четно число
    private static void printMaxEven(int[] numbers, String[] commands) {
        int index = getMax(numbers, commands);
        printIndex(index);
    }

    // Принтиране на индекса на най-голямото нечетно число
    private static void printMaxOdd(int[] numbers, String[] commands) {
        int index = getMax(numbers, commands);
        printIndex(index);
    }

    // Проверка за индекса на най-голямото не/четно число в масива
    private static int getMax(int[] numbers, String[] commands) {
        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            boolean isGreaterThanMax = numbers[i] >= max;
            if (commands[1].equals("even")) {
                if (isGreaterThanMax && numbers[i] % 2 == 0) {
                    max = numbers[i];
                    index = i;
                }
            } else if (commands[1].equals("odd")) {
                if (isGreaterThanMax && numbers[i] % 2 != 0) {
                    max = numbers[i];
                    index = i;
                }
            }
        }
        return index;
    }

    // Принтиране на индекса на най-малкото четно число
    private static void printMinEven(int[] numbers, String[] commands) {
        int index = getMin(numbers, commands);
        printIndex(index);
    }

    // Принтиране на индекса на най-малкото нечетно число
    private static void printMinOdd(int[] numbers, String[] commands) {
        int index = getMin(numbers, commands);
        printIndex(index);
    }

    // Проверка за индекса на най-малкото не/четно число в масива
    private static int getMin(int[] numbers, String[] commands) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            boolean isSmallerThanMin = numbers[i] <= min;
            if (commands[1].equals("even")) {
                if (isSmallerThanMin && numbers[i] % 2 == 0) {
                    min = numbers[i];
                    index = i;
                }
            } else if (commands[1].equals("odd")) {
                if (isSmallerThanMin && numbers[i] % 2 != 0) {
                    min = numbers[i];
                    index = i;
                }
            }
        }
        return index;
    }

    // Метод, който принтира индекс на най-малкото/голямо не/четно число от масива
    // Ако не е намерено съвпадение, индексът ще остане - 1 и ще се принтира съобщението
    private static void printIndex(int index) {
        if (index > -1) {
            System.out.println(index);
        } else {
            System.out.println("No matches");
        }
    }

    // Принтиране на първите n четни числа
    private static void printFirstEvenNumbers(int[] numbers, String[] commands) {
        String output = getFirstNumbers(numbers, commands);
        printOutput(output, commands);
    }

    // Принтиране на първите n нечетни числа
    private static void printFirstOddNumbers(int[] numbers, String[] commands) {
        String output = getFirstNumbers(numbers, commands);
        printOutput(output, commands);
    }

    // Получаване на първите n не/четни числа от масива
    private static String getFirstNumbers(int[] numbers, String[] commands) {
        int count = Integer.parseInt(commands[1]);
        int counterOfMatchesFound = 0;
        StringBuilder builder = new StringBuilder();

        for (int number : numbers) {
            if (count >= 0 && count <= numbers.length) {
                if (commands[2].equals("even")) {
                    if (number % 2 == 0) {
                        counterOfMatchesFound++;
                        builder.append(number).append(" ");
                    }
                } else if (commands[2].equals("odd")) {
                    if (number % 2 != 0) {
                        counterOfMatchesFound++;
                        builder.append(number).append(" ");
                    }
                }

                if (counterOfMatchesFound == count) {
                    break;
                }
            } else {
                return "Invalid count";
            }
        }
        return builder.toString();
    }

    // Принтиране на последните n четни числа
    private static void printLastEvenNumbers(int[] numbers, String[] commands) {
        String output = getLastNumbers(numbers, commands);
        printOutput(output, commands);
    }

    // Принтиране на последните n нечетни числа
    private static void printLastOddNumbers(int[] numbers, String[] commands) {
        String output = getLastNumbers(numbers, commands);
        printOutput(output, commands);
    }

    // Намиране на последните n не/четни числа в масива
    private static String getLastNumbers(int[] numbers, String[] commands) {
        int count = Integer.parseInt(commands[1]);
        StringBuilder builder = new StringBuilder();
        int counterOfMatchesFound = 0;

        if (count > numbers.length) {
            return "Invalid count";
        }
        
        if (count > 0) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (commands[2].equals("even")) {
                    if (numbers[i] % 2 == 0) {
                        builder.append(numbers[i]).append(" ");
                        counterOfMatchesFound++;
                    }
                } else if (commands[2].equals("odd")) {
                    if (numbers[i] % 2 != 0) {
                        builder.append(numbers[i]).append(" ");
                        counterOfMatchesFound++;
                    }
                }

                if (counterOfMatchesFound == count) {
                    break;
                }
            }
        }
        return builder.toString();
    }

    // Метод, който принтира според условията
    private static void printOutput(String output, String[] commands) {
        if (output.equals("Invalid count")) {
            System.out.println(output);
        } else if (output.length() <= 0) {
            System.out.printf("[]%n");
        } else {
            int[] array = Arrays.stream(output.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (commands[0].equals("first")) {
                printArray(array);
            } else {
                printArrayBackwards(array);
            }
        }
    }

    // Метод, който печата масива отпред назад
    private static void printArray(int[] numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.print(numbers[i]);
            } else {
                System.out.print(numbers[i] + ", ");
            }
        }
        System.out.printf("]%n");
    }

    // Метод, който печата масива отзад напред
    private static void printArrayBackwards(int[] numbers) {
        System.out.print("[");
        for (int j = numbers.length - 1; j >= 0; j--) {
            if (j == 0) {
                System.out.print(numbers[j]);
            } else {
                System.out.print(numbers[j] + ", ");
            }
        }
        System.out.printf("]%n");
    }
    
}
