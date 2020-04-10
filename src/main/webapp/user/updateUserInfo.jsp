<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<p>Update user info:</p>

- enter new first name:
<form action="/user" method="post">
    <input type="hidden" name="operation" value="update">
    <input type="hidden" name="type" value="info">
      <input type="text" name="firstName" placeholder="new first name">
<%--    <br>--%>
<%--    <input type="text" name="lastName" placeholder="new last name">--%>
    <button>Update</button>
</form>
<p>or</p>

- enter new last name:
<form action="/user" method="post">
    <input type="hidden" name="operation" value="update">
    <input type="hidden" name="type" value="info">
       <input type="text" name="lastName" placeholder="new last name">
    <button>Update</button>
</form>
<br>
${requestScope.message}
<br>
<br>
<a href="/user"><button>Return</button></a>
</body>
</html>
