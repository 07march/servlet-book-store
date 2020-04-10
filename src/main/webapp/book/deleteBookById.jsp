<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete book by id</title>
</head>
<body>
<p>Please, enter the book id to delete:</p>
<form action="/book">
    <input type="hidden" name="operation" value="delete">
    <input type="hidden" name="type" value="id">
    <input type="number" name="value" placeholder="the book id">
    <button>Enter</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.allBooks}" var="book">
    <p> id: ${book.id} title: ${book.title}</p>
    ${requestScope.message}
</c:forEach>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
