<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<p>Autorization</p>
<form action="auth" method="post">
    <input type="text" name="email" placeholder="Email">
    <input type="text" name="password" placeholder="Password">
    <button type="submit">Autorization</button>
</form>
${requestScope.message}
<br>
<br>
For return on start page click:
<a href="/main"><button>Back</button></a>
<br>
</body>
</html>
