import java.util.Scanner;

public class Winning_Ticket_01 {
    
    private static final String REGEX = "(?=.{20}).*?(?=(?<ch>[@#$^]))(?<match>\\k<ch>{6,}).*(?<=.{10})\\k<match>.*";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static final Pattern SEPARATOR = Pattern.compile("\\s*,\\s*");
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        String[] tickets = SEPARATOR.split(scanner.nextLine().trim());

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
            } else {
                Matcher matcher = PATTERN.matcher(ticket);
                if (matcher.matches()) {
                    String match = matcher.group("match");
                    System.out.printf("ticket \"%s\" - %d%s%s%n",
                            ticket, match.length(), match.charAt(0),
                            (match.length() == 10) ? " Jackpot!" : "");
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            }
        }
    }
}
