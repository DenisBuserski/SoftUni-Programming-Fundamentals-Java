import java.util.Scanner;

public class Multiply_Big_Number_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number1 = scanner.nextLine();
        String number2 = scanner.nextLine();

        if ((number1.charAt(0) == '-' || number2.charAt(0) == '-') && (number1.charAt(0) != '-' || number2.charAt(0) != '-')) {
            System.out.print("-");
        }

        if (number1.charAt(0) == '-' && number2.charAt(0) != '-') {
            number1 = number1.substring(1);
        } else if (number1.charAt(0) != '-' && number2.charAt(0) == '-') {
            number2 = number2.substring(1);
        } else if (number1.charAt(0) == '-' && number2.charAt(0) == '-') {
            number1 = number1.substring(1);
            number2 = number2.substring(1);
        }
        System.out.println(multiply(number1, number2));
    }

    static String multiply(String num1, String num2) { // Multiplies str1 and str2, and prints result.
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0)
            return "0";

        // will keep the result number in vector
        // in reverse order
        int result[] = new int[len1 + len2];

        // Below two indexes are used to
        // find positions in result.
        int i_n1 = 0;
        int i_n2 = 0;

        // Go from right to left in num1
        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            // To shift position to left after every
            // multipliccharAtion of a digit in num2
            i_n2 = 0;

            // Go from right to left in num2
            for (int j = len2 - 1; j >= 0; j--) {
                // Take current digit of second number
                int n2 = num2.charAt(j) - '0';

                // Multiply with current digit of first number
                // and add result to previously stored result
                // charAt current position.
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

                // Carry for next itercharAtion
                carry = sum / 10;

                // Store result
                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }

            // store carry in next cell
            if (carry > 0)
                result[i_n1 + i_n2] += carry;

            // To shift position to left after every
            // multipliccharAtion of a digit in num1.
            i_n1++;
        }

        // ignore '0's from the right
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        // If all were '0's - means either both
        // or one of num1 or num2 were '0'
        if (i == -1)
            return "0";

        // genercharAte the result String
        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
    }
}
