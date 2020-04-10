<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<p>Select next action:</p>
1. Update information:
<a href="/user?operation=update&type=info"><button>click</button></a>
<br>
<br>
2. Change password:
<a href="/user?operation=update&type=password"><button>click</button></a>
<br>
<br>
3. View my last order:
<a href="/order?operation=find&type=last"><button>click</button></a>
<br>
<br>
4. View basket:
<a href="/basket"><button>click</button></a>
<br>
<br>
5. Delete account:
<a href="/user?operation=delete"><button>click</button></a>
<br>
<br>
<a href="/main"><button>Return</button></a>
</body>
</html>
