package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_28_February_2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Collect_Resources_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputResources = scanner.nextLine().split(" ");

        int numberOfPaths = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> quantities = new ArrayList<>();

        int sumedResources = 0;

        for (int i = 0; i < numberOfPaths; i++) {
            String[] arguments = scanner.nextLine().split("\\s+");
            int startIndex = Integer.parseInt(arguments[0]);
            int step = Integer.parseInt(arguments[1]);
            String[] currentResources = inputResources.clone();

            for (int j = startIndex; true; j = (j + step) % currentResources.length) {

                String[] resource = currentResources[j].split("_");
                if(resource[0].contains("@")){
                    break;
                }

                if(resource[0].equals("wood") || resource[0].equals("gold") || resource[0].equals("stone") || resource[0].equals("food")){
                    if(resource.length < 2){
                        currentResources[j] = "@" + currentResources[j];
                        sumedResources += 1;
                    }
                    else{
                        currentResources[j] = "@" + currentResources[j];
                        sumedResources += Integer.parseInt(resource[1]);
                    }
                }
            }

            quantities.add(sumedResources);
            sumedResources = 0;
        }

        System.out.println(Collections.max(quantities));
    }
}
