package homework18_jdbc;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBConnection {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static Connection connection;
    private static Statement statement;

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        short amount = 0;
        short admission_year;
        short group_id;
        String fio;
        System.out.println("How many students would you like to add?");
        do {
            try {
                System.out.print("Input: ");
                amount = scanner.nextShort();
                if (amount <= 0) System.err.println("Amount must be greater than 0.");
            } catch (InputMismatchException e) {
                System.err.println("Incorrect value.");
                scanner.nextLine();
            }
        } while (amount <= 0);
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            try {
                System.out.println("Student #" + (i + 1));
                System.out.println("Surname, firstname, patronymic:");
                fio = scanner.nextLine();
                System.out.print("Admission year: ");
                admission_year = scanner.nextShort();
                System.out.print("Group ID: ");
                group_id = scanner.nextShort();
                statement.execute("INSERT INTO university.student " +
                        "(fio, admission_year, group_id) VALUES ('" + fio + "', '" + admission_year + "', '" + group_id + "');");
                System.out.println("Student was successfully added to the database.");
            } catch (SQLException | InputMismatchException e) {
                System.err.println("Error. Try again.");
                scanner.nextLine();
                i--;
            }
        }
    }

    public void deleteStudent() {
        short amount = 0;
        short id;
        System.out.println("How many students would you like to delete?");
        do {
            try {
                System.out.print("Input: ");
                amount = scanner.nextShort();
                if (amount <= 0) System.err.println("Amount must be greater than 0.");
            } catch (InputMismatchException e) {
                System.err.println("Incorrect value.");
                scanner.nextLine();
            }
        } while (amount <= 0);
        scanner.nextLine();
        for (int i = 0; i < amount; i++) {
            try {
                System.out.print("Student ID: ");
                id = scanner.nextShort();
                ResultSet resultSet = statement.executeQuery("SELECT * " +
                        "FROM university.student " +
                        "WHERE student_id = " + id);
                if (resultSet.next()) {
                    statement.execute("DELETE FROM university.student " +
                            "WHERE student.student_id = " + id + ";");
                    System.out.println("Student was successfully deleted from the database.");
                } else {
                    System.out.println("Student with ID " + id + " does not exist.");
                }
            } catch (SQLException | InputMismatchException e) {
                System.err.println("Error. Try again.");
                scanner.nextLine();
                i--;
            }
        }

    }

    public void printAllStudents() {
        System.out.println();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT student.student_id, student.fio, `group`.`group` " +
            "FROM university.student " +
            "LEFT JOIN university.`group` " +
            "ON student.group_id = `group`.group_id;");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("student.student_id") +
                        ", name: " + resultSet.getString("student.fio") +
                        ", group: " + resultSet.getString("group.group"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudentByName() {
        String fio;
        System.out.println("Input surname, first name and patronymic of the student:");
        fio = scanner.nextLine();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT student.student_id, student.fio, `group`.`group` " +
                    "FROM university.student " +
                    "LEFT JOIN university.`group` " +
                    "ON student.group_id = `group`.group_id " +
                    "WHERE fio = '" + fio + "';");
            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("student.student_id") +
                        ", name: " + resultSet.getString("student.fio") +
                        ", group: " + resultSet.getString("group.group"));
            } else {
                System.out.println("Student with name '" + fio + "' does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudentByID() {
        short id = 0;
        do {
            try {
                System.out.print("Student ID: ");
                id = scanner.nextShort();
            } catch (InputMismatchException e) {
                System.err.println("Incorrect value.");
                scanner.nextLine();
            }
        } while (id <= 0);
        try {
            ResultSet resultSet = statement.executeQuery("SELECT student.student_id, student.fio, `group`.`group` " +
                    "FROM university.student " +
                    "LEFT JOIN university.`group` " +
                    "ON student.group_id = `group`.group_id " +
                    "WHERE student_id = " + id + ";");
            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("student.student_id") +
                        ", name: " + resultSet.getString("student.fio") +
                        ", group: " + resultSet.getString("group.group"));
            } else {
                System.out.println("Student with ID " + id + " does not exist.");
            }
            scanner.nextLine();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
