import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Legendary_Farming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new TreeMap<>();
        Map<String, Integer> trash = new TreeMap<>();

        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        String winner = " ";

        String [] input = scanner.nextLine().toLowerCase().split(" ");

        loop:
        while (/*!input[0].equals(" ")*/ true) {

            for (int i = 0; i < input.length; i++) {
                int valueItem = Integer.parseInt(input[i]);
                String item = input[i + 1];
                i++;
                
                if (item.equals("shards") || item.equals("fragments") || item.equals("motes")) {
                    int oldValueOfItem = items.get(item);
                    items.put(item, oldValueOfItem + valueItem);
                    
                    if (items.get(item) >= 250) {
                        winner = item;
                        int lastValue = items.get(item);
                        items.put(item, lastValue - 250);
                        break loop;
                    }
                } else {
                    if (!trash.containsKey(item)) {
                        trash.put(item, valueItem);
                    } else {
                        int oldValueOfItem = trash.get(item);
                        trash.put(item, oldValueOfItem + valueItem);
                    }
                }
            }
            
            input = scanner.nextLine().toLowerCase().split(" ");
        }


        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        items
            .entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        trash
            .entrySet()
            .stream()
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

    }
}
