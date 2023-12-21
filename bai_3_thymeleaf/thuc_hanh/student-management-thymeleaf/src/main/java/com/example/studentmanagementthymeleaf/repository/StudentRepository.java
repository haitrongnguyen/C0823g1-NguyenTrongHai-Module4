package com.example.studentmanagementthymeleaf.repository;

import com.example.studentmanagementthymeleaf.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository implements IStudentRepository{
    private static final Map<Integer,Student> map;
    static {
        map = new HashMap<>();
        map.put(1,new Student(1,"Nguyễn Trọng Hải","Nam",25,"Quảng Bình"));
        map.put(2,new Student(2,"Nguyễn Văn A","Nam",26,"Quảng Trị"));
        map.put(3,new Student(3,"Nguyễn Thị B","Nữ",27,"Huế"));
        map.put(4,new Student(4,"Trần Văn C","Nam",28,"Quảng Nam"));
        map.put(5,new Student(5,"Trần Thị D","Nữ",29,"Quảng Ngãi"));
    }
    @Override
    public List<Student> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }
}
