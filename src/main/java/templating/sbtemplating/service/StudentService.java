package templating.sbtemplating.service;

import org.springframework.stereotype.Service;
import templating.sbtemplating.model.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int id) {
        for(Student student : students) {
            if(student.getId() == id)
                return student;
        }
        return null;
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
