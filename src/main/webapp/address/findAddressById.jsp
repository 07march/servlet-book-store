<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find Address By Id</title>
</head>
<body>
<p>Search address by id:</p>
<br>
<form action="/address">
    <input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="id">
    <input type="number" name="value" placeholder="address id">
    <button>Find</button>
</form>
<br>
${requestScope.message}
<br>
<c:forEach items="${requestScope.allAddresses}" var="address">
    <p>id: ${address.id} address: ${address.address}</p>
    ${requestScope.message}
</c:forEach>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</body>
</html>
