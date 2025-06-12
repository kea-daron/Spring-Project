package org.spring.project.studentapp.config;


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
        return studentList;
    }


}

