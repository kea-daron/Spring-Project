package org.spring.project.studentapp.config;


import org.spring.project.studentapp.model.Student;
import org.spring.project.studentapp.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InMemoryDatabase {

    @Bean
    public List<Student> studentList() {
        return Arrays.asList(
                new Student(1, "Rithy Sok", "Male", 85.5),
                new Student(2, "Sokha Heng", "Female", 92.0),
                new Student(3, "Vannak Kim", "Male", 76.8),
                new Student(4, "Dara Chan", "Male", 88.3),
                new Student(5, "Sreymom Lim", "Female", 91.4),
                new Student(6, "Borey Chea", "Male", 67.9),
                new Student(7, "Monita Oum", "Female", 95.2),
                new Student(8, "Chhay Meng", "Male", 72.1),
                new Student(9, "Nary Eang", "Female", 89.6),
                new Student(10, "Sophal Uy", "Male", 79.0)
        );
    }

    @Bean
    public StudentService studentService(List<Student> studentList) {
        return new StudentService(studentList);
    }

}

