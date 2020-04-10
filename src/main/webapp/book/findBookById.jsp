<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find book by id</title>
</head>
<body>
<c:if test="${requestScope.isAdmin}">
<p>Please, enter book id:</p>
<form action="/book">
    <input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="id">
    <input type="number" name="value" placeholder="book id">
    <button type="submit">Find</button>
</form>
</body>
<br>
    ${requestScope.message}
<br>
<c:forEach items="${requestScope.allBooks}" var="book">
    <p> id: ${book.id} title: ${book.title}</p>
    ${requestScope.message}
</c:forEach>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</c:if>

<c:if test="${!requestScope.isAdmin}">
    <p>Title: ${requestScope.book.title}</p>
    <p>Author: ${requestScope.book.author.name}</p>
    <p>Price: ${requestScope.book.price}</p>
    <p>Description: ${requestScope.book.description}</p>
    <c:if test="${sessionScope.currentUser != null}">
        <form action="/basket" method="post">
            <input type="hidden" name="operation" value="create">
            <input type="hidden" name="id" value="${requestScope.book.id}">
            <button>Add to basket</button>
        </form>
    </c:if>
    <a href="/book?operation=find&type=all">
        <button>Return</button>
    </a>
</c:if>
</html>
