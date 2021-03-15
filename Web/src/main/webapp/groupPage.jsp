<%@ page import="model.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Teacher" %>
<%@ page import="model.Subject" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    List<Group> groupList = (List<Group>) request.getAttribute("groupList");
    List<Teacher> teacherList = (List<Teacher>) request.getAttribute("teacherList");
    List<Subject> subjectList = (List<Subject>) request.getAttribute("subjectList");
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
    <h1>StudentManagementApp-Group</h1>
</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand \" href="#"><b></b></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 myNavbar ">
                <li class="nav-item homePage">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Students</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Teachers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Subjects</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Groups</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Payments</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <p style="margin-top: 1%">
        <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            ADD GROUP
        </a>
    </p>
    <div style="text-align: center" class="collapse" id="collapseExample">
        <div style="display: inline-block" class="card card-body">


            <form class="row row-cols-lg-auto g-3 align-items-center" method="post"
                  action="/Web_war_exploded/groups?action=saveGroup">
                <div class="col-12">
                    <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
                    <div class="input-group">
                        <div class="input-group-text">@</div>
                        <input type="text" class="form-control" id="inlineFormInputGroupUsername" name="groupName"
                               placeholder="Group Name">
                    </div>
                </div>

                <div class="col-12">
                    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                    <select name="teacher" class="form-select" id="inlineFormSelectPref">
                        <option value="0" selected disabled>Teacher</option>
                        <%for (Teacher teacher : teacherList) {%>
                        <option value="<%=teacher.getId()%>">
                            <%=teacher.getName()%> <%=teacher.getSurname()%>
                        </option>
                        <%}%>
                    </select>

                </div>
                <div class="col-12">
                    <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                    <select name="subject" class="form-select" id="inlineFormSelectPref">
                        <option value="0" selected disabled>Subject...</option>

                        <%for (Subject subject : subjectList) {%>
                        <option value="<%=subject.getId()%>">
                                <%=subject.getSubjectName()%>
                        </option>
                        <%}%>
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
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Group Name</th>
            <th scope="col">Teacher</th>
            <th scope="col">Subject</th>
            <th scope="col">Info</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>


        <%for (Group group : groupList) {%>
        <tr>

            <td><%=group.getId()%>
            </td>
            <td><%=group.getGroupName()%>
            </td>
            <td><%=group.getTeacher().getName()%> <%=group.getTeacher().getSurname()%>
            </td>
            <td><%=group.getSubject().getSubjectName()%>
            </td>
            <td>
                <a class="btn btn-info" href="/Web_war_exploded/groups?action=infoGroup&id=<%=group.getId()%>">Info</a>

            </td>
            <td>
                <form method="post" action="/Web_war_exploded/groups?action=deleteGroup&id=<%=group.getId()%>" style="margin: 0">
                    <input type="submit" value="Delete" class="btn btn-danger">
                </form>
            </td>

        </tr>
        <%}%>


        </tbody>
    </table>
</div>


</body>
</html>



