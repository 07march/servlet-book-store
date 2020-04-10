<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order start</title>
</head>
<body>
<p>Change next action:</p>
${requestScope.Message}
${requestScope.deleteMessage}
<br>
<br>
<a href="/main">
    <button type="submit">Main menu</button>
</a>
<br>
<br>
<c:if test="${requestScope.flag != true}">
<form action="/order" method="post">
    <input type="hidden" name="operation" value="prepare">
    <input type="hidden" name="type" value="delivery">
    <button>Delivery</button>
</form>

<form action="/order" method="post">
    <input type="hidden" name="operation" value="prepare">
    <input type="hidden" name="type" value="pickup">
    <button>PickUp</button>
</form>

<a href="/basket"><button>Basket</button></a>
</c:if>
</body>
</html>
