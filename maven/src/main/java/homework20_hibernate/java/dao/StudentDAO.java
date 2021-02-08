package homework20_hibernate.java.dao;

import homework20_hibernate.java.entity.Group;
import homework20_hibernate.java.entity.Student;
import homework20_hibernate.java.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
    private static final Scanner scanner = new Scanner(System.in);
    List<Student> students;

    public void addStudent() {
        Student student;
        short amount = 0;
        short admission_year;
        String fio;
        String group;
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
                scanner.nextLine();
                System.out.print("Group ID: ");
                group = scanner.nextLine();
                student = new Student(fio, admission_year, new Group(group));
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(student);
                session.getTransaction().commit();
                session.close();
            } catch (InputMismatchException e) {
                System.err.println("Error. Try again.");
                scanner.nextLine();
                i--;
            }
        }
    }

    public void printAllStudents() {
        students = HibernateUtil.getSessionFactory().openSession().createSQLQuery("SELECT * FROM student").list();
        System.out.println(students);
    }

    public void getStudentByName() {
        String fio;
        System.out.println("Input surname, first name and patronymic of the student:");
        fio = scanner.nextLine();
        System.out.println(HibernateUtil.getSessionFactory().openSession().createSQLQuery("SELECT * FROM student where student.fio = '" + fio + "';").addEntity(Student.class).list());
        scanner.nextLine();
    }

    public void getStudentById() {
        int id = 0;
        do {
            try {
                System.out.print("Student ID: ");
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Incorrect value.");
                scanner.nextLine();
            }
        } while (id <= 0);
        System.out.println(HibernateUtil.getSessionFactory().openSession().get(Student.class, id));
        scanner.nextLine();
    }
}
