<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find All Addresses</title>
</head>
<body>
<p>All addresses:</p>
<ul style="list-style: decimal">
    <c:forEach items="${requestScope.all}" var="address">
        <li>${address.address}</li>
    </c:forEach>
</ul>
<br>
${requestScope.message}
<br>
<br>
For return on methods page click
<a href="/admin"><button>here</button></a>.
<br>
<br>
For return on deleteAddressByName page click
<a href="/address?operation=delete"><button>here</button></a>.
<br>
</body>
</html>
