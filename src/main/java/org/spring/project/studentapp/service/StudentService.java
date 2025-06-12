package org.spring.project.studentapp.service;


import org.spring.project.studentapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void insertStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean updateStudentById(int id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                updatedStudent.setId(id);
                students.set(i, updatedStudent);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudentById(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}

