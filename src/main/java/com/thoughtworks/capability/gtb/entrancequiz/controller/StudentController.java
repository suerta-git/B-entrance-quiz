package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
@RequestMapping("/student")
public class StudentController {

    // TODO GTB-工程实践: - @Autowired注解可以省略，可以使用final声明bean
    @Autowired
    private StudentService studentService;

    // TODO GTB-知识点: - @RestController和ResponseEntity混合使用
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    // TODO GTB-知识点: - 没有返回值时，方法的返回参数可以为void
    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
