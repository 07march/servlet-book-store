<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MainServlet</title>
</head>
<body>
<h1>Welcome, ${requestScope.message} !</h1>

<c:if test="${sessionScope.currentUser == null}">
    <p>Sign up or Log in!</p>
    <br>
    <a href="/reg">
        <button type="submit">Registration</button>
    </a>
    <a href="/auth">
        <button type="submit">Autorization</button>
    </a>
       <a href="/book?operation=find&type=all"><button>View all books</button></a>
</c:if>
<c:if test="${sessionScope.currentUser != null}">

    <c:if test="${requestScope.flagAdmin}">
        Login successful!
        <br>
        <br>
        Information about you:
        <br>
        - your name is ${sessionScope.currentUser.firstName} ;
        <br>
        - your lastName is ${sessionScope.currentUser.lastName} ;
        <br>
        - your email : ${sessionScope.currentUser.email} .
        <br>
        <br>
        To Admin cabinet
        <a href="/admin">
            <button>click</button>
        </a>
        <br>
        <br>
        To exit
        <a href="/logout">
            <button type="submit">click</button>
        </a>
    </c:if>

    <c:if test="${requestScope.flagUser}">
        Login successful!
        <br>
        <br>
        Information about you:
        <br>
        - your name is ${sessionScope.currentUser.firstName} ;
        <br>
        - your lastName is ${sessionScope.currentUser.lastName} ;
        <br>
        - your email : ${sessionScope.currentUser.email} .
        <br>
            <br>
        To User cabinet:
        <a href="/user">
            <button>User Cabinet</button>
        </a>
        <br>
        View all books:
        <a href="/book?operation=find&type=all"><button>View</button></a>
        <br>
        To exit:
        <a href="/logout">
            <button type="submit">Exit</button>
        </a>
    </c:if>
</c:if>
</body>
</html>
