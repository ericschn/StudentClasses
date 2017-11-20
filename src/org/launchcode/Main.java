package org.launchcode;

public class Main {

    public static void main(String[] args) {
	// create a Student instance
        Student student = new Student("Eric");
        Student student2 = new Student("Bob");

    // set some values
        student.setGpa(3.8);
        student.setNumberOfCredits(8);

        System.out.println(student);
        System.out.println(student2);

        System.out.println(student.equals(student2));

        student2.setStudentId(1);

        System.out.println(student.equals(student2));
        System.out.println(student.hashCode());
        System.out.println(student2.hashCode());

        // adding grades

        System.out.println(student);
        student.addGrade(3, 3);
        System.out.println(student);
        student.addGrade(88, 4);
        System.out.println(student);
    }
}
