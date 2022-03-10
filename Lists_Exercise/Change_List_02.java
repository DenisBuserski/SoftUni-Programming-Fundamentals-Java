package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            if (command.equals("end")) {
                break;
            }

            String [] token = command.split(" ");
            String command1 = token[0];

            if (command1.equals("Delete")) {
                int element = Integer.parseInt(token[1]);
                for (int i = 0; i < numbers.size(); i++) {

                    if (numbers.get(i) == element) {
                        numbers.remove(i);

                    }
                }

            } else {
                int element = Integer.parseInt(token[1]);
                int index = Integer.parseInt(token[2]);

                numbers.add(index, element);


            }






            command = scanner.nextLine();
        }
        System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));



    }
}
