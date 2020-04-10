<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address By Id</title>
</head>
<body>
<P>Please, enter id and new address:</P>
<form action="/address">
    <input type="hidden" name="operation" value="update">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="value" placeholder="new address">
    <button>Update</button>
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
<br>
</body>
</html>
