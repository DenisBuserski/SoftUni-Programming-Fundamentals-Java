package ProgrammingFundamentalsFinalExamRetake03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int wordPairs = 0;
        List<String> wordsList = new ArrayList<>();
        List<String> mirrorWords = new ArrayList<>();

        String regex = "(?<start>[@|#])(?<text>[A-z]{3,})\\1{2}(?<text2>[A-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            wordPairs++;
            wordsList.add(matcher.group("text"));
            wordsList.add(matcher.group("text2"));
        }

        if (wordPairs == 0) {
            System.out.printf("No word pairs found!%n");
        } else {
            System.out.printf("%d word pairs found!%n", wordPairs);

            for (int index = 0; index <= wordsList.size() - 1; index++) {
                if (index % 2 != 0) {
                    StringBuilder reverse = new StringBuilder(wordsList.get(index));
                    String reversedWord = reverse.reverse().toString();

                    if (reversedWord.equals(wordsList.get(index - 1))) {
                        mirrorWords.add(wordsList.get(index - 1));
                        mirrorWords.add("<=>");
                        mirrorWords.add(wordsList.get(index));
                    }
                }
            }

            for (int index2 = 3; index2 <= mirrorWords.size() - 1; index2 += 4) {
                if (index2 < mirrorWords.size()) {
                    mirrorWords.add(index2, "@");
                }
            }
        }

        if (mirrorWords.isEmpty()) {
            System.out.printf("No mirror words!%n");
        } else {
            System.out.printf("The mirror words are:%n");
            System.out.print(mirrorWords.toString().replaceAll("[\\[\\],]", "").replaceAll("\\s@", ","));
        }
    }
}
