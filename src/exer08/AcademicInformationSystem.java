package exer08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class AcademicInformationSystem {

    public static final int CSV = 0;
    public static final int MAP = 1;
    private static final String FILE_CSV = "students.csv";
    private static final String FILE_MAP = "students.map";

    private HashMap<String, Student> studentsMap;

    public AcademicInformationSystem() {
        studentsMap = new HashMap<>();
    }

    public void load(int type) {
        try {
            switch (type) {
                case CSV:
                    this.loadCSV();
                    break;
                case MAP:
                    this.loadMAP();
                    break;
                default:
                    throw new InvalidFileTypeException();
            }
        } catch (InvalidFileTypeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void dump(int type) {
        try {
            switch (type) {
                case CSV:
                    this.dumpCSV();
                    break;
                case MAP:
                    this.dumpMAP();
                    break;
                default:
                    throw new InvalidFileTypeException();
            }
        } catch (InvalidFileTypeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private class InvalidFileTypeException extends Exception {
        public InvalidFileTypeException() {
            super("Source type may only be CSV or MAP");
        }
    }

    public void list() {
        /**
         * (ITEM #4) Implement the method;
         * List in console all students in the following format:
         * {student number},{last name},{first name}
         */
        for (String studentNumber : studentsMap.keySet()) {
            Student student = studentsMap.get(studentNumber);
            System.out.println(student);
        }
    }

    public void list(String batch) {
        /**
         * (ITEM #5) Implement the method;
         * List in console the students of the specified batch in the following
         * format:
         * {student number},{last name},{first name}
         */
        for (String studentNumber : studentsMap.keySet()) {
            if (studentNumber.startsWith(batch)) {
                Student student = studentsMap.get(studentNumber);
                System.out.println(student);
            }
        }
    }

    public Student find(String studentNumber) {
        return studentsMap.get(studentNumber);
    }

    private void loadCSV() {
        System.out.println("Loading data from CSV file...");
        /**
         * (ITEM #6) Implement the method;
         * Load all students in FILE_CSV to studentsMap;
         */
        String line = "";
        String delimiter = ",";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_CSV));
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentData = line.split(delimiter);
                Student student = new Student(studentData[0], studentData[1].toUpperCase(),
                        studentData[2].toUpperCase());
                for (int i = 3; i < studentData.length; i += 2) {
                    if (studentData[i] == null)
                        break;

                    Exam exam = new Exam(Integer.parseInt(studentData[i + 1]));
                    student.take(exam, Integer.parseInt(studentData[i]));
                }
                this.studentsMap.put(student.getStudentNumber(), student);

            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Done!");
    }

    // @SuppressWarnings("unchecked")
    public void loadMAP() {
        System.out.println("Loading data from MAP file...");
        /**
         * (ITEM #7) Implement the method;
         * Load all students in FILE_MAP to studentsMap;
         */
        try {
            FileInputStream file = new FileInputStream(FILE_MAP);
            ObjectInputStream ois = new ObjectInputStream(file);
            boolean cont = true;
            while (cont) {
                Student student = null;
                try {
                    student = (Student) ois.readObject();
                } catch (Exception e) {
                }

                if (student == null) {
                    cont = false;
                } else {
                    this.studentsMap.put(student.getStudentNumber(), student);
                }
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Done!");
    }

    private void dumpCSV() {
        System.out.println("Dumping data into CSV file...");
        /**
         * (ITEM #8) Implement the method;
         * Dump all students in studentsMap to FILE_CSV;
         */
        try {
            FileWriter writer = new FileWriter(FILE_CSV);
            for (Student student : studentsMap.values()) {
                String exams = "";
                for (Exam exam : student.getExams()) {
                    exams += String.format("%d,%d,", exam.getScore(), exam.getMaxScore());
                }
                String line = String.format("%s,%s,%s,%s\n", student.getStudentNumber(), student.getFirstName(),
                        student.getLastName(), exams);
                writer.write(line);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
    }

    private void dumpMAP() {
        System.out.println("Dumping data into MAP file...");
        /**
         * (ITEM #9) Implement the method;
         * Dump all students in studentsMap to FILE_MAP;
         */
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_MAP);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for (Student student : this.studentsMap.values()) {
                try {
                    objectOut.writeObject(student);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Done!");
    }

    public boolean addStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Argument student cannot be null");

        if (this.studentsMap.get(student.getStudentNumber()) != null)
            return false;
        this.studentsMap.put(student.getStudentNumber(), student);
        return true;
    }

    /**
     * (ITEM #10)
     * Remove your solution from items 3.a and 3.b; re-compile.
     * Write down the error you encounter during compilation.
     * Explain what the error is about and why you encountered it.
     * Put back your solution for items 3.a and 3.b.
     * Submit your exercise to your instructor.
     */

    /**
     * Answer:
     * Error Encountered: java.io.InvalidClassException: exer08.Student; class
     * invalid for deserialization
     * The error occured when loading data from students.map file because the
     * returned object of readObject() method
     * cannot be type cast to Student class because it is no longer implementing the
     * Serializable interface.
     * 
     * Error Encountered: java.io.NotSerializableException: exer08.Student
     * The error occured when trying to write Student instance into students.map
     * file because the student no longer
     * implements the Serializable interface.
     * 
     * Serializable interface tell the JVM that a class implementing it can be
     * serialize/deserialize. Both errors
     * will also occured when only the Student class implements the Serializable
     * interface because it contains
     * instances of Exam class for it's 'exams' attribute. Exam class must also
     * implement the Serialiable interface.
     */

}