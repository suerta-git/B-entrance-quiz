package com.thoughtworks.capability.gtb.entrancequiz.util;

import com.thoughtworks.capability.gtb.entrancequiz.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentProvider {
    public static List<Student> getInitStudents() {
        final List<Student> students = new ArrayList<>();
        final List<String> studentNames = Arrays.asList(
                "成吉思汗",
                "鲁班七号",
                "太乙真人",
                "钟无艳",
                "花木兰",
                "雅典娜",
                "芈月",
                "白起",
                "刘禅",
                "庄周",
                "马超",
                "刘备",
                "哪吒",
                "大乔",
                "蔡文姬"
        );
        long id = 1L;
        for (String name: studentNames) {
            students.add(new Student(id++, name));
        };
        return students;
    }
}
