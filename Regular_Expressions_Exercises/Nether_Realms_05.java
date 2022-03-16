import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nether_Realms_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s*\\,+\\s*");

        Map<String, List<String>> allData = new TreeMap<>();

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

// 1.1!@2.2#$3.999%^0.01&*(0.22)?0.3/* , d0.3r0.2o0.1b0.0, k0.0rab0.02a0.5* , fr0002d0.2*/ 
// ===================================================== 1.1!@2.2#$3.999%^0.01&*(0.22)?0.3/* - 481 health, 15.66 damage 
// d0.3r0.2o0.1b0.0 - 423 health, 0.60 damage 
// fr0002d0.2*/ - 316 health, 2.20 damage 
// k0.0rab0.02a0.5* - 513 health, 1.04 damage
