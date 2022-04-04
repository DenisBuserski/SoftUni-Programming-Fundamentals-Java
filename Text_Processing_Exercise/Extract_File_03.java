import java.util.Scanner;

public class Extract_File_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");

        String result = input[input.length - 1];
        String fileName = result.split("\\.")[0];
        String extension = result.split("\\.")[1];

        System.out.print("File name: " + fileName);
        System.out.println();
        System.out.print("File extension: " + extension);
    }   
}
