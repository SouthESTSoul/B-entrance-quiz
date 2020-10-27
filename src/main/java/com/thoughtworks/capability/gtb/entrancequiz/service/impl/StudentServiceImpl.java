package com.thoughtworks.capability.gtb.entrancequiz.service.impl;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentServiceImpl implements StudentService {

    public static CopyOnWriteArrayList studentDB=new CopyOnWriteArrayList<Student>();

    public static void initStudentDB(){
        studentDB.clear();
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
    };
    public StudentServiceImpl() {
        initStudentDB();
    }

    @Override
    public List<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.addAll(studentDB);
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId()-o2.getId();
            }
        });
        return students;
    }
}
