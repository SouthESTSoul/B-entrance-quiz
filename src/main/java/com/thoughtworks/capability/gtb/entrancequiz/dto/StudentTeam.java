package com.thoughtworks.capability.gtb.entrancequiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentTeam {
    String teamName;
    List<Student> studentTeam=new ArrayList<>();
    void add(Student student){
        studentTeam.add(student);
    }
}
