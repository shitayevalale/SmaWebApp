<%@ page import="model.Group" %>
<%@ page import="model.Subject" %>
<%@ page import="model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    Group group = (Group) request.getAttribute("group");
    List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
    List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>StudentManagementApp-Group</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
            integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
            integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<header>
    <h1>StudentManagementApp</h1>
</header>

<div class="container-fluid">
    <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingOne">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    Update Group
                </button>
            </h2>
            <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                 data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">
                    <form method="post"
                          action="/Web_war_exploded/groups?action=updateGroup&id=<%=group.getId()%>"

                          class="row row-cols-lg-auto g-3 align-items-center">
                        <div class="col-12">
                            <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
                            <div class="input-group">
                                <div class="input-group-text">@</div>
                                <input name="groupName" type="text" class="form-control"
                                       id="inlineFormInputGroupUsername"
                                       value="<%=group.getGroupName()%>" placeholder="Group Name"
                                >
                            </div>
                        </div>

                        <div class="col-12">
                            <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                            <select name="teacher" class="form-select" id="inlineFormSelectPref">
                                <option value="<%=group.getTeacher().getId()%>"
                                        selected><%=group.getTeacher().getName()%> <%=group.getTeacher().getSurname()%>
                                        <%for (Teacher teacher : teachers) {%>
                                <option value="<%=teacher.getId()%>">
                                    <%=teacher.getName()%> <%=teacher.getSurname()%>
                                </option>
                                <%}%>
                                </option>

                            </select>

                        </div>
                        <div class="col-12">
                            <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                            <select name="subject" class="form-select" id="inlineFormSelectPref">
                                <option value="<%=group.getSubject().getId()%>"
                                        selected><%=group.getSubject().getSubjectName()%>
                                        <%for (Subject subject : subjects) {%>
                                <option value="<%=subject.getId()%>">
                                    <%=subject.getSubjectName()%>
                                    <%}%>
                                </option>

                            </select>

                        </div>


                        <div class="col-12">

                        </div>

                        <div class="col-12">
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingTwo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                    Add Student
                </button>
            </h2>
            <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo"
                 data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">
                    <form
                            method="post" action="/Web_war_exploded/students?action=saveStudents"
                          class="row g-3">
                        <input type="hidden" name="groupId" value="<%=group.getId()%>">
                        <div class="col-md-6">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <div class="col-md-6">
                            <label for="surname" class="form-label">Surname</label>
                            <input type="text" class="form-control" name="surname" id="surname">
                        </div>
                        <div class="col-md-6">
                            <label for="dob" class="form-label">DOB</label>
                            <input type="date" class="form-control" name="dob" id="dob">
                        </div>
                        <div class="col-md-6">
                            <label for="seriaNum" class="form-label">Seria Number</label>
                            <input type="text" class="form-control" name="seriaNum" id="seriaNum">
                        </div>

                        <div class="col-md-6">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" name="email" id="email">
                        </div>

                        <div class="col-md-6">
                            <label for="phone" class="form-label">Phone</label>
                            <input type="text" class="form-control" name="phone" id="phone">
                        </div>
                        <div class="col-md-12" style="text-align: center">
                            <div class="form-check genderRadioBtn">
                                <input class="form-check-input" value="F" type="radio" name="gender" id="female">
                                <label class="form-check-label" for="female">
                                    Female
                                </label>
                            </div>
                            <div class="form-check genderRadioBtn">
                                <input class="form-check-input" value="M" type="radio" name="gender" id="male" checked>
                                <label class="form-check-label" for="male">
                                    Male
                                </label>
                            </div>
                            <div class="form-check genderRadioBtn">
                                <input class="form-check-input" value="Other" type="radio" name="gender" id="other" checked>
                                <label class="form-check-label" for="other">
                                    Other
                                </label>
                            </div>
                        </div>
                        <div style="text-align: center" class="col-12">
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </form>
                </div>


            </div>
            <div>


                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Surname</th>
                        <th scope="col">DOB</th>
                        <th scope="col">SeriaNum</th>
                        <th scope="col">Email</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Info</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%for (Student student : studentList) {%>
                    <tr>
                        <th scope="row"><%=student.getId()%>
                        </th>
                        <td><%=student.getName()%>
                        </td>
                        <td><%=student.getSurname()%>
                        </td>
                        <td><%=student.getDOB()%>
                        </td>
                        <td><%=student.getSeriaNum()%>
                        </td>
                        <td><%=student.getEmail()%>
                        </td>
                        <td><%=student.getPhone()%>
                        </td>
                        <td><%=student.getGender()%>
                        </td>

                        <td>
                            <a class="btn btn-info"
                               href="/Web_war_exploded/students?action=infoStudent&id=<%=student.getId()%>">Info</a>

                        </td>
                        <td>
                            <form method="post"
                                  action="/Web_war_exploded/students?action=deleteStudent&id=<%=student.getId()%>"
                                  style="margin: 0">
                                <input type="submit" value="Delete" class="btn btn-danger">
                            </form>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>



