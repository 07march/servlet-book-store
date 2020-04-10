<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Order</title>
</head>
<body>
<p>Are you sure?</p>
<form action="/order" method="post">
    <input type="hidden" name="operation" value="delete">
    <button>Yes</button>
</form>
${requestScope.deleteMessage}
<br>
<br>
<a href="/user"><button>Back</button></a>
</body>
</html>
