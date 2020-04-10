<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Methods</title>
</head>
<body>
<p>Welcome, Admin! All methods:</p>

<p>1. Create</p>

<a href="/address"><button>a) create address</button></a>

<a href="/author"><button>b) create author</button></a>

<a href="/book"><button>c) create book</button></a>

<a href="/city"><button>d) create city</button></a>

<p>2. Delete</p>

a) address:

<a href="/address?operation=delete"><button>- delete address by name</button></a>
<br>
<br>
b) author:

<a href="/author?operation=delete"><button>- delete author by id</button></a>
<br>
<br>
c) book:

<a href="/book?operation=delete&type=title"><button>- delete book by title</button></a>

<a href="/book?operation=delete&type=id"><button>- delete book by id</button></a>
<br>
<br>
d) city:

<a href="/city?operation=delete&type=name"><button>- delete city by name</button></a>

<a href="/city?operation=delete&type=id"><button>- delete city by id</button></a>

<p>3. Find</p>

a) address:

<a href="/address?operation=find&type=all"><button>- find all addresses</button></a>

<a href="/address?operation=find&type=id"><button>- find address by id</button></a>

<a href="/address?operation=find&type=name"><button>- find address by name</button></a>
<br>
<br>
b) author:

<a href="/author?operation=find&type=all"><button>- find all authors</button></a>

<a href="/author?operation=find&type=id"><button>- find author by id</button></a>

<a href="/author?operation=find&type=name"><button>- find author by name</button></a>
<br>
<br>
c) book:

<a href="/book?operation=find&type=all"><button>- find all books</button></a>

<a href="/book?operation=find&type=allByAuthorName"><button>- find all books by author name</button></a>

<a href="/book?operation=find&type=allByPrice"><button>- find all books by price</button></a>

<a href="/book?operation=find&type=id"><button>- find book by id</button></a>

<a href="/book?operation=find&type=title"><button>- find book by title</button></a>
<br>
<br>
d) city:

<a href="/city?operation=find&type=all"><button>- find all cities</button></a>

<a href="/city?operation=find&type=name"><button>- find by city name</button></a>

<p>4. Update</p>

a) address:

<a href="/address?operation=update"><button>- update address</button></a>
<br>
<br>
b) author:

<a href="/author?operation=update"><button>- update author name</button></a>
<br>
<br>
c) book:

<a href="/book?operation=update&type=title"><button>- update title</button></a>

<a href="/book?operation=update&type=price"><button>- update price</button></a>
<br>
<br>
d) city:

<a href="/city?operation=update&type=name"><button>- update city name</button></a>
<br>
<br>
<a href="/main"><button>Return</button></a>
</body>
</html>
