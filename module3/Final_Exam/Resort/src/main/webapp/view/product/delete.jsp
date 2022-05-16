<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 17/11/2021
  Time: 9:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
ID          :<span>${product.id}</span><br>
Name        :<span>${product.name}</span><br>
Pride       :<span>${product.pride}</span><br>
Quantity    :<span>${product.quantity}</span><br>
Color       :<span>${product.color}</span><br>
Category    :<span>${product.categoryId}</span><br>
<form action="/products?action=delete&id=${product.id}" method="post">
    <button type="submit">Delete</button>
</form>
</body>
</html>
