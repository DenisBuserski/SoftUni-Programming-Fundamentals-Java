package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Retake_08_May_2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Royalism_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> royalists = new ArrayList<String>();
        ArrayList<String> nonRoyalists = new ArrayList<String>();

        int[] currentSum = new int[1];

        //SPLITTING THE INPUT LINE AND MAKING IT A LIST SO IT CAN BE STREAMED
        //THEN FOREACH-ING EVERY NAME IN IT
        for (String name : Arrays.asList(scanner.nextLine().split(" "))) {

            for (String character : Arrays.asList(name.split(""))) {
                currentSum[0] = (currentSum[0] + (int) character.charAt(0)) % 26;
            }

            if (currentSum[0] == 18) {
                royalists.add(name);
                //RESETTING THE SUM
                currentSum[0] = 0;
            } else {
                currentSum[0] = 0;
                //IF NOT, ADDING THE CURRENT NAME TO THE NON-ROYALIST COLLECTION
                nonRoyalists.add(name);
            }
        }

        //THE CHECK IF THE ROYALISTS ARE MORE OR EQUAL TO THE NON-ROYALISTS
        //CHECK FOR 0 IS FOR OPTIMIZATION, NOT NEEDED
        if(royalists.size() > 0 && royalists.size() >= nonRoyalists.size()) {
            //THE PRINTING IS DONE WITH PLACEHOLDERS, SEPARATED BY NEW LINE SYMBOL
            //FIRST THE ROYALISTS SIZE, THEN THE JOINED COLLECTION OF ROYALISTS, AND AT THE LAST LINE THE MESSAGE
            System.out.println(String.format("Royalists - %s\n%s\n%s", royalists.size(), String.join("\n", royalists), "All hail Royal!"));
        }
        else{
            //SAME PRINTING FORMAT
            System.out.println(String.format("%s\n%s", String.join("\n", nonRoyalists), "Royalism, Declined!"));
        }
    }
}
