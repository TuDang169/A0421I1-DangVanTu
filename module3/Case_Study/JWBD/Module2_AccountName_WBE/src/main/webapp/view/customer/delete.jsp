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
    <title>Delete Customer</title>
</head>
<body>
<h1>Delete Customer</h1>
ID      :<span>${customer.id}</span><br>
ID Type :<span>${customer.typeId}</span><br>
Name    :<span>${customer.name}</span><br>
Birthday:<span>${customer.birthDay}</span><br>
Gender  :<span>${customer.gender}</span><br>
ID Card :<span>${customer.idCard}</span><br>
Phone   :<span>${customer.phone}</span><br>
Email   :<span>${customer.email}</span><br>
Adress  :<span>${customer.address}</span><br>
<form action="/customers?action=delete&id=${customer.id}" method="post">
    <button type="submit">Delete</button>
</form>
</body>
</html>
