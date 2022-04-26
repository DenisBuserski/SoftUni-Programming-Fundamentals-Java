package ProgrammingFundamentalsFinalExam05;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        //City
        //List<City>
        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        while (!userInput.equals("Sail")) {
            String[] cityData = userInput.split("\\|\\|");
            String cityName = cityData[0];
            int population = Integer.parseInt(cityData[1]);
            int gold = Integer.parseInt(cityData[2]);
            if (cities.containsKey(cityName)) {
                List<Integer> currentCityData = cities.get(cityName); // 0 -> people, 1 -> gold
                int currentCityPopulation = currentCityData.get(0);
                int currentCityGold = currentCityData.get(1);
                currentCityData.set(0, currentCityPopulation + population);
                currentCityData.set(1, currentCityGold + gold);
                cities.put(cityName, currentCityData);
            } else {
                cities.put(cityName, Arrays.asList(population, gold));
            }
            userInput = scanner.nextLine();
        }

        userInput = scanner.nextLine();

        while (!userInput.equals("End")) {
            String[] commandParts = userInput.split("=>");
            String commandName = commandParts[0];
            String cityName = commandParts[1];

            switch (commandName) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(commandParts[2]);
                    int goldStolen = Integer.parseInt(commandParts[3]);


                    int peopleBeforePlunder = cities.get(cityName).get(0);
                    int goldBeforePlunder = cities.get(cityName).get(1);

                    int remainingPeople = peopleBeforePlunder - peopleKilled;
                    int remainingGold = goldBeforePlunder - goldStolen;


                    if (remainingGold <= 0 || remainingPeople <= 0) {
                        if (remainingGold <= 0) {
                            goldStolen = goldBeforePlunder;
                        }
                        if (remainingPeople <= 0) {
                            peopleKilled = peopleBeforePlunder;
                        }
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldStolen, peopleKilled);
                        System.out.printf("%s has been wiped off the map!%n", cityName);
                        cities.remove(cityName);
                        break;
                    }
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldStolen, peopleKilled);
                    cities.put(cityName, Arrays.asList(remainingPeople, remainingGold));
                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(commandParts[2]);
                    if(goldProsper<0){
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }

                    int goldBeforeProsper = cities.get(cityName).get(1);
                    int goldAfterProsper = goldBeforeProsper + goldProsper;
                    cities.get(cityName).set(1, goldAfterProsper);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, cityName, goldAfterProsper);
                    break;
            }
            userInput = scanner.nextLine();
        }

        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());

        cities.entrySet().stream().sorted((left, right) -> {
            int result = right.getValue().get(1).compareTo(left.getValue().get(1));
            if(result == 0){
                result = left.getKey().compareTo(right.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));



    }
}
