import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class List_Manipulation_Basics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map((Integer::parseInt)).collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }

            String [] tokens = line.split(" ");

            switch (tokens[0]) {
                case "Add":
                    int numberToadd = Integer.parseInt(tokens[1]);
                    numbers.add(numberToadd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int indexToInsert =Integer.parseInt(tokens[2]);
                    numbers.add(indexToInsert, numberToInsert);
                    break;
            }
        }
        
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
