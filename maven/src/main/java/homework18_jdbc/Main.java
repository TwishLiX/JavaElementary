package homework18_jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBConnection connect = DBConnection.getInstance();
        Scanner scan = new Scanner(System.in);
        byte action;
        do {
            try {
                System.out.println("1 - Add student");
                System.out.println("2 - Delete student");
                System.out.println("3 - Print all students");
                System.out.println("4 - Find a student by name");
                System.out.println("5 - Find a student by ID");
                System.out.println("0 - Exit");
                System.out.print("Choose an action: ");
                action = scan.nextByte();
                switch (action) {
                    case 1 -> connect.addStudent();
                    case 2 -> connect.deleteStudent();
                    case 3 -> connect.printAllStudents();
                    case 4 -> connect.getStudentByName();
                    case 5 -> connect.getStudentByID();
                    case 0 -> {
                        connect.closeConnection();
                        System.exit(0);
                    }
                    default -> System.err.println("Incorrect value.\n");
                }
            } catch (InputMismatchException e) {
                System.err.println("Incorrect value.\n");
                scan.nextLine();
                continue;
            }
            System.out.println();
        } while (true);
    }
}
