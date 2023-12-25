package com.example.studentmanagementthymeleaf.service;

import com.example.studentmanagementthymeleaf.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    void delete(int id);

    Student findStudentById(int id);

    void update(int id, Student student1);
}
