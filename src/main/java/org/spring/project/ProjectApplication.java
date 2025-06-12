package org.spring.project;

import org.spring.project.studentapp.model.Student;
import org.spring.project.studentapp.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.spring.project.studentapp.view.UI;

import java.util.List;
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
                    System.out.println(" Add new student ");
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
                    break;
                }
                case 3:{
                    System.out.print(" Input Student ID to search : ");
                    int sid = new Scanner(System.in).nextInt();
                    Student student = studentService.getStudentById(sid);
                    if (student != null) {
                        System.out.println(" Search student successfully!\n");
                        System.out.println(student);
                    }else{
                        System.out.println(" Search student failed!\n");
                    }
                }
                case 4:{
                    System.out.print(" Input Student ID to update : ");
                    int sid = new Scanner(System.in).nextInt();
                    Student student = studentService.getStudentById(sid);
                    if (student == null) {
                        System.out.print(" Student not found!\n");
                        break;
                    }
                    System.out.println(" Current student ");
                    System.out.println(student);

                    System.out.print(" Input New ID : ");
                    int id = new Scanner(System.in).nextInt();
                    System.out.print(" Input New Full Name : ");
                    String newFullName = new Scanner(System.in).nextLine();
                    System.out.print(" Input New Gender : ");
                    String newGender = new Scanner(System.in).nextLine();
                    System.out.print(" Input New Score : ");
                    double newScore = new Scanner(System.in).nextDouble();

                    Student updatedStudent = new Student(id, newFullName, newGender, newScore);

                    boolean update = studentService.updateStudentById(sid, updatedStudent);
                    if (update) {
                        System.out.println("Student updated successfully!\n");
                    }else {
                        System.out.println("Student update failed!\n");
                    }
                }
                case 5:{
                    System.out.print(" Input Student ID to delete : ");
                    int sid = new Scanner(System.in).nextInt();
                    boolean delete = studentService.deleteStudentById(sid);
                    if (delete) {
                        System.out.println("Student deleted successfully!\n");
                    }else {
                        System.out.println("Student delete failed!\n");
                    }
                }
                case 0:{
                    System.out.println(" Goodbye developer see you next time!!!\n");
                    System.exit(0);
                }
            }
        }
    }
}
