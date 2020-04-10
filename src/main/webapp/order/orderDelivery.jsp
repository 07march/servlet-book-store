<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Delivery</title>
</head>
<body>
    <form action="/order" method="post">
    <input type="hidden" name="operation" value="create">
    <input type="hidden" name="type" value="delivery">
    <input type="text" placeholder="Address" name="address">
    <button>Create</button>
    </form>
</body>
</html>