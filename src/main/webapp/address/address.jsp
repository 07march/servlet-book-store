<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>
</head>
<body>
<p>Please, enter new address:</p>
<form action="" method="post">
    <input type="text" name="address" placeholder="new address">
    <button type="submit">Enter</button>
</form>
${requestScope.message}
<br>
<br>
<a href="/admin"><button type="submit">Return</button>
</a>
</body>
</html>
