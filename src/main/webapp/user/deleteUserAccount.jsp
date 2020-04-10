<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<p>Are you seriously?</p>
<form action="/user" method="post">
    <input type="hidden" name="operation" value="delete">
    <button>Yes! Delete account</button>
</form>
<br>
<a href="/user"><button>No! Return</button></a>
</body>
</html>
