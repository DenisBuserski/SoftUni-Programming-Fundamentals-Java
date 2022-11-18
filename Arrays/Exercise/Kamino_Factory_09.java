import java.util.Arrays;
import java.util.Scanner;

public class Kamino_Factory_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = "";
        int bestSequence = -1;
        int bestIndex = Integer.MIN_VALUE;
        int bestSampleIndex = 0;
        int bestSum = 0;
        int sample = 0;
        int length = Integer.parseInt(scanner.nextLine());
        int[] bestDna = new int[length];

        command = scanner.nextLine();
        while(!command.equals("Clone them!")){
            int[] curSample = Arrays.stream(command.split("!+")).mapToInt(value -> Integer.parseInt(value)).toArray();
            sample++;

            int curLength = 0;
            int curBestLength = 0;
            int curEndIndex = 0;
            int curSum = 0;

            for (int i = 0; i < curSample.length; i++) {
                if (curSample[i] == 1) {
                    curLength++;
                    if (curLength > curBestLength) {
                        curBestLength = curLength;
                        curEndIndex = i;
                    }
                } else {
                    curLength = 0;
                }
            }
            
            for (int j = 0; j < curSample.length; j++) {
                curSum += curSample[j];
            }
            
            int curStartIndex = curEndIndex - curBestLength +1;
            boolean isBetter = false;

            if(curBestLength > bestSequence) {
                isBetter = true;
            } else if (curBestLength == bestSequence) {
                if (curStartIndex < bestIndex) {
                    isBetter = true;
                } else if (curStartIndex == bestIndex) {
                    if (curSum > bestSum) {
                        isBetter = true;
                    }
                }
            }

            if (isBetter) {
                bestDna = curSample;
                bestIndex = curStartIndex;
                bestSequence = curBestLength;
                bestSum = curSum;
                bestSampleIndex = sample;
            }
            
            command = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n",bestSampleIndex,bestSum);
        for (int i = 0; i < bestDna.length; i++) {
            System.out.print(bestDna[i] + " ");
        }

    }
}
