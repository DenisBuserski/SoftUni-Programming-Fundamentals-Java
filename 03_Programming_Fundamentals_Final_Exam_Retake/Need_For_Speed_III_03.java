import java.util.*;

public class Need_For_Speed_III_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> cars = new HashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String currentCar = scanner.nextLine();
            String [] currentCarArray = currentCar.split("\\|");
            String currentCarModel = currentCarArray[0];
            int mileage = Integer.parseInt(currentCarArray[1]);
            int fuel = Integer.parseInt(currentCarArray[2]);

            cars.put(currentCarModel, Arrays.asList(mileage, fuel));
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String [] commandArray = command.split(" : ");
            String commandName = commandArray[0];
            String car = commandArray[1];

            switch (commandName) {
                case "Drive":
                    int distance = Integer.parseInt(commandArray[2]);
                    int fuel = Integer.parseInt(commandArray[3]);

                    if (fuel <= cars.get(car).get(1)) {
                        int newDistance = cars.get(car).get(0) + distance;
                        int newFuel = cars.get(car).get(1) - fuel;
                        cars.put(car, Arrays.asList(newDistance, newFuel));
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if (cars.get(car).get(0) > 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            cars.remove(car);
                        }
                    } else {
                        System.out.printf("Not enough fuel to make that ride%n");
                    }
                    break;
                case "Refuel":
                    int fuelForRefuel = Integer.parseInt(commandArray[2]);
                    int newFuel = cars.get(car).get(1) + fuelForRefuel;

                    if (newFuel <= 75) {
                        cars.get(car).set(1, newFuel);
                        System.out.printf("%s refueled with %d liters%n", car, fuelForRefuel);
                    } else {
                        int fuel1 = (newFuel - 75) -fuelForRefuel;
                        System.out.printf("%s refueled with %d liters%n", car, Math.abs(fuel1));
                        cars.get(car).set(1, 75);
                    }
                    break;
                case "Revert":
                    int km = Integer.parseInt(commandArray[2]);
                    int newKm = cars.get(car).get(0) - km;

                    if (newKm < 10000) {
                        cars.get(car).set(0, 10000);
                    } else {
                        cars.get(car).set(0, newKm);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                    }
                    break;
            }
            
            command = scanner.nextLine();
        }

        cars
            .entrySet()
            .stream()
            .sorted((a, b) -> {
                int result = b.getValue().get(0).compareTo(a.getValue().get(0));
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;
            })
            .forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", 
                                                entry.getKey(), 
                                                entry.getValue().get(0), 
                                                entry.getValue().get(1)));

    }
}
