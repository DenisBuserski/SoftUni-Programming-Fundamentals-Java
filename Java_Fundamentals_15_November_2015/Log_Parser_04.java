package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_15_November_2015;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log_Parser_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(\"([\\w\\W\\s\\S]+?)\")(: )(\\[\"([\\W\\w\\s\\S]+?)\"\\])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        HashMap<String, HashMap<String, List<String>>> result = new HashMap<>();

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("END")) {
                break;
            }

            String projectName = "";
            String type = "";
            String message = "";
            matcher = pattern.matcher(input);

            while (matcher.find()) {
                switch (matcher.group(2)) {
                    case "Project":
                        projectName = matcher.group(5);
                        break;
                    case "Type":
                        type = matcher.group(5);
                        break;
                    case "Message":
                        message = matcher.group(5);
                        break;
                }
            }

            HashMap<String, List<String>> map;
            List<String> list;
            if (!result.containsKey(projectName)) {
                map = new HashMap<>();
                map.put("Critical", new ArrayList<String>());
                map.put("Warning", new ArrayList<String>());
                result.put(projectName, map);
            } else {
                map = result.get(projectName);
            }

            list = map.get(type);
            list.add(message);
        }

        scanner.close();
        List<Map.Entry<String, HashMap<String, List<String>>>> sorted = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, List<String>>> entry : result
                .entrySet()) {
            sorted.add(entry);
        }

        sorted.sort(new Comparator<Map.Entry<String, HashMap<String, List<String>>>>() {

            @Override
            public int compare(Map.Entry<String, HashMap<String, List<String>>> o1,
                               Map.Entry<String, HashMap<String, List<String>>> o2) {
                int totalO1 = o1.getValue().get("Critical").size()
                        + o1.getValue().get("Warning").size();
                int totalO2 = o2.getValue().get("Critical").size()
                        + o2.getValue().get("Warning").size();

                int cmp = Integer.compare(totalO2, totalO1);
                if (cmp == 0) {
                    cmp = o1.getKey().compareTo(o2.getKey());
                }

                return cmp;
            }

        });

        Comparator<String> listSorter = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int lengthO1 = o1.length();
                int lengthO2 = o2.length();

                int cmp = Integer.compare(lengthO1, lengthO2);
                if (cmp == 0) {
                    cmp = o1.compareTo(o2);
                }

                return cmp;
            }

        };

        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < sorted.size(); i++) {
            Map.Entry<String, HashMap<String, List<String>>> entry = sorted
                    .get(i);
            List<String> criticalList = entry.getValue().get("Critical");
            List<String> warningList = entry.getValue().get("Warning");

            int criticalCount = entry.getValue().get("Critical").size();
            int warningCount = entry.getValue().get("Warning").size();
            criticalList.sort(listSorter);
            warningList.sort(listSorter);

            bld.append(String.format("%s:\n", entry.getKey()));
            bld.append(String.format("Total Errors: %d\n", criticalCount
                    + warningCount));
            bld.append(String.format("Critical: %d\n", criticalCount));
            bld.append(String.format("Warnings: %d\n", warningCount));
            bld.append("Critical Messages:\n");
            if (criticalCount == 0) {
                bld.append("--->None\n");
            } else {
                for (int b = 0; b < criticalCount; b++) {
                    bld.append(String.format("--->%s\n", criticalList.get(b)));
                }
            }
            bld.append("Warning Messages:\n");
            if (warningCount == 0) {
                bld.append("--->None\n");
            } else {
                for (int b = 0; b < warningCount; b++) {
                    bld.append(String.format("--->%s\n", warningList.get(b)));
                }
            }

            if (i != sorted.size() - 1) {
                bld.append("\n");
            }
        }

        System.out.println(bld.toString());
    }
}
