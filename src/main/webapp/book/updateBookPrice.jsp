<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book rrice</title>
</head>
<body>
<P>Please, enter id and new price:</P>
<form action="/book">
    <input type="hidden" name="operation" value="update">
    <input type="hidden" name="type" value="price">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="value" placeholder="new book price">
    <button>Update</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.allBooks}" var="book">
    <p>id: ${book.id} title: ${book.title}</p>
    ${requestScope.message}
</c:forEach>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</body>
</html>
