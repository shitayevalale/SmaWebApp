package Dao.impl;

import Dao.SubjectDao;
import config.DBConfig;
import model.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {
    @Override
    public List<Subject> getAllSubject() {


        List<Subject> subjects = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select s.id,s.subject_name From subjects s Where s.active=1";
        try {
            c = DBConfig.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setId(rs.getLong("id"));
                    subject.setSubjectName(rs.getString("subject_name"));
                    subjects.add(subject);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                c.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }

        return subjects;

    }

    @Override
    public boolean saveSubject(Subject subject) {
            boolean isAdded = false;
            Connection c = null;
            PreparedStatement ps = null;
            String sql = "Insert Into subjects (subject_name) VALUES(?)";
            c = DBConfig.getconnection();
            if (c != null) {
                try {
                    ps = c.prepareStatement(sql);
                    ps.setString(1, subject.getSubjectName());
                    ps.execute();
                    isAdded = true;
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                } finally {
                    try {
                        ps.close();
                        c.close();
                    } catch (SQLException ex) {
                        System.err.println(ex.getMessage());

                    }
                }
            }
            return isAdded;

        }

    @Override
    public Subject getSubjectById(Long id) {

            Subject subject = new Subject();
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT id,subject_name FROM subjects WHERE active=1 and id=?";
            try {
                c = DBConfig.getconnection();
                if (c != null) {
                    ps = c.prepareStatement(sql);
                    ps.setLong(1, id);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        subject.setId(rs.getLong("id"));
                        subject.setSubjectName(rs.getString("subject_name"));

                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    ps.close();
                    c.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());

                }
            }

            return subject;
        }

    @Override
    public List<Subject> getAllSubjectWithout(Long id) {
        List<Subject> subjects = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select s.id,s.subject_name From subjects s Where s.active=1 AND s.id!="+id;
        try {
            c = DBConfig.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Subject subject = new Subject();
                    subject.setId(rs.getLong("id"));
                    subject.setSubjectName(rs.getString("subject_name"));
                    subjects.add(subject);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ps.close();
                c.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());

            }
        }

        return subjects;
    }
}


