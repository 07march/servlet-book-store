<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Author By Id</title>
</head>
<body>
<p>Please, enter author id and new name:</p>
<form action="/author">
    <input type="hidden" name="operation" value="update">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="value" placeholder="new author name">
    <button>Update</button>
    </form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.all}" var="author">
    <p>id: ${author.id} name: ${author.name}</p>
    ${requestScope.message}
</c:forEach>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</body>
</html>
