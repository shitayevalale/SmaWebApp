package Dao.impl;

import Dao.GroupDao;
import config.DBConfig;
import model.Group;
import model.Subject;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    @Override
    public List<Group> getAllGroups() {

        List<Group> groups = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select g.id group_id,g.group_name,t.t_id teacher_id,t.t_name,t.t_surname,s.id subject_id, s.subject_name\n" +
                "                     From group1 g\n" +
                "                      Inner Join teacher t\n" +
                "                      on t.t_id=g.teacher_t_id\n" +
                "                      Inner join subjects s\n" +
                "                      on\n" +
                "                      s.id=g.subject_id Where g.active=1";
        try {
            c = DBConfig.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Group group = new Group();
                    group.setId(rs.getLong("group_id"));
                    group.setGroupName(rs.getString("group_name"));

                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("teacher_id"));
                    teacher.setName(rs.getString("t_name"));
                    teacher.setSurname(rs.getString("t_surname"));

                    Subject subject = new Subject();
                    subject.setId(rs.getLong("subject_id"));
                    subject.setSubjectName(rs.getString("subject_name"));
                    group.setTeacher(teacher);
                    group.setSubject(subject);

                    groups.add(group);
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

        return groups;

    }

    @Override
    public boolean saveGroup(Group group) {

        boolean isAdded = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = " INSERT INTO group1(group_name,teacher_t_id,subject_id)VALUES (?,?,?)";
        c = DBConfig.getconnection();
        if (c != null) {
            try {
                ps = c.prepareStatement(sql);
                ps.setString(1, group.getGroupName());
                ps.setLong(2, group.getTeacher().getId());
                ps.setLong(3, group.getSubject().getId());
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
    public Group getGroupInfoById(Long groupId) {

        Group group = new Group();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Select g.id group_id,g.group_name,t.t_id teacher_id,t.t_name,t.t_surname,s.id subject_id, s.subject_name\n" +
                "                     From group1 g\n" +
                "                      Inner Join teacher t\n" +
                "                      on t.t_id=g.teacher_t_id\n" +
                "                      Inner join subjects s\n" +
                "                      on\n" +
                "                      s.id=g.subject_id Where g.active=1 and g.id=" + groupId;
        try {
            c = DBConfig.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    group.setId(rs.getLong("group_id"));
                    group.setGroupName(rs.getString("group_name"));

                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("teacher_id"));
                    teacher.setName(rs.getString("t_name"));
                    teacher.setSurname(rs.getString("t_surname"));

                    Subject subject = new Subject();
                    subject.setId(rs.getLong("subject_id"));
                    subject.setSubjectName(rs.getString("subject_name"));
                    group.setTeacher(teacher);
                    group.setSubject(subject);

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

        return group;

    }

    @Override
    public boolean updateGroup(Group group) {
            boolean isUpdated = false;
            Connection c = null;
            PreparedStatement ps = null;
            String updateGroup= "UPDATE group1 g SET g.group_name = ?,g.teacher_t_id = ?,g.subject_id = ? WHERE g.id=? ";
            c = DBConfig.getconnection();
            if (c != null) {
                try {
                    ps = c.prepareStatement(updateGroup);
                    ps.setString(1, group.getGroupName());
                    ps.setLong(2, group.getTeacher().getId());
                    ps.setLong(3, group.getSubject().getId());
                    ps.setLong(4,group.getId());
                    ps.execute();
                    isUpdated = true;
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
            return isUpdated;
        }

    @Override
    public boolean softDeleteGroupById(Long id) {

            boolean isDeleted = false;
            Connection c = null;
            PreparedStatement ps = null;
            String sql = "  UPDATE group1 SET active=0 WHERE id=?";
            try {
                c = DBConfig.getconnection();
                if (c != null) {
                    ps = c.prepareStatement(sql);
                    ps.setLong(1, id);
                    ps.execute();
                    isDeleted = true;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    ps.close();
                    c.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            return isDeleted;


        };
    }





