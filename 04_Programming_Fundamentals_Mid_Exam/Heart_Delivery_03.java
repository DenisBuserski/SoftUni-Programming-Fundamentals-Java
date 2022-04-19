package ProgrammingFundamentalsMidExam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String neighborhood = scanner.nextLine();
        List<Integer> neighborhoodList = Arrays.stream(neighborhood.split("@")).map(Integer::parseInt).collect(Collectors.toList());

        int index = 0;
        int lastIndex = 0;

        String command = scanner.nextLine();
        while (!command.equals("Love!")) {
            String[] commandArray = command.split("\\s+");
            int jumpLength = Integer.parseInt(commandArray[1]);
            index += jumpLength;

            if (index >= neighborhoodList.size()) {
                index = 0;
            }

            if (neighborhoodList.get(index) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            } else {
                int currentNeighborhood = neighborhoodList.get(index);
                neighborhoodList.set(index, currentNeighborhood - 2);
                if (neighborhoodList.get(index) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                }
            }


            lastIndex = index;
            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", lastIndex);

        int houseCount = 0;
        for (int i = 0; i <= neighborhoodList.size() - 1; i++) {
            int current = neighborhoodList.get(i);

            if (current > 0) {
                houseCount++;
            }
        }
        if (houseCount > 0) {
            System.out.printf("Cupid has failed %d places.%n", houseCount);
        } else if (houseCount == 0) {
            System.out.printf("Mission was successful.%n");
        }


    }
}
