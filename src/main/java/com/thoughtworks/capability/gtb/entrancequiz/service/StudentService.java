package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import com.thoughtworks.capability.gtb.entrancequiz.util.StudentProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    final private List<Student> students = new ArrayList<>();

    public StudentService() {
        init();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(students.size() + 1L);
        students.add(student);
    }

    public void init() {
        students.clear();
        students.addAll(StudentProvider.getInitStudents());
    }
}
