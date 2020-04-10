<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete By Address</title>
</head>
<body>
<p>Please, enter the address to delete:</p>
<form action="/address">
    <input type="hidden" name="operation" value="delete">
    <input type="text" name="address" placeholder="Address">
    <button type="submit">Delete</button>
</form>
<br>
${requestScope.message}
<br>
<br>
If you wont to see all the addresses click:
<a href="/address?operation=find&type=all"><button>All</button></a>
<br>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
