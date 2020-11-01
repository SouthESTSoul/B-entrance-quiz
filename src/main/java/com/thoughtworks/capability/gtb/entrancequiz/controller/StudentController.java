package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok().body(students);
    }


    @PostMapping("/student/groups")
    public ResponseEntity groupStudentRandomly() throws URISyntaxException {
        studentService.groupStudentRandomly();
        return ResponseEntity.created(new URI("student/groups")).build();

    }
    @GetMapping("student/groups")
    public ResponseEntity getStudentsGroups(){
        List<StudentGroup> studentGroups = studentService.getStudentGroups();
        return ResponseEntity.ok().body(studentGroups);

    }
}
