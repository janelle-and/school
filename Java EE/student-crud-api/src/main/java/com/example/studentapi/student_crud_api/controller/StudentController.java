package com.example.studentapi.student_crud_api.controller;

import com.example.studentapi.student_crud_api.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void initStudents() {
        students.addAll(List.of(
                new Student(1, "Alice Johnson", "Computer Science", 3.8),
                new Student(2, "Brian Lee", "Information Technology", 3.4),
                new Student(3, "Carla Smith", "Mathematics", 3.6),
                new Student(4, "David White", "Physics", 3.2),
                new Student(5, "Eva Brown", "Computer Science", 3.9)
        ));
    }

//    @GetMapping
//    public List<Student>
}
