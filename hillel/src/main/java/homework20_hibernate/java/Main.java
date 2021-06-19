package homework20_hibernate.java;

import homework20_hibernate.java.dao.StudentDAO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentDAO connect = new StudentDAO();
        Scanner scan = new Scanner(System.in);
        byte action;
        do {
            try {
                System.out.println("1 - Add student");
                System.out.println("2 - Print all students");
                System.out.println("3 - Find a student by name");
                System.out.println("4 - Find a student by ID");
                System.out.println("0 - Exit");
                System.out.print("Choose an action: ");
                action = scan.nextByte();
                switch (action) {
                    case 1 -> connect.addStudent();
                    case 2 -> connect.printAllStudents();
                    case 3 -> connect.getStudentByName();
                    case 4 -> connect.getStudentById();
                    case 0 -> System.exit(0);
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
