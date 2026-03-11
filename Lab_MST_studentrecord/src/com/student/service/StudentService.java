package com.student.service;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.student.model.Student;
import com.student.util.InvalidMarksException;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {

        try {

            if (s.marks < 0 || s.marks > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100");
            }

            students.add(s);

            FileWriter fw = new FileWriter("students.txt", true);

            fw.write(s.studentId + " " + s.name + " " + s.marks + "\n");

            fw.close();

            System.out.println("Student added successfully");

        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public void displayStudents() {

        try {

            BufferedReader br = new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}