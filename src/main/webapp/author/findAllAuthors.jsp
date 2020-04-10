<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find all authors</title>
</head>
<body>
<p>All authors:</p>
<ul style="list-style: decimal">
    <c:forEach items="${requestScope.authors}" var="author">
        <li>${author.name}</li>
    </c:forEach>
</ul>
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
