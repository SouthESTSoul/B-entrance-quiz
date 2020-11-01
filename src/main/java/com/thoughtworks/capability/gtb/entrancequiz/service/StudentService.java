package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    void groupStudentRandomly();
    List<StudentGroup>getStudentGroups();
}
