package com.student;

import com.student.model.Student;
import com.student.service.StudentService;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student s1 = new Student(10132, "Jai", 85);
        Student s2 = new Student(10234, "Paras", 92);
        Student s3 = new Student(10002, "Angad", 105);

        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);

        System.out.println("\nStudent Records:");
        service.displayStudents();
    }
}