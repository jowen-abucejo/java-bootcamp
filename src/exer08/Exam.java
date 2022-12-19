package exer08;

import java.io.Serializable;

/* (ITEM 3.a) Let Exam be an implementing class of Serializable */
public class Exam implements Serializable {
    private Student student;
    private int maxScore;
    private int score;

    public Exam(int maxScore) {
        this.maxScore = maxScore;
    }

    public Exam(Student student, int maxScore) {
        this.student = student;
        this.maxScore = maxScore;
    }

    public Student getStudent() {
        return this.student;
    }

    public int getScore() {
        return this.score;
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public void take(Student student, int score) {
        try {
            if (student == null) {
                throw new NullStudentException();
            } else {
                this.student = student;
            }
            if (score < 0) {
                throw new NegativeScoreException();
            } else {
                this.score = score;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void take(int score) {
        try {
            if (this.student == null) {
                throw new NullStudentException();
            }
            if (score < 0) {
                throw new NegativeScoreException();
            } else {
                this.score = score;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private class NullStudentException extends Exception {
        public NullStudentException() {
            super("Student cannot be null.");
        }
    }

    private class NegativeScoreException extends Exception {
        public NegativeScoreException() {
            super("Score cannot be less than zero.");
        }
    }

}