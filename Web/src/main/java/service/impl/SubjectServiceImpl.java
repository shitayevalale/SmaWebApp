package service.impl;

import Dao.SubjectDao;
import model.Subject;
import service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao ;
    public SubjectServiceImpl (SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Override
    public boolean saveSubject(Subject subject) {
        return subjectDao.saveSubject(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectDao.getSubjectById(id);
    }

    @Override
    public List<Subject> getAllSubjectWithout(Long id) {
        return subjectDao.getAllSubjectWithout(id);
    }
}
