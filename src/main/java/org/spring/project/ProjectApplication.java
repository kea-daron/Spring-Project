package org.spring.project;

import org.spring.project.studentapp.model.Student;
import org.spring.project.studentapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.spring.project.studentapp.view.UI;

import java.util.Scanner;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    private final StudentService studentService;
    private final UI ui;

    public ProjectApplication(StudentService studentService, UI ui) {
        this.studentService = studentService;
        this.ui = ui;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            ui.home();
            System.out.print(" Please choose an option : ");
            int op = new Scanner(System.in).nextInt();
            switch (op) {
                case 1:{
                    studentService.getAllStudents().forEach(System.out::println);
                    break;
                }
                case 2:{
                    System.out.print(" Add new student ");
                    System.out.print(" Input ID : ");
                    int id = new Scanner(System.in).nextInt();
                    System.out.print(" Input Full Name : ");
                    String fullName = new Scanner(System.in).nextLine();
                    System.out.print(" Input Gender : ");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.print(" Input Score : ");
                    double score = new Scanner(System.in).nextDouble();

                    Student newStudent = new Student(id, fullName, gender, score);
                    studentService.insertStudent(newStudent);
                    System.out.println("Student added successfully!\n");
                }
            }
        }
    }
}
