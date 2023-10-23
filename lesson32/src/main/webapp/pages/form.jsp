
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Form</title>
</head>
<body>
<a href="/form?lang=en">ENG</a>
<a href="/form?lang=ru">RUS</a>
<sp:message code="label.title"/> <br>
Add new user
<sf:form action="/form" method="post" modelAttribute="user">
    <sf:input type="text" path="name"/><sf:errors path="name"/> <br>
    <sf:input type="text" path="role"/><sf:errors path="role"/><br>
    <sf:button>Add</sf:button>
</sf:form>

<ol>
    <c:forEach var="user" items="${users}">
        <li>${user.name} - ${user.role}</li>
    </c:forEach>
</ol>
</body>
</html>
