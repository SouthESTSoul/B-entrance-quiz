package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {
    public static ConcurrentHashMap studentDB=new ConcurrentHashMap<Integer,Student>();

    public StudentService() {
        studentDB.put(1,"成吉思汗");
        studentDB.put(2,"鲁班七号");
        studentDB.put(3,"太乙真人");
        studentDB.put(4,"钟无艳");
        studentDB.put(5,"花木兰");
        studentDB.put(6,"雅典娜");
        studentDB.put(7,"芈月");
        studentDB.put(8,"白起");
        studentDB.put(9,"刘禅");
        studentDB.put(10,"庄周");
        studentDB.put(11,"马超");
        studentDB.put(12,"刘备");
        studentDB.put(13,"哪吒");
        studentDB.put(14,"大桥");
        studentDB.put(15,"蔡文姬");
    }
}
