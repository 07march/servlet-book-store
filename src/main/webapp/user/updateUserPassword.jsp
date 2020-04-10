<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User Password</title>
</head>
<body>
<p>Update password:</p>
- enter new password:
<form action="/user" method="post">
    <input type="hidden" name="operation" value="update">
    <input type="hidden" name="type" value="password">
    <input type="text" name="password" placeholder="new password">
    <button>Update</button>
</form>
<br>
${requestScope.message}
<br>
<br>
<a href="/user"><button>Return</button></a>
</body>
</html>
