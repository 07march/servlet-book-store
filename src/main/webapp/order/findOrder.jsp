<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find order</title>
</head>
<body>
<c:if test="${requestScope.order != null}">
    <ul>
        <li>
            Price: ${requestScope.order.totalPrice}
            <br>
            Address: ${requestScope.order.address.address}
            <br>
            <c:forEach items="${requestScope.all2}" var="all2">
                Book: ${all2.title}
            </c:forEach>
        </li>
    </ul>
</c:if>
For return
<a href="?operation=find&type=last">
    <button>click</button>
</a>
</body>
</html>