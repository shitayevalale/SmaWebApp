package Dao;

import model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getAllTeacherForComboBox();

    boolean saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    List<Teacher> getAllTeacherForComboBoxWithout(Long id);
}
