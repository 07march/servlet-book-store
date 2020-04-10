<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete city by id</title>
</head>
<body>
<p>Please, enter the city id to delete:</p>
<form action="/city">
    <input type="hidden" name="operation" value="delete">
    <input type="hidden" name="type" value="id">
    <input type="number" name="id" placeholder="city id">
    <button type="submit">Delete</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.allCities}" var="city">
    <p>id: ${city.id} city: ${city.name}</p>
</c:forEach>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
