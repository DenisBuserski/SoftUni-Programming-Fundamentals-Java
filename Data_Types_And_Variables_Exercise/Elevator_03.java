package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNum = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());

        if (peopleNum <= elevatorCapacity) {
            System.out.println(1);
        }
        else if (peopleNum % elevatorCapacity == 0) {
            int a = peopleNum / elevatorCapacity;
            System.out.println(a);
        }
        else if (peopleNum % elevatorCapacity != 0) {
            int b = peopleNum / elevatorCapacity;
            System.out.println(b + 1);
        }
    }
}
