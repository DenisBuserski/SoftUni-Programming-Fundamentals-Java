import java.util.Scanner;

public class World_Tour_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stopsNew = new StringBuilder(stops);

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            String [] commandArray = command.split("\\:");
            switch (commandArray[0]) {
                case "Add Stop":
                    int addIndex = Integer.parseInt(commandArray[1]);
                    String addStop = commandArray[2];
                    if (addIndex >= 0 && addIndex < stopsNew.length()) {
                        stopsNew.insert(addIndex, addStop);
                    }
                    System.out.printf("%s%n", stopsNew);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int endIndex = Integer.parseInt(commandArray[2]);
                    if (startIndex >= 0 && endIndex < stopsNew.length()) {
                        stopsNew.delete(startIndex, endIndex + 1);
                    }
                    System.out.printf("%s%n", stopsNew);
                    break;
                case "Switch":
                    String oldString = commandArray[1];
                    String newString = commandArray[2];
                    if (stopsNew.toString().contains(oldString)) {
                        String switched = stopsNew.toString().replace(oldString, newString);
                        stopsNew.replace(0, stopsNew.length(), switched);
                    }
                    System.out.printf("%s%n", stopsNew);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s%n", stopsNew.toString());
    }
}
