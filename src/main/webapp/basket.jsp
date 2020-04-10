<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
<c:if test="${!requestScope.isEmpty}">
    <p>Attention! Maximum basket capacity 10 books! <br>
        <p>Total price: ${requestScope.total}</p>
        In basket ${requestScope.books.size()} books. This is:</p>

    <ul style="list-style: decimal">
        <c:forEach items="${requestScope.books}" var="book">
            <li>Author: ${book.author.name}
                <br>
                Title: ${book.title}
                <br>
                Price: ${book.price}
                <br>
                Description: ${book.description}
                <br>
                <form action="/basket" method="post">
                    <input type="hidden" name="operation" value="delete">
                    <input type="hidden" name="id" value="${book.id}">
                    <button>Delete</button>
                </form>
            </li>
            <br>
        </c:forEach>
    </ul>
    Create order:
    <a href="/order">
        <button>Click</button>
    </a>
</c:if>
<br>
${requestScope.message}
<br>
<br>
<a href="book?operation=find&type=all">
    <button>All books page</button>
</a>
<br>
<br>
<a href="/user">
    <button>User page</button>
</a>
</body>
</html>
