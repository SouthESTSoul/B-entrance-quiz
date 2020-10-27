package com.thoughtworks.capability.gtb.entrancequiz.service.impl;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentServiceImpl implements StudentService {

    public static CopyOnWriteArrayList studentDB=new CopyOnWriteArrayList<Student>();

    public StudentServiceImpl() {
        studentDB.add(new Student(1,"成吉思汗"));
        studentDB.add(new Student(2,"鲁班七号"));
        studentDB.add(new Student(3,"太乙真人"));
        studentDB.add(new Student(4,"钟无艳"));
        studentDB.add(new Student(5,"花木兰"));
        studentDB.add(new Student(6,"雅典娜"));
        studentDB.add(new Student(7,"芈月"));
        studentDB.add(new Student(8,"白起"));
        studentDB.add(new Student(9,"刘禅"));
        studentDB.add(new Student(10,"庄周"));
        studentDB.add(new Student(11,"马超"));
        studentDB.add(new Student(12,"刘备"));
        studentDB.add(new Student(13,"哪吒"));
        studentDB.add(new Student(14,"大桥"));
        studentDB.add(new Student(15,"蔡文姬"));
    }

    @Override
    public List<Student> getStudents() {

        return studentDB;
    }
}
