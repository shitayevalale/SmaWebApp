package servlet;

import Dao.GroupDao;
import Dao.StudentDao;
import Dao.SubjectDao;
import Dao.TeacherDao;
import Dao.impl.GroupDaoImpl;
import Dao.impl.StudentDaoImpl;
import Dao.impl.SubjectDaoImpl;
import Dao.impl.TeacherDaoImpl;
import model.Group;
import model.Student;
import model.Subject;
import model.Teacher;
import service.GroupService;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;
import service.impl.GroupServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.SubjectServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/groups", name = "GroupServlet")
public class GroupServlet extends HttpServlet {
    GroupDao groupDao = new GroupDaoImpl();
    GroupService groupService = new GroupServiceImpl(groupDao);

    TeacherDao teacherDAO = new TeacherDaoImpl();
    TeacherService teacherService = new TeacherServiceImpl(teacherDAO);

    SubjectDao subjectDAO = new SubjectDaoImpl();
    SubjectService subjectService = new SubjectServiceImpl(subjectDAO);

    StudentDao studentDao=new StudentDaoImpl();
    StudentService studentService=new StudentServiceImpl(studentDao);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            String action = null;
            String address = null;
            if (request.getParameter("action") != null) {
                action = request.getParameter("action");
            }if (action.equalsIgnoreCase("saveGroup")) {

                System.out.println(request.getParameter("groupName"));
                System.out.println(request.getParameter("teacher"));
                System.out.println(request.getParameter("subject"));
                Group group = new Group();
                group.setGroupName(request.getParameter("groupName"));
                Teacher teacher = new Teacher();
                teacher.setId(Long.parseLong(request.getParameter("teacher")));
                Subject subject = new Subject();
                subject.setId(Long.parseLong(request.getParameter("subject")));
                group.setTeacher(teacher);
                group.setSubject(subject);
                groupService.saveGroup(group);
                response.sendRedirect("http://localhost:8080/Web_war_exploded/groups?action=allGroups");
            } else if (action.equalsIgnoreCase("allGroups")) {

                request.setAttribute("groupList", groupService.getAllGroups());
                request.setAttribute("teacherList", teacherService.getAllTeacherForComboBox());
                request.setAttribute("subjectList", subjectService.getAllSubject());
                address = "/groupPage.jsp";

            }else if (action.equalsIgnoreCase("infoGroup")) {

                Long id = Long.valueOf(request.getParameter("id"));
                Group group = groupService.getGroupInfoById(id);
                request.setAttribute("group", group);
                request.setAttribute("teachers", teacherService.getAllTeacherForComboBoxWithout(group.getTeacher().getId()));
                request.setAttribute("subjects", subjectService.getAllSubjectWithout(group.getSubject().getId()));
                request.setAttribute("studentList", studentService.getAllStudents());
                address = "/groupInfo.jsp";
            } else if (action.equalsIgnoreCase("updateGroup")) {

                Long id = Long.valueOf(request.getParameter("id"));
                Group group = new Group();
                group.setId(id);
                group.setGroupName(request.getParameter("groupName"));
                Teacher teacher = new Teacher();
                teacher.setId(Long.parseLong(request.getParameter("teacher")));
                Subject subject = new Subject();
                subject.setId(Long.parseLong(request.getParameter("subject")));
                group.setTeacher(teacher);
                group.setSubject(subject);
                groupService.updateGroup(group);
                response.sendRedirect("http://localhost:8080/Web_war_exploded/groups?action=infoGroup&id="+ group.getId());
            }else if (action.equalsIgnoreCase("deleteGroup")) {
                Long id = Long.valueOf(request.getParameter("id"));
                groupService.softDeleteGroupById(id);
                response.sendRedirect("http://localhost:8080/Web_war_exploded/groups?action=allGroups");

            }
            if(address!=null){
            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);}
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

