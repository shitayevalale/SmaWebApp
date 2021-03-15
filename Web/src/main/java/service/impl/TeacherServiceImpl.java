package service.impl;

import Dao.TeacherDao;
import model.Teacher;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;

    }
    @Override
    public List<Teacher> getAllTeacherForComboBox() {
        return teacherDao.getAllTeacherForComboBox();
    }

    @Override
    public boolean saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Override
    public List<Teacher> getAllTeacherForComboBoxWithout(Long id) {
        return teacherDao.getAllTeacherForComboBoxWithout(id);
    }
}
