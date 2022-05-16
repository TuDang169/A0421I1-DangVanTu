<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/29/2021
  Time: 2:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Student</h1>
<form action="/student?action=add" method="post">
    ID        <input type="text" name="id"><br>
    Name      <input type="text" name="name"><br>
    Birthday   <input type="date" name="birthday"><br>
    Class      <select name="classId">
                <option value="0">--Chọn lớp--</option>
                <option value="1">--A03--</option>
                <option value="2">--A04--</option>
                </select><br>
    Point       <input type="text" name="point"><br>
    Gender      <input type="radio" name="gender" value="1">Male
                 <input type="radio" name="gender" value="0">Female<br>
    Email        <input type="text" name="email"><br>
    Account      <input type="text" name="account"><br>
                <button type="submit">Add</button>
</form>
</body>
</html>
