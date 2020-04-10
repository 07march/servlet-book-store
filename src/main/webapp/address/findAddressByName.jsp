<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Address By Name</title>
</head>
<body>
<p>Please, enter address name:</p>
<br>
<form action="/address">
    <input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="name">
    <input type="text" name="value" placeholder="address name">
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
