package org.spring.project;

import org.spring.project.studentapp.model.Student;
import org.spring.project.studentapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {
    private StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" Add new student");
        System.out.println(" Insert ID : ");
        int id = new Scanner(System.in).nextInt();
        System.out.println(" Insert full name : ");
        String name = new Scanner(System.in).nextLine();
        System.out.println(" Insert gender : ");
        String gender = new Scanner(System.in).nextLine();
        System.out.println(" Insert score : ");
        double score = new Scanner(System.in).nextDouble();
        Student student = new Student(id, name, gender, score);
        studentService.insertStudent(student);

        System.out.println(" Get All Students ");
        System.out.println(studentService.getAllStudents());

//        System.out.println(student);
    }


}
