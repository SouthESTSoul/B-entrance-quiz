package com.thoughtworks.capability.gtb.entrancequiz.service.impl;

import com.thoughtworks.capability.gtb.entrancequiz.dto.Student;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentServiceImpl implements StudentService {

    public static CopyOnWriteArrayList<Student> studentDB=new CopyOnWriteArrayList<Student>();

    public static CopyOnWriteArrayList<StudentGroup> studentGroups=new CopyOnWriteArrayList<StudentGroup>();

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
        initStudentGroups();
    }

    public void initStudentGroups(){
        studentGroups.clear();
        int groups=6;
        for (int i=0;i<groups;i++){
        studentGroups.add(new StudentGroup((1+i)+" 组"));
        }
        Collections.sort(studentGroups, new Comparator<StudentGroup>() {
            @Override
            public int compare(StudentGroup o1, StudentGroup o2) {
                return o1.getGroupName().compareTo(o2.getGroupName());
            }
        });
    }
    @Override
    public List<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.addAll(studentDB);
        sortListById(students);
        return students;
    }

    @Override
    public void groupStudentRandomly() {
        initStudentGroups();
        ArrayList<Student> students = randomSortStudent();
        int i=0;
        while (i<students.size()){
            StudentGroup studentGroup = studentGroups.get(i % studentGroups.size());
            studentGroup.add(students.get(i));
            sortListById(studentGroup.getStudents());
            i++;
        }
        System.out.println(studentGroups.toString());
    }

    //Knuth-Durstenfeld Shuffle
    public ArrayList<Student> randomSortStudent(){
        ArrayList<Student> result = new ArrayList<>();
        Student[] randomStudents =new Student[studentDB.size()];
        randomStudents= studentDB.toArray( randomStudents );
        int studentCount=randomStudents.length;
        for(int i=0;i<studentCount;i++){
            int r =new Random().nextInt(studentCount-i);
            Student temp=randomStudents[i];
            randomStudents[i]= randomStudents[r];
            randomStudents[r]=temp;
        }
        Collections.addAll(result,randomStudents);
        return result;
    }
    public void sortListById(List<Student> list){
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId()-o2.getId();
            }
        });
    }

    @Override
    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }
}
