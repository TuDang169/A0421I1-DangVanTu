<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 12/12/2021
  Time: 3:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Email Setting</title>
</head>
<body>
    <h1>Info</h1>
    <table border="1">
        <tr>
            <td>Language</td>
            <td>Page size</td>
            <td>Spams Filter</td>
            <td>Signature</td>
        </tr>
        <c:forEach items="${emails}" var="email">
            <td>${email.language}</td>
            <td>${email.size}</td>
            <td>${email.filter}</td>
            <td>${email.signature}</td>
        </c:forEach>
    </table>
</body>
</html>
