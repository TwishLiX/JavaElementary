package homework10_iterator;

import java.util.*;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main main = new Main();
        int action;
        System.out.println("1 - Clear the collection of duplicates.");
        System.out.println("2 - Get an iterator over the array.");
        System.out.println("3 - Find the roots of a quadratic equation.");
        System.out.println("0 - Exit");
        do {
            System.out.print("Choose a task to run: ");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    main.initCollection();
                    break;
                case 2:
                    main.getIterator();
                    break;
                case 3:
                    main.solveEquation();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        } while (true);
    }

    public void initCollection() {
        ArrayList<Integer> list = new ArrayList<>();
        int amount;
        int temp;
        System.out.println("How many elements would you like to add to the list?");
        do {
            System.out.print("Input: ");
            amount = scanner.nextInt();
        } while (amount <= 0);
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            System.out.print("The " + (i + 1) + " element: ");
            temp = scanner.nextInt();
            list.add(temp);
        }
        System.out.println("Collection before conversion: ");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println("\nCollection after conversion: ");
        clearOfDuplicates(list);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public ArrayList clearOfDuplicates(ArrayList<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        return list;
    }

    public void getIterator() {
        int amount;
        int temp;
        do {
            System.out.print("To fill array, input its size: ");
            amount = scanner.nextInt();
        } while (amount <= 0);
        scanner.nextLine();
        Integer[] array = new Integer[amount];
        for (int i = 0; i < amount; i++) {
            System.out.print("Input the " + (i + 1) + " element of the array: ");
            temp = scanner.nextInt();
            array[i] = temp;
        }
        System.out.println("Your array:");
        CustomIterator iterator = new CustomIterator(array);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void solveEquation() {
        double A, B, C, discriminant, x1, x2;
        System.out.println("Determination of quadratic equation:");
        System.out.println("Ax^2 + Bx + C = 0");
        System.out.print("Input coefficient A: ");
        A = scanner.nextInt();
        System.out.print("Input coefficient B: ");
        B = scanner.nextInt();
        System.out.print("Input coefficient C: ");
        C = scanner.nextInt();
        discriminant = B * B - 4 * A * C;
        if (discriminant < 0) {
            System.out.println("No roots.");
        } else if (discriminant == 0) {
            x1 = -B / (2 * A);
            System.out.println("x = " + x1);
        } else if (discriminant > 0) {
            x1 = (-B - Math.sqrt(discriminant)) / (2 * A);
            x2 = (-B + Math.sqrt(discriminant)) / (2 * A);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
