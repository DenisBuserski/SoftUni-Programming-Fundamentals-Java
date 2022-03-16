import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract_Emails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexEmail = "[A-Za-z0-9]+[._-]?[A-Za-z0-9]+@[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+-?[A-Za-z])+";
        Pattern pattern = Pattern.compile(regexEmail);
        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
