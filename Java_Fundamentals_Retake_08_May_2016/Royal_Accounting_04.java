package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_Retake_08_May_2016;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Royal_Accounting_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        //AN ARRAYLIST THAT HOLDS THE NAMES OF THE RECEIVED EMPLOYEES
        //NEEDED FOR THE CONDITION OF THE DUPLICATE EMPLOYEES
        ArrayList<String> allEmployees = new ArrayList<>();
        //THE MAP
        //TEAMS, FOR EVERY TEAM ITS EMPLOYEE, AND FOR EVERY EMPLOYEE ITS WORKHOURS AND DAILY PAYMENT STANDING AT
        //INDEX 0 AND 1 RESPECTIVELY IN THE DOUBLE ARRAY
        LinkedHashMap<String, LinkedHashMap<String, Double[]>> employeesByTeamDatabase = new LinkedHashMap<>();

        //Pattern : ^([a-zA-Z]+)\;(\d+)\;(\d+\.?\d+)\;([a-zA-Z]+)$
        //THE INPUT VALIDATION PATTERN
        String stringPattern = "^([a-zA-Z]+)\\;(\\-?\\d+)\\;(\\-?\\d+\\.?\\d*)\\;([a-zA-Z]+)$";

        Pattern regexPattern = Pattern.compile(stringPattern);

        String inputLine = scanner.nextLine();

        //THE MAIN LOOP
        while(!inputLine.equals("Pishi kuf i da si hodim")) {

            Matcher matcher = regexPattern.matcher(inputLine);

            //IF THE INPUT IS VALID
            if(matcher.find()) {

                //EXTRACTING THE NEEDED DATA
                String teamName = matcher.group(4);
                String employeeName = matcher.group(1);
                Double workHoursPerDay = Double.parseDouble(matcher.group(2));
                Double dailyPayment = Double.parseDouble(matcher.group(3));

                //IF THE NAME IS NOT DUPLICATE, WE CAN CONTINUE
                if(!allEmployees.contains(employeeName)) {
                    //IF THE TEAM EXISTS
                    if(employeesByTeamDatabase.containsKey(teamName)) {
                        //WE MAKE AN ARRAY OF THE WORKHOURS AND DAILYPAYMENT
                        Double[] employeeCharacteristics = new Double[] { workHoursPerDay, dailyPayment };

                        //WE EXTRACT THE CURRENT TEAM'S EMPLOYEES
                        LinkedHashMap<String, Double[]> currentEmployees = employeesByTeamDatabase.get(teamName);
                        //AND WE ADD THE NEW EMPLOYEE TO THEM
                        currentEmployees.put(employeeName, employeeCharacteristics);
                    }
                    else {
                        //IF THE TEAM IS NEW
                        //SAME DOUBLE ARRAY AS ABOVE
                        Double[] employeeCharacteristics = new Double[] { workHoursPerDay, dailyPayment };

                        //A NEW INNER MAP
                        LinkedHashMap<String, Double[]> currentEmployees = new LinkedHashMap<>();
                        //WE PUT THE NEW EMPLOYEE IN THE NEW INNER MAP
                        currentEmployees.put(employeeName, employeeCharacteristics);
                        //AND WE PUT THE NEW TEAM IN THE BIG MAP ALONG WITH THE INNER MAP AS ITS VALUE
                        employeesByTeamDatabase.put(teamName, currentEmployees);
                    }

                    //AND WE ADD THE NEW EMPLOYEE TO THE USED NAMES OF EMPLOYEES
                    allEmployees.add(employeeName);
                }
            }

            inputLine = scanner.nextLine();
        }

        //NOW, SORTING
        LinkedHashMap<String, LinkedHashMap<String, Double[]>> sortedEmployeeDatabase =
                employeesByTeamDatabase
                        .entrySet()
                        .stream()
                        .sorted(
                                (firstTeam, secondTeam) -> {
                                    //WE TAKE THE FIRST TEAM'S MONEY
                                    //BY USING THE Collectors.summingDouble METHOD WHILE COLLECTING
                                    //WE EXTRACT EACH EMPLOYEE AND ITS WORKHOURS (INDEX 0) AND ITS DAILY PAYMENT (INDEX 1)
                                    //AND WE PERFORMA THE FORMULA WITH THEM
                                    //SUMMING DOUBLE SUMS ALL THE DOUBLE VALUES OF A COLLECTION AND RETURNS A DOUBLE RESULT
                                    Double firstTeamMoney =
                                            firstTeam
                                                    .getValue()
                                                    .values()
                                                    .stream()
                                                    .collect(Collectors.summingDouble(employeeCredentials -> ((employeeCredentials[0].doubleValue() * employeeCredentials[1].doubleValue()) / 24) * 30));

                                    //SAME THINGS FOR THE SECOND TEAM
                                    Double secondTeamMoney =
                                            secondTeam
                                                    .getValue()
                                                    .values()
                                                    .stream()
                                                    .collect(Collectors.summingDouble(employeeCredentials -> ((employeeCredentials[0].doubleValue() * employeeCredentials[1].doubleValue()) / 24) * 30));

                                    //AND WE COMPARE THE SECOND TO THE FIRST (DESCENDING ORDER)
                                    Integer result = secondTeamMoney.compareTo(firstTeamMoney);
                                    return result;
                                })
                        //WE COLLECT THE MAP
                        //FOUND IN STACKOVERFLOW WHILE GOOGLE-ING "How to sort LinkedHashMap by values"
                        //SECOND OR THIRD RESULT
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (x, y) -> { throw new AssertionError(); },
                                        LinkedHashMap::new
                                )
                        );

        //THE NEEDED PADDING
        //I JUST LIKE EXTRACTING IT INTO A STRING
        String employeeOutputPadding = "$$$";

        //FOR EVERY TEAM
        for (Map.Entry<String, LinkedHashMap<String, Double[]>> currentTeam : sortedEmployeeDatabase.entrySet()) {

            //WE PRINT THE TEAM
            System.out.println(String.format("Team - %s", currentTeam.getKey()));

            //WE SORT ITS EMPLOYEES
            LinkedHashMap<String, Double[]> sortedEmployees =
                    currentTeam
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted(
                                    (firstEmployee, secondEmployee) -> {

                                        //COMPARING ONE EMPLOYEE'S WORKHOURS TO THE OTHER
                                        //AGAIN SECOND TO FIRST (DESCENDING ORDER)
                                        Integer result = secondEmployee.getValue()[0].compareTo(firstEmployee.getValue()[0]);

                                        //IF THEY ARE EQUAL
                                        if(result.equals(0)) {

                                            //EXTRACTING THE EMPLOYEES' DAILY INCOMES WITH THE FORMULA
                                            Double firstEmployeeDailyIncome = ((firstEmployee.getValue()[0] * firstEmployee.getValue()[1]) / 24);
                                            Double secondEmployeeDailyIncome = ((secondEmployee.getValue()[0] * secondEmployee.getValue()[1]) / 24);

                                            //AGAIN SECOND TO FIRST (DESCENDING ORDER)
                                            result = secondEmployeeDailyIncome.compareTo(firstEmployeeDailyIncome);

                                            //IF EVEN THEN THEY ARE EQUAL
                                            if(result.equals(0)) {
                                                //ALPHAETICAL ORDER
                                                result = firstEmployee.getKey().compareTo(secondEmployee.getKey());
                                            }
                                        }

                                        //AND WE RETURN THE FINAL RESULT
                                        return result;
                                    })
                            //AGAIN COLLECT
                            .collect(
                                    Collectors.toMap(
                                            Map.Entry::getKey,
                                            Map.Entry::getValue,
                                            (x, y) -> { throw new AssertionError(); },
                                            LinkedHashMap::new
                                    )
                            );


            //FOR EVERY TEAM ITS EMPLOYEES
            for (Map.Entry<String, Double[]> currentEmployee : sortedEmployees.entrySet()) {
                //WE PRINT THE EMPLOYEE AND ITS WORK HOURS AND ITS DAILY INCOME
                //WE USE %f PLACEHOLDER BECAUSE IT CUTS TO THE 6TH DIGIT
                System.out.println(
                        String.format("%s%s - %s - %f",
                                employeeOutputPadding,
                                currentEmployee.getKey(),
                                currentEmployee.getValue()[0].intValue(),
                                (currentEmployee.getValue()[0] * currentEmployee.getValue()[1].doubleValue()) / 24));
            }
        }
    }
}

