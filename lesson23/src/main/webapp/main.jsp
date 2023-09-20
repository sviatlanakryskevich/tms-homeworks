<%@ page import="java.util.List" %>
<%@ page import="com.skv.tms.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <div style="width: 500px; min-heigh: 500px; border: 2px black solid; padding: 10px; margin: 20px auto; background-color: honeydew;">
        <form method="post" action="/add">
            <h2>Form for add new student:</h2><hr>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br><br>
            <label for="age">Age:</label>
            <input type="number" min="15" max="100" id="age" name="age" required><br><br>
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required><br><br>
            <input class="add" type="submit" value="Add new student">
        </form>
        <h2>Student's list:</h2> <hr>
        <ol>
            <%
                Object studentsOpt = request.getAttribute("students");

                if(studentsOpt !=null){
                    List<Student> students = (List<Student>)request.getAttribute("students");
                    for(Student student : students){
                        out.print("<form method='post' action= '/delete' >");
                        out.print("<li>" + "Student: "+ student.getName() + ", age:" + student.getAge()
                                + ", city:" + student.getCity() + ".");
                        out.print("<input type='hidden' name='deleteId' value='" + student.getId() + "'>");
                        out.print("<input class='delete' type='submit' value='delete'>");
                        out.print("</li>");
                        out.print("</form>");
                    }
                }
            %>
        </ol>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>
