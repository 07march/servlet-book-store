<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find city by name</title>
</head>
<body>
<p>Please, enter the city name:</p>
<form action="/city">
    <input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="name">
    <input type="text" name="value" placeholder="city name">
    <button>Find</button>
</form>
<br>
${requestScope.message}
<br>
<br>
<a href="/admin">
    <button>Return</button>
</a>
</body>
</html>
