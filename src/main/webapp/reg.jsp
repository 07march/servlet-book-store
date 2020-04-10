<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reg</title>
</head>
<body>
<p>Registration</p>
<form action="reg" method="post">
    <input type="number" name="id" placeholder="Id">
    <br>
    <input type="text" name="firstName" placeholder="First Name">
    <br>
    <input type="text" name="lastName" placeholder="Last Name">
    <br>
    <input type="text" name="email" placeholder="Email">
    <br>
    <input type="text" name="password" placeholder="Password">
    <br>
    <button type="submit">Registration</button>
    </form>
${requestScope.message}
<br>
<br>
For autorization click here:
<a href="/auth"><button type="submit">Click</button> </a>
<br>
<br>
For return on start page click:
<a href="/main"><button>Back</button></a>
</body>
</html>
