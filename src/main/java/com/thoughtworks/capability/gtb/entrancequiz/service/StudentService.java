package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {
    public static ConcurrentHashMap studentDB=new ConcurrentHashMap<Integer,Student>();

}
