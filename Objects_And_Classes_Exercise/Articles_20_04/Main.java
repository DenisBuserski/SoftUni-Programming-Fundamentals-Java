package ObjectsAndClassesExercise.Articles20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Articles20> articles20List = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String [] tokens = scanner.nextLine().split(",");
            String title = tokens[0];
            String content = tokens[1];
            String author = tokens[2];

            Articles20 articles20 = new Articles20(title, content, author);
            articles20List.add(articles20);
        }
        //List<Articles20> sortedList = articles20List.stream().sorted(Comparator.comparing(Articles20::toString).reversed()).collect(Collectors.toList());

        String command = scanner.nextLine();
        switch (command) {
            case "title":
                articles20List.sort(Comparator.comparing(Articles20::getTitle));
                break;
            case "content":
                articles20List.sort(Comparator.comparing(Articles20::getContent));
                break;
            case "author":
                articles20List.sort(Comparator.comparing(Articles20::getAuthor));
                break;
        }


        for (Articles20 articles20 : articles20List) {
            System.out.println(articles20.toString());
        }



    }
}
