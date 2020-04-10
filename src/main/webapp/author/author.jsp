<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
</head>
<body>
<p>Please, enter new author:</p>
<form action="" method="post">
    <input type="text" name="name" placeholder="new author name">
    <button type="submit">Enter</button>
</form>
${requestScope.message}
<br>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
