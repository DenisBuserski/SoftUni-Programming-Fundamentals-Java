import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUni_Parking_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> register = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String name = input[1];

            if (command.equals("register")) {
                String licensePlateNumber = input[2];

                if (register.containsKey(name)) {
                    System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                } else {
                    register.put(name, licensePlateNumber);
                    System.out.printf("%s registered %s successfully%n", name, licensePlateNumber);
                }
            } else if (command.equals("unregister")) {

                if (!register.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    register.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }
        }

        for (Map.Entry<String, String> entry : register.entrySet()) {
            String name = entry.getKey();
            String licensePlateNumber = entry.getValue();
            System.out.printf("%s => %s%n", name, licensePlateNumber);
        }

    }
}
