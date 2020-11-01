package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import com.thoughtworks.capability.gtb.entrancequiz.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMVC;
    @Autowired
    StudentService studentService;

    @Test
    void should_return_all_students() throws Exception {
        StudentServiceImpl.initStudentDB();
        mockMVC.perform(get("/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].id",is(1)));
    }

    @Test
    void should_group_students_randomly() throws Exception {

        mockMVC.perform(post("/student/groups")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201));
        StudentGroup firstGroup=studentService.getStudentGroups().get(0);
        Assertions.assertEquals(firstGroup.getStudents().size(),3);
    }

    @Test
    void should_get_all_student_groups() throws Exception {
        mockMVC.perform(post("/student/groups"));
        mockMVC.perform(get("/student/groups")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].students", hasSize(3)))
                .andExpect(jsonPath("$[5].students", hasSize(2)))
        ;

    }
}
