package homework14_pseudographics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String number;
        String exit;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Input a number: ");
            number = scanner.nextLine();
            Main.parseString(number);
            System.out.println("0 - exit, other number - continue.");
            System.out.print("Choose an action: ");
            exit = scanner.nextLine();
        } while (!exit.equals("0"));
    }

    public static void parseString(String string) throws NumberFormatException {
        char[] number;
        int integerChecking;
        try {
            integerChecking = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("NaN");
            return;
        }
        number = string.toCharArray();
        Main.print(Main.numberToString(number));
    }

    private static String[] numberToString(char[] number) {
        String[] stringNumbers = {"", "", "", "", ""};
        String[] temp;
        for (char c : number) {
            temp = getPseudographics(Character.getNumericValue(c));
            for (int j = 0; j < stringNumbers.length; j++) {
                stringNumbers[j] += temp[j] + " ";
            }
        }
        return stringNumbers;
    }

    private static String[] getPseudographics(int number) {
        if (number == 1) {
            return new String[]{
                    "   #",
                    "   #",
                    "   #",
                    "   #",
                    "   #"};
        } else if(number == 2) {
            return new String[]{
                    "####",
                    "   #",
                    "####",
                    "#   ",
                    "####"};
        } else if(number == 3) {
            return new String[]{
                    "####",
                    "   #",
                    "####",
                    "   #",
                    "####"};
        } else if(number == 4) {
            return new String[]{
                    "#  #",
                    "#  #",
                    "####",
                    "   #",
                    "   #"};
        } else if(number == 5) {
            return new String[]{
                    "####",
                    "#   ",
                    "####",
                    "   #",
                    "####"};
        } else if(number == 6) {
            return new String[]{
                    "####",
                    "#   ",
                    "####",
                    "#  #",
                    "####"};
        } else if(number == 7) {
            return new String[]{
                    "####",
                    "   #",
                    "   #",
                    "   #",
                    "   #"};
        } else if(number == 8) {
            return new String[]{
                    "####",
                    "#  #",
                    "####",
                    "#  #",
                    "####"};
        } else if(number == 9) {
            return new String[]{
                    "####",
                    "#  #",
                    "####",
                    "   #",
                    "####"};
        } else {
            return new String[]{
                    "####",
                    "#  #",
                    "#  #",
                    "#  #",
                    "####"};
        }
    }

    private static void print(String[] stringArray) {
        for (String s : stringArray) {
            System.out.println(s);
        }
    }
}
