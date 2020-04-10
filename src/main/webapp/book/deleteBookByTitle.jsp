<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete book by title</title>
</head>
<body>
<p>Please, enter the book title:</p>
<form action="/book">
    <input type="hidden" name="operation" value="delete">
    <input type="hidden" name="type" value="title">
    <input type="text" name="value" placeholder="the book title">
    <button>Enter</button>
</form>
<br>
${requestScope.message}
<br>
<br>
If you wont to see all books click:
<a href="/book?operation=find&type=all"><button>All</button></a>
<br>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
