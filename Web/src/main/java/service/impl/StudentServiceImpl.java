package service.impl;

import Dao.StudentDao;
import model.Student;
import service.StudentService;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public StudentServiceImpl (StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public boolean softDeleteStudentById(Long id) {
        return studentDao.softDeleteStudentById(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }
}
