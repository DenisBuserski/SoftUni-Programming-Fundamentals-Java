package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Retake_08_May_2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Royal_Flush_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> ranks = Arrays.asList(new String[]{"10", "J", "Q", "K", "A"});
        List<String> suits = Arrays.asList(new String[]{"c", "d", "h", "s"});

        String[] outputSuits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};

        ArrayList<String> totalCards = new ArrayList<>();

        String stringPattern = "(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)";
        Pattern regexPattern = Pattern.compile(stringPattern);
        int royalFlushes = 0;
        String totalString = "";

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            totalString += scanner.nextLine();
        }

        Matcher totalMatches = regexPattern.matcher(totalString);

        TreeMap<String, ArrayList<String>> currentCombinations = new TreeMap<>();

        while (totalMatches.find()) {
            String currentRank = totalMatches.group(1);
            String currentSuit = totalMatches.group(2);

            if (!currentCombinations.containsKey(currentSuit)) {
                currentCombinations.put(currentSuit, new ArrayList<String>());
            }

            if (currentCombinations.get(currentSuit).size() == 0) {

                if (ranks.indexOf(currentRank) == 0) {
                    currentCombinations.get(currentSuit).add(currentRank);
                }
            } else {

                if (ranks.indexOf(currentRank) == currentCombinations.get(currentSuit).size()) {
                    currentCombinations.get(currentSuit).add(currentRank);
                } else {
                    currentCombinations.get(currentSuit).clear();

                    //HOWEVER ! WE CHECK IF THE CURRENT RANK IS 10, AND IF IT IS WE ADD IT TO THE NEW COMBINATION
                    //EXPLANATION:
                    //THE CASE 10s10sJsQsKsAs
                    //THE FIRST COMBINATION IS 10s
                    //THE NEXT CARD IT MEETS IS 10s, IT DOESNT FOLLOW THE RANK ORDER SO WE RESET THE COMBINATION
                    //BUT IF WE DONT ADD THE NEW 10s, THE COMBINATION AFTERWARDS WILL FAIL TO COMPLETE
                    //WHICH IS WRONG
                    if (ranks.indexOf(currentRank) == 0) {
                        currentCombinations.get(currentSuit).add(currentRank);
                    }
                }
            }

            //IF THE CURRENT COMBINATION SIZE IS 5 ( IT HAS COMPLETED) WE PRINT IT AND WE RESET IT
            if (currentCombinations.get(currentSuit).size() == 5) {
                //WE USE THE INDEX OF FROM THE SUITS ARRAY TO PRINT THE OUTPUT SUITS
                //THE ELEMENTS ARE PLACED AT THE SAME POSITIONS SO "s" in the SUITS ARRAY == "Spades" IN THE OUTPUTSUITS ARRAY
                System.out.println(String.format("Royal Flush Found - %s", outputSuits[suits.indexOf(currentSuit)]));
                currentCombinations.get(currentSuit).clear();
                //INCREMENTING THE ROYAL FLUSH COUNTER
                royalFlushes++;
            }
        }

        System.out.println(String.format("Royal's Royal Flushes - %s.", royalFlushes));
    }
}
