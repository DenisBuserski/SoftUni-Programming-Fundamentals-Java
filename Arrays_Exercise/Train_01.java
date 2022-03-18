import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagonsCount = Integer.parseInt(scanner.nextLine());

        int passangers = 0;
        int sumPassangers = 0;
        
        for (int i = 1; i <= wagonsCount; i++) {
            passangers = Integer.parseInt(scanner.nextLine());
            sumPassangers += passangers;
            System.out.print(passangers + " ");

        }
        
        System.out.println();
        System.out.println(sumPassangers);
    }
}
