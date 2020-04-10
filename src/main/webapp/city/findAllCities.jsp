<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find all cities</title>
</head>
<body>
<p>All cities:</p>
<ul style="list-style: decimal">
    <c:forEach items="${requestScope.cities}" var="city">
        <li>${city.name}</li>
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
For return on deleteCityByName page click
<a href="/city?operation=delete&type=name"><button>here</button></a>.
<br>
</body>
</html>
