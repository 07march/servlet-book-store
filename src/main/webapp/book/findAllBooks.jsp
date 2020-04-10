<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find all books</title>
</head>
<body>

<c:if test="${requestScope.isAdmin}">
    <p>All books:</p>
    <ul>
        <c:forEach items="${requestScope.books}" var="books">
            <li>${books.title}</li>
        </c:forEach>
    </ul>
    <br>
    <br>
    ${requestScope.message}
    <br>
    <br>
    For return click
    <a href="/admin">
        <button>here</button>
    </a>
    <br>
</c:if>

<c:if test="${!requestScope.isAdmin}">

    <p>All books:</p>
    <ul style="list-style: decimal">
        <c:forEach items="${requestScope.books}" var="book">
            <li>
                Title: ${book.title}
                <br>
                Price: ${book.price}
                <br>
                <a href="/book?operation=find&type=id&value=${book.id}"><button>Open</button></a>
            </li>
            <br>
        </c:forEach>
    </ul>
    <br>
    ${requestScope.message}
    <br>
     <a href="/main">
        <button>Return</button>
    </a>
   </c:if>

</body>
</html>
