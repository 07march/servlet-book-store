<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find All Books By Author Name</title>
</head>
<body>
<p>All books by author name:</p>
<form action="/book">
    <input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="allByAuthorName">
    <input type="text" name="value" placeholder="author name">
    <ul style="list-style: decimal">
        <c:forEach items="${requestScope.books}" var="books">
           <li>${books.title}</li>
        </c:forEach>
    </ul>
    <button>Find</button>
   </form>
<br>
<br>
${requestScope.message}
<br>
<br>
<a href="/admin">
    <button>Return</button>
</a>
<br>
</body>
</html>
