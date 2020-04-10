<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Author By Id</title>
</head>
<body>
<p>Please, enter author id:</p>
<form action="/author">
    <input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="id">
    <input type="number" name="value" placeholder="author id">
    <button>Find</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.all}" var="author">
    <p>id: ${author.id} name: ${author.name}</p>
</c:forEach>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</body>
</html>
