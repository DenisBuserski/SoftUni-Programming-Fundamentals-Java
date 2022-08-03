package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Exam_19_February_2017_Part_I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        ArrayDeque<ArrayDeque<Integer>> dequeList = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayDeque<Integer> waves = new ArrayDeque<>();
            Arrays.stream(input).boxed().forEach(waves::offer);
            dequeList.add(waves);
        }

        while (dequeList.peek() != null){
            ArrayDeque<Integer> current = dequeList.poll();
            Integer currentWave = current.poll();
            if (current.size() > 0){
                Integer nextWave = current.peek();
                if (currentWave >= nextWave ){
                    current = current.stream().filter(x -> x > currentWave).collect(Collectors.toCollection(ArrayDeque::new));
                    result.add(currentWave);
                    if (current.size() > 0) {
                        dequeList.offer(current);
                    }
                } else {
                    result.add(currentWave);
                    dequeList.offer(current);
                }
            } else {
                result.add(currentWave);
            }

        }

        System.out.println(result.size());
        System.out.print(result.toString().replaceAll("[\\[\\],]", ""));

    }
}
