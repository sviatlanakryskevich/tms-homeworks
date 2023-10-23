
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<a href="/form?lang=en">ENG</a>
<a href="/form?lang=ru">RUS</a>
<sp:message code="label.title"/> <br>
Add new user
<form action="/form" method="post">
    <input type="text" name="name" placeholder="user's name"> ${nameError}<br>
    <input type="text" name="role" placeholder="user's role">${roleError} <br>
    <input type="submit" value="Add"> <br>
</form>

<ol>
    <c:forEach var="user" items="${users}">
        <li>${user.name} - ${user.role}</li>
    </c:forEach>
</ol>
</body>
</html>
