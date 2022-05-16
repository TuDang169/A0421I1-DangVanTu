<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
    <h1>List Student</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${listStudents}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
