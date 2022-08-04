package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_15_November_2015;

import java.util.Scanner;

public class Softuni_Palatka_Conf_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        int totalTentsAndRooms = 0;
        int totalFood = 0;

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int quantity = Integer.parseInt(input[1]);
            String type = input[2];

            if (command.equals("tents")) {
                if (type.equals("normal")) {
                    totalTentsAndRooms += 2 * quantity;
                } else if (type.equals("firstClass")) {
                    totalTentsAndRooms += 3 * quantity;
                }
            } else if (command.equals("food")) {
                if (type.equals("musaka")) {
                    totalFood += 2 * quantity;
                }
            } else if (command.equals("rooms")) {
                if (type.equals("single")) {
                    totalTentsAndRooms += quantity;
                } else if (type.equals("double")) {
                    totalTentsAndRooms += 2 * quantity;
                } else if (type.equals("triple")) {
                    totalTentsAndRooms += 3 * quantity;
                }
            }
        }

        if (totalTentsAndRooms - people >= 0) {
            System.out.println("Everyone is happy and sleeping well. Beds left: " + (totalTentsAndRooms - people));
        } else if (totalTentsAndRooms - people < 0) {
            System.out.println("Some people are freezing cold. Beds needed: " + (people - totalTentsAndRooms));
        }

        if (totalFood - people >= 0) {
            System.out.println("Nobody left hungry. Meals left: " + (totalFood - people));
        } else if (totalFood - people < 0) {
            System.out.println("People are starving. Meals needed: " + (people - totalFood));
        }

    }
}
