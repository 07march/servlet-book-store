<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>
<p>Please, enter new book:</p>
<form action="" method="post">
    <input type="text" name="price" placeholder="Price">
    <input type="text" name="title" placeholder="Title">
    <input type="text" name="description" placeholder="Description">
    <select name="author">
        <c:forEach items="${requestScope.authors}" var="author">
            <option value="${author.name}">${author.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Enter</button>
</form>
${requestScope.message}
<br>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
