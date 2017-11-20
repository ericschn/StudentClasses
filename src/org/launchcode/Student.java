package org.launchcode;

public class Student {

    private static int nextStudentId = 1;
    private String name;
    private int studentId;
    private int numberOfCredits;
    private double gpa;

    public Student(String name, int studentId,
                   int numberOfCredits, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.numberOfCredits = numberOfCredits;
        this.gpa = gpa;
    }

    public Student(String name, int studentId) {
        this(name, studentId, 0, 0);
    }

    public Student(String name) {
        this(name, nextStudentId);
        nextStudentId++;
    }

    // override toString() method and printing object directly
    public String toString() {
        return studentId + " - " + name + " - " + getGradeLevel() + " (Credits: " + numberOfCredits + ", GPA: " + gpa + ")";
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + studentId;
        result = 31 * result + numberOfCredits;
        temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    // override equals() method, checks if studentId is equal to other
    public boolean equals(Object o) {

        if (o == this) return true;

        if (o == null || o.getClass() != getClass()) return false;

        Student otherStudent = (Student) o;
        return otherStudent.getStudentId() == getStudentId();
    }

    public void addGrade(int courseCredits, double grade) {
        // Update the appropriate fields: numberOfCredits, gpa
        double prevQual = gpa * numberOfCredits;
        double newQual = courseCredits * grade + prevQual;
        setNumberOfCredits(getNumberOfCredits() + courseCredits);
        setGpa(newQual / getNumberOfCredits());
    }

    public String getGradeLevel() {

        if (numberOfCredits < 30) {
            return "freshman";
        }
        if (numberOfCredits < 60) {
            return "sophomore";
        }
        if (numberOfCredits < 90) {
            return "junior";
        }else{
            return "senior";
        }

        // Determine the grade level of the student based on numberOfCredits
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
}
