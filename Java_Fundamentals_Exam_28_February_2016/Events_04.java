package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_28_February_2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Events_04 {
    static int num = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> data = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();

            String regex = "^#{1}(?<person>[A-z]+):\\s*@(?<location>[A-z]+)\\s*(?<time>[0-1][0-9]:[0-5][0-9]|[2][0-3]:[0-5][0-9])$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("person");
                String location = matcher.group("location");
                String time = matcher.group("time");

                if (!data.containsKey(location)) {
                    data.put(location, new TreeMap<>());
                    data.get(location).put(name, new ArrayList<>());
                    data.get(location).get(name).add(time);
                } else {

                    if (!data.get(location).containsKey(name)) {
                        data.get(location).put(name, new ArrayList<>());
                        data.get(location).get(name).add(time);
                    } else {
                        data.get(location).get(name).add(time);
                    }
                }
            }
        }


        String[] locations = scanner.nextLine().split(",");
        Arrays.sort(locations);
        for (String location : locations) {

            if (data.containsKey(location)) {
                System.out.println(location + ":");
                Map<String, List<String>> entry = data.get(location);
                entry.entrySet().stream().forEach(e -> {

                    String name = e.getKey();
                    List<String> times = e.getValue();
                    Collections.sort(times);
                    System.out.println(num + ". " + name + " -> " + times.toString().replaceAll("[\\[\\]]", ""));
                    num++;
                });
                num = 1;
            }
        }


    }
}
