package exer08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final int OPT_LOAD_CSV = 1;
    public static final int OPT_LOAD_MAP = 2;
    public static final int OPT_LIST_STUDENTS = 3;
    public static final int OPT_LIST_STUDENTS_BATCH = 4;
    public static final int OPT_SEARCH_STUDENT = 5;
    public static final int OPT_DUMP_CSV = 6;
    public static final int OPT_DUMP_MAP = 7;
    public static final int OPT_ADD_STUDENT = 8;
    public static final int OPT_EXIT = 0;

    public static final int OPT_YES = 1;
    public static final int OPT_NO = 0;

    static AcademicInformationSystem ais;

    public static void main(String[] args) {
        ais = new AcademicInformationSystem();
        while (showMenu() != 0);

        System.out.println("Good bye!");
    }

    public static int showMenu() {
        clear();
        System.out.println("----------------------------------");
        System.out.println("Student Acadmic Information System");
        System.out.println("----------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("[1] Load student records from CSV");
        System.out.println("[2] Load student records from MAP");
        System.out.println("[3] List all students");
        System.out.println("[4] List students by batch");
        System.out.println("[5] Search student");
        System.out.println("[6] Dump student records to CSV");
        System.out.println("[7] Dump student records to MAP");
        System.out.println("[8] Add new student");
        System.out.println("[0] Exit");
        System.out.print("Answer: ");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case OPT_LOAD_CSV:
                ais.load(AcademicInformationSystem.CSV);
                break;
            case OPT_LOAD_MAP:
                ais.load(AcademicInformationSystem.MAP);
                break;
            case OPT_LIST_STUDENTS:
                ais.list();
                break;
            case OPT_LIST_STUDENTS_BATCH:
                System.out.println("What year did they enter the University?");
                System.out.print("Batch: ");

                in.nextLine();
                String batch = in.nextLine();

                ais.list(batch);
                break;
            case OPT_SEARCH_STUDENT:
                System.out.println("Who are you looking for?");
                System.out.print("Student number: ");

                in.nextLine();
                Student student = ais.find(in.nextLine());

                if (student == null) {
                    System.out.println("Student not found!");
                } else {
                    showStudentInfo(student);
                }

                break;
            case OPT_DUMP_CSV:
                ais.dump(AcademicInformationSystem.CSV);
                break;
            case OPT_DUMP_MAP:
                ais.dump(AcademicInformationSystem.MAP);
                break;
            case OPT_ADD_STUDENT:
                in.nextLine();
                System.out.print("Student number: ");
                String studentNumber = in.nextLine();

                System.out.print("Firstname: ");
                String firstName = in.nextLine().trim().toUpperCase();

                System.out.print("Lastname: ");
                String lastName = in.nextLine().trim().toUpperCase();

                Student newStudent = new Student(studentNumber, firstName, lastName);
                if (ais.addStudent(newStudent)) {
                    System.out.println("New student added successfully");
                } else {
                    System.out.println("Student number already exist");
                }
        }
        return choice;
    }

    public static void showStudentInfo(Student student) {
        System.out.println("----------------------------------");
        System.out.println("Student: " + student.getStudentNumber());
        System.out.println("----------------------------------");
        System.out.println(student.toString());
        ArrayList<Exam> exams = student.getExams();
        for (int i = 0; i < exams.size(); i += 1) {
            Exam exam = exams.get(i);
            System.out.printf("[" + (i + 1) + "] %3d/%3d\n", exam.getScore(),
                    exam.getMaxScore());
        }
        System.out.println("Average: " + student.getAverage());
        System.out.println();

        while (showAddExamMenu(student) != 0);

    }

    public static int showAddExamMenu(Student student) {
        System.out.println("Add an exam?");
        System.out.println("[1] Yes");
        System.out.println("[0] No");
        System.out.print("Answer: ");

        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == OPT_YES) {
            System.out.println("What is the max score?");
            System.out.print("Max Score: ");
            int maxScore = in.nextInt();
            System.out.println("What is the student's score?");
            System.out.print("Score: ");
            int score = in.nextInt();
            Exam exam = new Exam(student, maxScore);
            student.take(exam, score);
        }
        return choice;
    }

    public static void clear() {
        for (int i = 0; i < 10; i += 1) {
            System.out.println();
        }
    }
}
