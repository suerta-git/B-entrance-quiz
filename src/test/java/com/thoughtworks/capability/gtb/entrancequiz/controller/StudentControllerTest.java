package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import com.thoughtworks.capability.gtb.entrancequiz.util.StudentProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentService studentService;

    final private List<Student> students;

    StudentControllerTest() {
        students = new ArrayList<>(StudentProvider.getInitStudents());
    }

    @BeforeEach
    private void init() {
        studentService.init();
    }

    @Test
    public void should_get_students_when_request() throws Exception {
        final String json = objectMapper.writeValueAsString(students);
        mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }

    @Test
    public void should_add_new_student_when_given_student_name() throws Exception {
        final Student student = Student.builder().name("新学员").build();
        final String json = objectMapper.writeValueAsString(student);
        mockMvc.perform(post("/student").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[15].name", is("新学员")))
                .andExpect(jsonPath("$[15].id", is(16)));
    }
}