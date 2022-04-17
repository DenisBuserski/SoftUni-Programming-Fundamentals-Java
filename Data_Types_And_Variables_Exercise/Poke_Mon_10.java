package DataTypesAndVariablesExercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int originalPokePower = pokePower;
        int targetCount = 0;

        while (pokePower >= distance) {
            pokePower -= distance;
            targetCount++;

            if (pokePower == originalPokePower / 2) {
                if (exhaustionFactor > 0) {
                    pokePower /= exhaustionFactor;

                }
            }


        }

        System.out.println(pokePower);
        System.out.println(targetCount);







    }
}
