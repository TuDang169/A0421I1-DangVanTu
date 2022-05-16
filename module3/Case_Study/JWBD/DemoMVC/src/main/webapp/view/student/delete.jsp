<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/29/2021
  Time: 3:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Student</h1>
ID:<span>${student.id}</span>
Name:<span>${student.name}</span>
Birthday:<span>${student.birthday}</span>
Gender:<span>${student.gender}</span>
Emal:<span>${student.email}</span>
<form action="/student?action=delete&id=${student.id}" method="post">
    <button type="submit">Delete</button>
</form>
</body>
</html>
