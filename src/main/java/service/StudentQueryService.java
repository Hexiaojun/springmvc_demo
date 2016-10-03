package service;

import org.springframework.stereotype.Service;
import po.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenglei on 2016/10/3.
 */

@Service("studentService")
public class StudentQueryService {

    private static List<Student> students = new ArrayList<>();

    static {
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("stu1");
        students.add(student1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("stu2");
        students.add(student2);

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("stu3");
        students.add(student3);
    }

    public Student getStuNameById(Integer id) {
        Student stu = null;
        for (Student student : students) {
            if (student.getId() == id) {
                stu = student;
                break;
            }
        }
        return stu;
    }

    public void addStu(Student student) {
        students.add(student);
    }
}
