package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Fundamentals_4_October_2015;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dragon_Accounting_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<BigDecimal[]> employees = new LinkedList<>();
        BigDecimal budget = scanner.nextBigDecimal();
        scanner.nextLine();
        BigDecimal dayCounter = BigDecimal.ZERO;
        boolean hadBankupted = false;

        String[] inputLine;
        while (!(inputLine = scanner.nextLine().split("\\;"))[0].equals("END")) {
            dayCounter = dayCounter.add(BigDecimal.ONE);

            Long hiredEmployees = Long.parseLong(inputLine[0]);
            Long firedEmployees = Long.parseLong(inputLine[1]);
            BigDecimal hiredEmployeesSalary = new BigDecimal(inputLine[2]);

            BigDecimal[] employeeObj = new BigDecimal[]{new BigDecimal(1), dayCounter, hiredEmployeesSalary, new BigDecimal(hiredEmployees)};
            employees.add(employeeObj);

            if (dayCounter.compareTo(new BigDecimal(30)) == 0) {
                dayCounter = BigDecimal.ZERO;
                BigDecimal employeeSalary;
                for (BigDecimal[] employee : employees) {


                    if (employee[0].compareTo(new BigDecimal(365)) >= 0) {
                        employee[2] = employee[2].multiply(new BigDecimal(1.006));
                        employee[0] = employee[0].subtract(new BigDecimal(365));
                    }

                    employeeSalary = (employee[2].divide(new BigDecimal(30), 9, RoundingMode.UP).setScale(7, RoundingMode.DOWN));
                    employeeSalary = employeeSalary.multiply(new BigDecimal(31).subtract(employee[1]));
                    employee[0] = employee[0].add(BigDecimal.ONE);
                    employee[1] = BigDecimal.ONE;

                    employeeSalary = employeeSalary.multiply(employee[3]);
                    budget = budget.subtract(employeeSalary);
                }
            } else {
                for (BigDecimal[] employee : employees) {
                    employee[0] = employee[0].add(BigDecimal.ONE);
                }
            }
            for (int i = 0; i < firedEmployees; i++) {
                if (employees.peek()[3].equals(BigDecimal.ZERO)) {
                    employees.remove();
                }
                employees.peek()[3] = employees.peek()[3].subtract(BigDecimal.ONE);
                if (employees.peek()[3].equals(BigDecimal.ZERO)) {
                    employees.remove();
                }
            }
            for (int i = 3; i < inputLine.length; i++) {
                String[] dailyActivitiesString = inputLine[i].split(":");
                String dailyActivity = dailyActivitiesString[0];
                BigDecimal dailyActivityValue = new BigDecimal(dailyActivitiesString[1]);
                if (dailyActivity.equals("Previous years deficit")) {
                    budget = budget.subtract(dailyActivityValue);
                } else if (dailyActivity.equals("Machines")) {
                    budget = budget.subtract(dailyActivityValue);
                } else if (dailyActivity.equals("Taxes")) {
                    budget = budget.subtract(dailyActivityValue);
                } else if (dailyActivity.equals("Product development")) {
                    budget = budget.add(dailyActivityValue);
                } else if (dailyActivity.equals("Unconditional funding")) {
                    budget = budget.add(dailyActivityValue);
                }
            }
            if (budget.compareTo(BigDecimal.ZERO) <= 0) {
                hadBankupted = true;
                break;
            }
        }
        String result = budget.abs().setScale(4, RoundingMode.DOWN).toPlainString();

        if (hadBankupted) {
            System.out.printf("BANKRUPTCY: %s", result);
        } else {
            Long employeesCount = 0L;
            for (BigDecimal[] empl : employees) {
                employeesCount += empl[3].longValueExact();
            }
            System.out.printf("%d %s", employeesCount, result);
        }

    }
}

