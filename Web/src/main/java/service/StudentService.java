package service;

import model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    boolean saveStudent(Student student);

    boolean softDeleteStudentById(Long id);

    boolean updateStudent(Student student);

    Student getStudentById(Long id);
}
