<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<p>My last order:</p>
<c:if test="${requestScope.order != null}">
    <ul>
        <li>
            Store: ${requestScope.order.store.name}
            <br>
            Status: ${requestScope.order.status}
            <br>
            <a href="/order?operation=find&type=info">
                <button>Open</button>
            </a>
            <a href="/order?operation=delete">
                <button>Delete</button>
            </a>
        </li>
    </ul>
</c:if>
<c:if test="${requestScope.order == null}">
    <p> Empty!</p>
</c:if>
For return
<a href="/user">
    <button>click</button>
</a>
</body>
</html>
