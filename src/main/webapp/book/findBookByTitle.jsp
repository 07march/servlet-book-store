<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find book by title</title>
</head>
<body>
<p>Please, enter book title:</p>
<form action="/book">
<input type="hidden" name="operation" value="find">
    <input type="hidden" name="type" value="title">
    <input type="text" name="value" placeholder="book title">
    <button type="submit">Find</button>
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
