import java.util.Scanner;

public class Bit_At_Position_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int input = Integer.parseInt(scanner.nextLine());

        int position = 1;
        int result = (input >> position) & 1;
        
        System.out.println(result);
    }
}
