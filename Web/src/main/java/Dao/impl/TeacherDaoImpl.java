package Dao.impl;

import Dao.TeacherDao;
import config.DBConfig;
import model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public List<Teacher> getAllTeacherForComboBox() {

            List<Teacher> teachers = new ArrayList<>();
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT t.t_id,t.t_name,t.t_surname FROM teacher t WHERE active=1";


            try {
                c = DBConfig.getconnection();
                if (c != null) {
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Teacher teacher = new Teacher();
                        teacher.setId(rs.getLong("t_id"));
                        teacher.setName(rs.getString("t_name"));
                        teacher.setSurname(rs.getString("t_surname"));
                        teachers.add(teacher);
                        System.out.println(teacher);
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

            return teachers;

        }

    @Override
    public boolean saveTeacher(Teacher teacher) {


            boolean isAdded = false;
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String insertIntoTeacherContactInfo = "INSERT INTO t_contact_info(email,phone) VALUES (?,?)";
            String getlastTeacherInfoId = "SELECT MAX(id) id FROM t_contact_info";
            String insertIntoTeacher = "Insert Into teacher(t_name,t_surname,t_age,t_seriaNum,gender,contact_info_id ) VALUES (?,?,?,?,?,?)";


            c = DBConfig.getconnection();
            if (c != null) {
                try {
                    ps = c.prepareStatement(insertIntoTeacherContactInfo);
                    ps.setString(1, teacher.getEmail());
                    ps.setString(2, teacher.getPhone());
                    ps.execute();

                    ps = c.prepareStatement(getlastTeacherInfoId);
                    rs = ps.executeQuery();
                    long lastTeacherInfoId = 0;
                    if (rs.next()) {
                        lastTeacherInfoId = rs.getLong("id");
                    }

                    ps = c.prepareStatement(insertIntoTeacher);
                    ps.setString(1, teacher.getName());
                    ps.setString(2, teacher.getSurname());
                    ps.setString(3, teacher.getDOB());
                    ps.setString(4, teacher.getSeriaNum());
                    ps.setString(5, teacher.getGender());
                    ps.setLong(6, lastTeacherInfoId);

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
    public List<Teacher> getAllTeachers() {

            List<Teacher> teachers = new ArrayList<>();
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "  SELECT\n" +
                    "                t.t_id id,\n" +
                    "                t.t_name name,\n" +
                    "                t.t_surname surname,\n" +
                    "                t.t_age age,\n" +
                    "                t.t_seriaNum seria_num,\n" +
                    "                tci.email email,\n" +
                    "                tci.phone phone\n" +
                    "                FROM\n" +
                    "                teacher t \n" +
                    "                LEFT JOIN t_contact_info tci ON t.contact_info_id = tci.id WHERE t.active = 1";


            try {
                c = DBConfig.getconnection();
                if (c != null) {
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Teacher teacher = new Teacher();
                        teacher.setId(rs.getLong("id"));
                        teacher.setName(rs.getString("name"));
                        teacher.setSurname(rs.getString("surname"));
                        teacher.setSeriaNum(rs.getString("seria_num"));
                        teacher.setDOB(rs.getString("age"));
                        teacher.setEmail(rs.getString("email"));
                        teacher.setPhone(rs.getString("phone"));
                        teachers.add(teacher);
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

            return teachers;

        }

    @Override
    public List<Teacher> getAllTeacherForComboBoxWithout(Long id) {


            List<Teacher> teachers = new ArrayList<>();
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT t.t_id,t.t_name,t.t_surname FROM teacher t WHERE active=1 AND t.t_id!=" + id;


            try {
                c = DBConfig.getconnection();
                if (c != null) {
                    ps = c.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Teacher teacher = new Teacher();
                        teacher.setId(rs.getLong("t_id"));
                        teacher.setName(rs.getString("t_name"));
                        teacher.setSurname(rs.getString("t_surname"));
                        teachers.add(teacher);
                        System.out.println(teacher);
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

            return teachers;

        }
    }




