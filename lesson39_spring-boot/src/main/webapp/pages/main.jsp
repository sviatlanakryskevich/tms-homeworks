<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Movie</title>
</head>
<body>
<form action="/save" method="post">
    <input type="text" name="name" placeholder="name of movie"><br>
    <input type="number" min="1950" max="2023" step="1" name="yearRelease" placeholder="release" /><br>
    <input type="number" min="1.0" max="10.0" name="rating" step="0.2"placeholder="rating movie"><br>

    <c:forEach items="${genres}" var="genre">
        <input type="radio" name="genre" value="${genre.name()}">${genre.name()}<br>
    </c:forEach>

    <input type="submit" value="Save"><br>
</form>

<ul>
    <c:forEach items="${movies}" var="movie">
        <li>Name: ${movie.name} Genre: ${movie.genre} Release: ${movie.yearRelease} Rating: ${movie.rating}</li>
    </c:forEach>
</ul>

<%--<form action="/get" method="get">
    <input type="text" name="name" placeholder="name of movie"><br>
    <input type="submit" value="Find">
</form>--%>
</body>
</html>
