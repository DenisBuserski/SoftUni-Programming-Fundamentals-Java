package RegularExpressionsExercises;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s*\\,+\\s*");

        Map<String, List<String>> allData = new TreeMap<>();
        //heroData.put(heroName, Arrays.asList(heroHP, heroMP));

        for (int i = 0; i <= inputArray.length - 1; i++) {
            String demonInfo = inputArray[i];

            String validRegex = "(?<valid>[^\\,\\s+]{1,})";
            Pattern validPattern = Pattern.compile(validRegex);
            Matcher validMatcher = validPattern.matcher(demonInfo);
            if (validMatcher.find()) {

                StringBuilder health = new StringBuilder();
                int healthRate = 0;
                String healthRegex = "(?<health>[^\\d\\+\\-\\*\\/\\.]+)";
                Pattern healthPattern = Pattern.compile(healthRegex);
                Matcher healthMatcher = healthPattern.matcher(demonInfo.trim());
                while (healthMatcher.find()) {
                    health.append(healthMatcher.group("health"));
                }
                for (int index = 0; index <= health.length() - 1; index++) {
                    int symbol = health.charAt(index);
                    healthRate += symbol;
                }

                List<String> baseDamage = new ArrayList<>();
                double damageRate = 0;
                String baseDamageRegex = "(?<damage>\\-*[0-9]+\\.*[0-9]*)";
                Pattern baseDamagePattern = Pattern.compile(baseDamageRegex);
                Matcher baseDamageMatcher = baseDamagePattern.matcher(demonInfo);
                while (baseDamageMatcher.find()) {
                    baseDamage.add(baseDamageMatcher.group("damage"));
                }
                for (int index = 0; index <= baseDamage.size() - 1; index++) {
                    double number = Double.parseDouble(baseDamage.get(index));
                    damageRate += number;
                }
                for (int index = 0; index <= demonInfo.length() - 1; index++) {
                    if (demonInfo.charAt(index) == '*') {
                        damageRate *= 2;
                    } else if (demonInfo.charAt(index) == '/') {
                        damageRate /= 2;
                    }
                }
                NumberFormat formatter = new DecimalFormat("#0.00");
                String newDamageRate = formatter.format(damageRate);
                String healthString = Integer.toString(healthRate);
                String damageString = newDamageRate;
                allData.put(demonInfo, Arrays.asList(healthString, damageString));
            }
        }
            allData.entrySet()
                    .forEach(e -> System.out.printf("%s - %s health, %s damage%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));



    }
}
