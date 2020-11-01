package com.thoughtworks.capability.gtb.entrancequiz;

import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import com.thoughtworks.capability.gtb.entrancequiz.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

        mockMVC.perform(post("/students/groups")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }
}
