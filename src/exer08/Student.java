package exer08;

import java.io.Serializable;
import java.util.ArrayList;

/* (ITEM 3.b) Let Student be an implementing class of Serializable */

public class Student implements Serializable {
    private String studentNumber;
    private String firstName;
    private String lastName;
    private ArrayList<Exam> exams;

    public Student(String studentNumber, String firstName, String lastName) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.exams = new ArrayList<Exam>();
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public ArrayList<Exam> getExams() {
        return this.exams;
    }

    public String toString() {
        return this.studentNumber + "," + this.lastName + "," + this.firstName;
    }

    public void take(Exam exam, int score) {
        /**
         * (ITEM #1)
         * invoke the exam method that will bind the student instance to the exam;
         * add the provided exam to the list of exams of the student
         */
        exam.take(this, score);
        this.exams.add(exam);
    }

    public float getAverage() {
        /**
         * (ITEM #2)
         * return the overall average of the student's exams
         */
        var examIterator = this.exams.iterator();
        int totalScore = 0;
        int totalMaxScore = 0;
        while (examIterator.hasNext()) {
            Exam exam = examIterator.next();
            totalScore += exam.getScore();
            totalMaxScore += exam.getMaxScore();
        }
        if (this.exams.isEmpty())
            return 0.0f;

        return (float) totalScore / totalMaxScore;
    }

}