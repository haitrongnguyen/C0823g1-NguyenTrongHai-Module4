package com.example.studentmanagementthymeleaf.repository;

import com.example.studentmanagementthymeleaf.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();

    void delete(int id);

    Student findStudentById(int id);

    void update(int id, Student student1);
}
