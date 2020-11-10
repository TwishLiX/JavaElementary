package homework2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Homework2 {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Homework2 homework2 = new Homework2();
        int action;
        do {
            System.out.println("1 - The first task (average of two numbers)");
            System.out.println("2 - The second task (average of arbitrary amount of numbers)");
            System.out.println("3 - The third task (cash deposits)");
            System.out.println("0 - Exit");
            System.out.print("Choose a task to run: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    homework2.getFirstTask();
                    break;
                case 2:
                    homework2.getSecondTask();
                    break;
                case 3:
                    homework2.getThirdTask();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        } while (true);
    }

    public void getFirstTask() {
        double number1, number2, average;
        System.out.print("Input the first number: ");
        number1 = scanner.nextDouble();
        System.out.print("Input the second number: ");
        number2 = scanner.nextDouble();
        average = (number1 + number2) / 2;
        System.out.println("Average of two numbers: " + average);
        System.out.println();
    }

    public void getSecondTask() {
        int amount;
        double average = 0;
        double[] numbers;
        do {
            System.out.print("Input an amount of numbers: ");
            amount = scanner.nextInt();
            if (amount <= 1) {
                System.out.println("Amount of numbers must be greater than 1.");
            }
        } while (amount <= 1);
        numbers = new double[amount];
        for (int i = 0; i < amount; i++) {
            System.out.print("Input the " + (i + 1) + " number: ");
            numbers[i] = scanner.nextDouble();
            average += numbers[i];
        }
        average /= amount;
        System.out.println("Average of " + amount + " numbers: " + average);
        System.out.println();
    }

    public void getThirdTask() {
        int depositDuration;
        double initialSum, percentages, balance, percentagesInUAH;
        do {
            System.out.print("Input an initial deposit amount (in UAH): ");
            initialSum = scanner.nextDouble();
            initialSum = roundToHundredths(initialSum);
            if (initialSum < 0) {
                System.out.println("Deposit amount must be positive.");
            }
        } while (initialSum < 0);
        balance = initialSum;
        do {
            System.out.print("Input a percent per annum: ");
            percentages = scanner.nextDouble();
            if (percentages < 0 || percentages > 100) {
                System.out.println("Incorrect value.");
            }
        } while (percentages < 0 || percentages > 100);
        do {
            System.out.print("Input a deposit duration (in years): ");
            depositDuration = scanner.nextInt();
            if (depositDuration <= 0) {
                System.out.println("Deposit must last at least 1 year.");
            }
        } while (depositDuration <= 0);
        System.out.println("Initial contribution: " + initialSum + "UAH");
        for (int i = 0; i < depositDuration; i++) {
            percentagesInUAH = roundToHundredths((balance / 100) * percentages);
            balance = roundToHundredths(balance + percentagesInUAH);
            System.out.println("The " + (i + 1) + " year: balance - " + balance + "UAH, percentages - " + percentagesInUAH + "UAH");
        }
        System.out.println();
    }

    double roundToHundredths(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(value));
    }
}
