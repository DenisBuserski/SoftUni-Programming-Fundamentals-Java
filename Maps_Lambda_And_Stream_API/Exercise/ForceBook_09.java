import java.util.*;

public class ForceBook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, List<String>> webSide = new TreeMap<>();

        while (!line.equals("Lumpawaroo")) {
            String[] command;
            String operand = "";

            if (line.contains("|")) {
                command = line.split("\\s+\\|\\s+");
                operand = "|";
            } else {
                command = line.split("\\s+->\\s+");
                operand = "->";
            }

            switch (operand) {
                case "|":
                    String side = command[0];
                    String name = command[1];
                    boolean check = false;

                    for (Map.Entry<String, List<String>> current : webSide.entrySet()) {
                        if (current.getValue().contains(name)) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        if (!webSide.containsKey(side)) {
                            webSide.put(side, new ArrayList<>());
                            webSide.get(side).add(name);
                        } else if (webSide.containsKey(side) && !webSide.get(side).contains(name)) {
                            webSide.get(side).add(name);
                        }
                    }
                    break;
                case "->":
                    String user = command[0];
                    String whichSide = command[1];

                    for (Map.Entry<String, List<String>> current : webSide.entrySet()) {
                        if (current.getValue().contains(user)) {
                            webSide.get(current.getKey()).remove(user);
                            break;
                        }
                    }
                    if (!webSide.containsKey(whichSide)) {
                        webSide.put(whichSide, new ArrayList<>());
                        webSide.get(whichSide).add(user);
                        System.out.printf("%s joins the %s side!%n", user, whichSide);
                    } else if (webSide.containsKey(whichSide) && !webSide.get(whichSide).contains(user)) {
                        webSide.get(whichSide).add(user);
                        System.out.printf("%s joins the %s side!%n", user, whichSide);
                    }
                    break;
                default:
                    break;
            }

            line = scanner.nextLine();
        }

        webSide.entrySet()
                .stream()
                .filter(user -> user.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });
        
    }
}
