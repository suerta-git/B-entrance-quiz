package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import com.thoughtworks.capability.gtb.entrancequiz.util.StudentProvider;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {
    final private List<Student> students = new LinkedList<>();

    public StudentService() {
        students.addAll(StudentProvider.getInitStudents());
    }

    public List<Student> getStudents() {
        return students;
    }
}
