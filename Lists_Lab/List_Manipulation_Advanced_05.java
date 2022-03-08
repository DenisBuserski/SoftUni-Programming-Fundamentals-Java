import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Advanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.equals("end")) {
                break;
            }

            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Contains":
                    int containedNumber = Integer.parseInt(tokens[1]);
                    if (numbers.contains(containedNumber)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = tokens[1];
                    if (evenOrOdd.equals("even")) { // Четни
                        for (Integer number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                    } else { 
                        for (Integer number : numbers) {
                            if (number % 2 == 1) {
                                System.out.print(number + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int number = Integer.parseInt(tokens[2]);
                    switch (condition) {
                        case "<":
                            for (Integer num1 : numbers) {
                                if (num1 < number) {
                                    System.out.print(num1 + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (Integer num1 : numbers) {
                                if (num1 > number) {
                                    System.out.print(num1 + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (Integer num1 : numbers) {
                                if (num1 <= number) {
                                    System.out.print(num1 + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (Integer num1 : numbers) {
                                if (num1 >= number) {
                                    System.out.print(num1 + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
