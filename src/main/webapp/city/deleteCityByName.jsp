<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete city by name</title>
</head>
<body>
<p>Please, enter the city to delete:</p>
<form action="/city">
    <input type="hidden" name="operation" value="delete">
    <input type="hidden" name="type" value="name">
    <input type="text" name="name" placeholder="city name">
    <button type="submit">Delete</button>
</form>
<br>
${requestScope.message}
<br>
<br>
If you wont to see all the cities click:
<a href="/city?operation=find&type=all"><button>All</button></a>
<br>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
