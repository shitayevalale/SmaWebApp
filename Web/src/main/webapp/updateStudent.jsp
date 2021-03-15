<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>StudentManagementApp</title>
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
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <h1>StudentManagementApp</h1>
</header>

<div class="container-fluid">

    <form class="row g-3" method="post"  action="/Web_war_exploded/students?action=updateStudent&id=<%=student.getId()%>">

        <div class="col-md-6">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" name="name" id="name" value="<%=student.getName()%>">
        </div>
        <div class="col-md-6">
            <label for="surname" class="form-label">Surname</label>
            <input type="text" class="form-control" name="surname" id="surname" value="<%=student.getSurname()%>">
        </div>
        <div class="col-md-6">
            <label for="dob" class="form-label">DOB</label>
            <input type="date" class="form-control" name="dob" id="dob" value="<%=student.getDOB()%>">
        </div>
        <div class="col-md-6">
            <label for="seriaNum" class="form-label">Seria Number</label>
            <input type="text" class="form-control" name="seriaNum" id="seriaNum" value="<%=student.getSeriaNum()%>">
        </div>

        <div class="col-md-6">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" name="email" id="email" value="<%=student.getEmail()%>">
        </div>

        <div class="col-md-6">
            <label for="phone" class="form-label">Phone</label>
            <input type="text" class="form-control" name="phone" id="phone" value="<%=student.getPhone()%>">
        </div>

   <div class="col-md-12" style="text-align: center">
        <div class="form-check genderRadioBtn">
            <input class="form-check-input"  type="radio" name="gender" id="female" value="<%=student.getGender()%>">
            <label class="form-check-label" for="female">
                Female
            </label>
        </div>
        <div class="form-check genderRadioBtn">
            <input class="form-check-input" type="radio" name="gender" id="male" checked value="<%=student.getGender()%>">
            <label class="form-check-label" for="male">
                Male
            </label>
        </div>
        <div class="form-check genderRadioBtn">
            <input class="form-check-input" type="radio" name="gender" id="other" checked value="<%=student.getGender()%>">
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
</body>
</html>



