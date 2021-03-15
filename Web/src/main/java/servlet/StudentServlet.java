package servlet;

import Dao.GroupDao;
import Dao.StudentDao;
import Dao.impl.GroupDaoImpl;
import Dao.impl.StudentDaoImpl;
import model.Group;
import model.Student;
import service.GroupService;
import service.StudentService;
import service.impl.GroupServiceImpl;
import service.impl.StudentServiceImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/students", name = "StudentServlet")
public class StudentServlet extends HttpServlet {

    StudentDao studentDao=new StudentDaoImpl();
    StudentService studentService=new StudentServiceImpl(studentDao);
    GroupDao groupDao = new GroupDaoImpl();
    GroupService groupService = new GroupServiceImpl(groupDao);
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
            }if (action.equalsIgnoreCase("saveStudents")) {

                Student student = new Student();
                student.setName((request.getParameter("name")));
                student.setSurname(request.getParameter("surname"));
                student.setDOB(request.getParameter("dob"));
                student.setSeriaNum(request.getParameter("seriaNum"));
                student.setEmail(request.getParameter("email"));
                student.setPhone(request.getParameter("phone"));
                student.setGender(request.getParameter("gender"));

                Group group=new Group();
                group.setId(Long.parseLong(request.getParameter("groupId")));
                 student.setGroup(group);

                studentService.saveStudent(student);
                address = "/groupInfo.jsp";
                response.sendRedirect("http://localhost:8080/Web_war_exploded/groups?action=allGroups");
            }
            else if (action.equalsIgnoreCase("deleteStudent")) {
                Long id = Long.valueOf(request.getParameter("id"));
                Student student = new Student();
                studentService.softDeleteStudentById(id);
                response.sendRedirect("http://localhost:8080/Web_war_exploded/groups?action=allGroups");
            }  else if (action.equalsIgnoreCase("infoStudent")) {

                Long id = Long.valueOf(request.getParameter("id"));
                System.out.println(studentService.getStudentById(id));
                Student student = studentService.getStudentById(id);
                request.setAttribute("student", student);
                address = "/updateStudent.jsp";
            }
            else if (action.equalsIgnoreCase("updateStudent")) {

               Long id = Long.valueOf(request.getParameter("id"));
                Student student = new Student();
                student.setId(id);
                student.setName((request.getParameter("name")));
                student.setSurname(request.getParameter("surname"));
                student.setDOB(request.getParameter("dob"));
                student.setSeriaNum(request.getParameter("seriaNum"));
                student.setEmail(request.getParameter("email"));
                student.setPhone(request.getParameter("phone"));
                student.setGender(request.getParameter("gender"));
                studentService.updateStudent(student);
                response.sendRedirect("http://localhost:8080/Web_war_exploded/groups?action=allGroups");
            }

            if(address != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

