package RegularExpressionsExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String encryptedMessage = scanner.nextLine();
            int countSpecialLetter = getSpecialLetters(encryptedMessage);
            String decryptedMessage = getDescryptedMessage(encryptedMessage, countSpecialLetter);

            //PQ@Alderaa1:30000!A!->20000
            String regex = "@(?<planet>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attack>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if(matcher.find()) {
                String planet = matcher.group("planet");
                String typeAttack = matcher.group("attack");
                if(typeAttack.equals("A")){
                    attacked.add(planet);
                } else if (typeAttack.equals("D")) {
                    destroyed.add(planet);
                }
            }

        }

        printOutput(attacked, destroyed);
    }

    private static void printOutput(List<String> attacked, List<String> destroyed) {
        Collections.sort(attacked);
        Collections.sort(destroyed);

        System.out.println("Attacked planets: " + attacked.size());
        if(!attacked.isEmpty()) {
            attacked.forEach(p -> System.out.println("-> " + p));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        if(!destroyed.isEmpty()) {
            destroyed.forEach(p -> System.out.println("-> " + p));
        }
    }

    private static String getDescryptedMessage(String encryptedMessage, int reducedValue) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int index = 0; index < encryptedMessage.length(); index++) {
            char currentSymbol = encryptedMessage.charAt(index);
            decryptedMessage.append((char)(currentSymbol - reducedValue));

        }

        return decryptedMessage.toString();
    }

    private static int getSpecialLetters(String encryptedMessage) {
        //SsTtAaRr -> броят на тези букви
        int count = 0;
        String regexSpecialLetter = "[SsTtAaRr]";
        Pattern pattern = Pattern.compile(regexSpecialLetter);
        Matcher matcher = pattern.matcher(encryptedMessage);

        while(matcher.find()){
            count++;
        }

        return count;
    }
}
