<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update city name</title>
</head>
<body>
<P>Please, enter id and new name:</P>
<form action="/city">
    ${requestScope.all}
    <input type="hidden" name="operation" value="update">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="value" placeholder="new city name">
    <button>Update</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.allCities}" var="city">
    <p>id: ${city.id} city: ${city.name}</p>
</c:forEach>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</body>
</html>
