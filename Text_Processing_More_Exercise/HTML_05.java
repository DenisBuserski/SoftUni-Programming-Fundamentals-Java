package TextProcessingMoreExercise;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String header = scanner.nextLine();
        String article = scanner.nextLine();
        String comments = scanner.nextLine();

        System.out.printf("<h1>%n   %s%n</h1>%n", header);
        System.out.printf("<article>%n   %s%n</article>%n", article);

        while (!comments.equals("end of comments")) {
            System.out.printf("<div>%n   %s%n</div>%n", comments);


            comments = scanner.nextLine();
        }


    }
}
