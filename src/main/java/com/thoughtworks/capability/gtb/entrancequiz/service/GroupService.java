package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.model.Group;
import com.thoughtworks.capability.gtb.entrancequiz.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
public class GroupService {
    final private StudentService studentService;

    public GroupService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Group> getGroups(int total) {
        final List<Student> students = new LinkedList<>(studentService.getStudents());
        int[] groupSizes = getGroupSizes(total, students);
        return getGroups(students, groupSizes);
    }

    private List<Group> getGroups(List<Student> students, int[] groupSizes) {
        final List<Group> groups = new ArrayList<>();
        for (int groupIndex = 0; groupIndex < groupSizes.length; groupIndex++) {
            final Group newGroup = getGroup(students, groupSizes[groupIndex], groupIndex);
            groups.add(newGroup);
        }
        return groups;
    }

    private Group getGroup(List<Student> students, int groupSize, int groupIndex) {
        final Group newGroup = new Group();
        newGroup.setName(String.format("%d 组", groupIndex + 1));
        for (int i = 0; i < groupSize; i++) {
            Random random = new Random();
            final int studentIndex = random.nextInt(students.size());
            newGroup.getStudents().add(students.get(studentIndex));
            students.remove(studentIndex);
        }
        return newGroup;
    }

    private int[] getGroupSizes(int total, List<Student> students) {
        final int[] groupSizes = new int[total];
        for (int i = 0; i < total; i++) {
            groupSizes[i] = i < students.size() % total
                    ? students.size() / total + 1
                    : students.size() / total;
        }
        return groupSizes;
    }
}
