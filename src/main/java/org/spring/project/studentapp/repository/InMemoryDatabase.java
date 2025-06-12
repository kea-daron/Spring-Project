package org.spring.project.studentapp.repository;


import org.spring.project.studentapp.model.Student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import java.util.List;

@Configuration
public class InMemoryDatabase {

    @Bean
    public List<Student> studentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "John", "Male", 100.0));
        studentList.add(new Student(2, "Jane", "Female", 75.0));
        studentList.add(new Student(3, "Bob", "Male", 75.0));
        studentList.add(new Student(4, "Alice", "Female", 75.0));
        studentList.add(new Student(5, "Sam", "Male", 75.0));
        studentList.add(new Student(6, "David", "Male", 75.0));
        studentList.add(new Student(7, "John", "Male", 75.0));
        studentList.add(new Student(8, "Jane", "Female", 75.0));
        studentList.add(new Student(9, "Bob", "Male", 75.0));
        studentList.add(new Student(10, "Alice", "Female", 75.0));
        return studentList;
    }


}

