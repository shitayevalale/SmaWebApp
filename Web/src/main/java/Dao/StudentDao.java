package Dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();

    boolean saveStudent(Student student);

    boolean softDeleteStudentById(Long id);

    boolean updateStudent(Student student);

    Student getStudentById(Long id);
}
