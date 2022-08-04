package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_4_October_2015;

import java.util.*;

public class Dragon_Army_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> dragonInfo = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage = check(input[2], 45);
            int health = check(input[3], 250);
            int armor = check(input[4], 10);

            if (!dragonInfo.containsKey(type)) {
                dragonInfo.put(type, new TreeMap<>());
                dragonInfo.get(type).put(name, new ArrayList<>());
                dragonInfo.get(type).get(name).add(0, damage);
                dragonInfo.get(type).get(name).add(1, health);
                dragonInfo.get(type).get(name).add(2, armor);
            } else {

                if (!dragonInfo.get(type).containsKey(name)) {
                    dragonInfo.get(type).put(name, new ArrayList<>());
                    dragonInfo.get(type).get(name).add(0, damage);
                    dragonInfo.get(type).get(name).add(1, health);
                    dragonInfo.get(type).get(name).add(2, armor);
                } else {
                    dragonInfo.get(type).get(name).clear();
                    dragonInfo.get(type).get(name).add(0, damage);
                    dragonInfo.get(type).get(name).add(1, health);
                    dragonInfo.get(type).get(name).add(2, armor);
                }
            }


        }

        for (Map.Entry<String, Map<String, List<Integer>>> entry : dragonInfo.entrySet()) {

            double[] average = calculateAverage(entry.getValue());
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", entry.getKey(), average[0], average[1], average[2]);

            for (Map.Entry<String, List<Integer>> entry2 : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        entry2.getKey(),
                        entry2.getValue().get(0),
                        entry2.getValue().get(1),
                        entry2.getValue().get(2));


            }
        }
    }

        private static double[] calculateAverage (Map < String,List<Integer>>map){
            double totalEntries = map.size();
            int totalDamage = 0;
            int totalHealth = 0;
            int totalArmor = 0;

            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                totalDamage += entry.getValue().get(0);
                totalHealth += entry.getValue().get(1);
                totalArmor += entry.getValue().get(2);
            }

            return new double[]{
                    totalDamage / totalEntries,
                    totalHealth / totalEntries,
                    totalArmor / totalEntries
            };
        }


        private static int check (String input,int defaultValue){
            int value = 0;
            if (input.equals("null")) {
                value = defaultValue;
            } else {
                value = Integer.parseInt(input);
            }
            return value;
        }
}