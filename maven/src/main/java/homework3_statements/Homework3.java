package homework3_statements;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Homework3 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Homework3 homework3 = new Homework3();
        int action;
        System.out.println("1 - Print odd numbers");
        System.out.println("2 - Find a factorial of number");
        System.out.println("3 - Options '1-2' with while statement");
        System.out.println("4 - Options '1-2' with do-while statement");
        System.out.println("5 - Find a power of number");
        System.out.println("6 - Print the first 10 numbers of the sequence");
        System.out.println("7 - Print a multiplication table");
        System.out.println("8 - Print odd numbers from array");
        System.out.println("9 - Print minimum and maximum array elements");
        System.out.println("10 - Swap minimum and maximum array elements");
        System.out.println("11 - Find the average of all array elements");
        System.out.println("12 - Print chess board");
        System.out.println("0 - Exit");

        do {
            System.out.print("\nChoose a task to run: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    homework3.printOddNumbers();
                    break;
                case 2:
                    homework3.getFactorial();
                    break;
                case 3:
                    homework3.getOddAndFactorialWithWhile();
                    break;
                case 4:
                    homework3.getOddAndFactorialWithDoWhile();
                    break;
                case 5:
                    homework3.getNumberInPower();
                    break;
                case 6:
                    homework3.printNumbersOfSequence();
                    break;
                case 7:
                    homework3.printMultiplicationTable();
                    break;
                case 8:
                    homework3.printArrayElements();
                    break;
                case 9:
                    homework3.printMinMaxElements();
                    break;
                case 10:
                    homework3.swapArrayElements();
                    break;
                case 11:
                    homework3.getAverage();
                    break;
                case 12:
                    homework3.printChessBoard();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        } while (true);
    }

    void printOddNumbers() {
        System.out.println("Odd numbers from 1 to 99:");
        for (byte i = 1; i <= 99; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void getFactorial() {
        int number = initFactorialNumber();
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of number " + number + ": " + factorial);
    }

    void getOddAndFactorialWithWhile() {
        byte counter = 1;
        System.out.println("Odd numbers from 1 to 99:");
        while (counter <= 99) {
            System.out.print(counter + " ");
            counter += 2;
        }
        System.out.println();

        counter = 1;
        int number = initFactorialNumber();
        int factorial = 1;
        while (counter <= number) {
            factorial *= counter;
            counter++;
        }
        System.out.println("Factorial of number " + number + ": " + factorial);
    }

    void getOddAndFactorialWithDoWhile() {
        byte counter = 1;
        System.out.println("Odd numbers from 1 to 99:");
        do {
            System.out.print(counter + " ");
            counter += 2;
        } while (counter <= 99);
        System.out.println();

        counter = 1;
        int number = initFactorialNumber();
        int factorial = 1;
        do {
            factorial *= counter;
            counter++;
        } while (counter <= number);
        System.out.println("Factorial of number " + number + ": " + factorial);
    }

    int initFactorialNumber() {
        int number;
        do {
            System.out.print("Input a number to find the factorial: ");
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Factorial must be positive or null.");
            }
        } while (number < 0);
        return number;
    }

    void getNumberInPower() {
        int number1;
        int number2;
        System.out.print("Input a number: ");
        number1 = scanner.nextInt();
        System.out.print("Input a power of number: ");
        number2 = scanner.nextInt();
        System.out.println(number1 + "^" + number2 + "=" + (int) Math.pow(number1, number2));
    }

    void printNumbersOfSequence() {
        byte counter = 0;
        byte number = 0;
        System.out.println("The first 10 numbers of sequence '0, -5, -10, ...' :");
        while (counter < 10) {
            System.out.print(number + " ");
            number -= 5;
            counter++;
        }
    }

    void printMultiplicationTable() {
        int number;
        System.out.print("Input a number: ");
        number = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + "x" + i + "=" + number * i);
        }
    }

    void printArrayElements() {
        final byte LENGTH = 10;
        int[] array = new int[LENGTH];
        System.out.println("The first " + LENGTH + " odd array elements:");
        for (byte i = 0, j = 1; i < LENGTH; i++, j+=2) {
            array[i] = j;
            if (i == LENGTH - 1) {
                System.out.print(array[i]);     // removing comma for the last element
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    void printMinMaxElements() {
        Integer[] array = initArray(true);
        int min = array[0];
        int max = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.println("\nMinimum element in array: " + min);
        for (int i = 0; i < array.length; i++) {
            if (min == array[i]) {
                System.out.println("Element with index " + i + " is equal to minimum.");
            }
        }
        System.out.println("Maximum element in array: " + max);
        for (int i = 0; i < array.length; i++) {
            if (max == array[i]) {
                System.out.println("Element with index " + i + " is equal to maximum.");
            }
        }
    }

    void swapArrayElements() {
        Integer[] array = initArray(false);
        int min = array[0];
        int minIndex = 0;
        int max = array[0];
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        array[minIndex] = max;
        array[maxIndex] = min;
        System.out.print("\nArray elements after swapping: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    void getAverage() {
        Integer[] array = initArray(true);
        double average = 0;
        for (int i : array) {
            average += i;
        }
        average /= array.length;
        System.out.println("\nAverage of array elements: " + average);
    }

    public Integer[] initArray(boolean isDuplicate) {
        final short LENGTH;
        Integer[] array;
        System.out.print("Input a length of the array: ");
        LENGTH = scanner.nextShort();
        array = new Integer[LENGTH];
        if (isDuplicate) {    // elements are repeated
            for (int i = 0; i < LENGTH; i++) {
                array[i] = (int) (Math.random() * 20);
            }
        } else {    // elements are not repeated
            for (int i = 0; i < LENGTH; i++) {
                array[i] = i;
            }
            Collections.shuffle(Arrays.asList(array));
        }
        System.out.print("Array elements: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        return array;
    }

    void printChessBoard() {
        char[][] chessBoard = new char[8][8];
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (row % 2 == 0) {
                    if (column % 2 == 0) {
                        chessBoard[row][column] = 'W';
                    } else {
                        chessBoard[row][column] = 'B';
                    }
                } else {
                    if (column % 2 == 0) {
                        chessBoard[row][column] = 'B';
                    } else {
                        chessBoard[row][column] = 'W';
                    }
                }
                System.out.print(chessBoard[row][column] + " ");
            }
            System.out.println();
        }
    }
}
