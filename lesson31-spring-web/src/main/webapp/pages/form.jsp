
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
Add new user
<form action="/form" method="post">
    <input type="text" name="name" placeholder="user's name"> <br>
    <input type="text" name="role" placeholder="user's role"> <br>
    <input type="submit" value="Add"> <br>
</form>
</body>
</html>
