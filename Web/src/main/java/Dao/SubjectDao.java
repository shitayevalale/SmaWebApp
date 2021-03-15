package Dao;

import model.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getAllSubject();

    boolean saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    List<Subject> getAllSubjectWithout(Long id);
}
