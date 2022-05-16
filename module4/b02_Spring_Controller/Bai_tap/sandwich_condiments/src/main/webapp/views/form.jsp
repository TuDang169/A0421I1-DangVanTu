<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 11/12/2021
  Time: 10:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sanwich Condiments</h1>
<form method="post" action="/selection">
    <select name="con">
        <option value="le" selected>Lettuce</option>
        <option value="to">Tomato</option>
        <option value="mu">Mustard</option>
        <option value="sp">Sprouts</option>
    </select>
    <input type="submit" value="Save">
</form>
</body>
</html>
