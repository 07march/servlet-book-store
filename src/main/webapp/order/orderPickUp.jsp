<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order Pick Up</title>
</head>
<body>
<form action="/order" method="post">
    <input type="hidden" name="operation" value="create">
    <input type="hidden" name="type" value="pickup">
    <select name="store">
        <c:forEach items="${requestScope.stores}" var="store">
            <option value="${store.name}">${store.name}</option>
        </c:forEach>
    </select>
    <button>Create</button>
</form>

</body>
</html>
