package com.example.studentmanagementthymeleaf.service;

import com.example.studentmanagementthymeleaf.model.Student;
import com.example.studentmanagementthymeleaf.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public void update(int id, Student student1) {
        studentRepository.update(id,student1);
    }
}
