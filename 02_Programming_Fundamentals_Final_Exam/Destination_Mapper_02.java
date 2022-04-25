import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Destination_Mapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destinations = scanner.nextLine();
        List<String> destinationsList = new ArrayList<>();

        String regex = "(?<one>[\\/|=])(?<match>[A-Z]{1}[A-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(destinations);
        int travelPoints = 0;

        while (matcher.find()) {
            destinationsList.add(matcher.group("match"));
            travelPoints += matcher.group("match").length();
        }

        System.out.print("Destinations: ");
        System.out.print(destinationsList.toString().replaceAll("[\\[\\]]", ""));
        System.out.println();
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
