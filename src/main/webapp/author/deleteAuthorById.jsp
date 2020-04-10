<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Author By Id</title>
</head>
<body>
<p>Please, enter author id to delete:</p>
<form action="/author">
    <input type="hidden" name="operation" value="delete">
    <input type="number" name="id" placeholder="author id">
    <button type="submit">Delete</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.all}" var="author">
    <p>id: ${author.id} name: ${author.name}</p>
    ${requestScope.message}
</c:forEach>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
