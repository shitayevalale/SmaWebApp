package service;

import model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher>  getAllTeacherForComboBox();
    public boolean saveTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();

    List<Teacher> getAllTeacherForComboBoxWithout(Long id);
}
