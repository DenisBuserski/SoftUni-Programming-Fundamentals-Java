import java.util.Scanner;

public class Tribonacci_Sequence_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = Integer.parseInt(scanner.nextLine());

        getTribonacci(index);
    }

    private static void getTribonacci(int index) {
        int[] sequenceArray = new int[index];

        if (index == 1) {
            System.out.println(1);
        } else if (index == 2) {
            System.out.println("1 1");
        } else if (index == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i <= index; i++) {
                if (i <= 3) {
                    sequenceArray[0] = 1;
                    sequenceArray[1] = 1;
                    sequenceArray[2] = 2;
                } else {
                    sequenceArray[i - 1] = sequenceArray[i - 2] + sequenceArray[i - 3] + sequenceArray[i - 4];
                }
            }
            
            for (int j = 0; j <= sequenceArray.length - 1; j++) {
                int number = sequenceArray[j];
                System.out.print(number + " ");
            }
        }
    }
    
}
