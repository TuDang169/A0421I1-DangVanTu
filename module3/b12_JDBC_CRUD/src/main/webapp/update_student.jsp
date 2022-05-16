<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
</head>
<body>
    <h2>Update student</h2>
    <p style="color: red">${msg}</p>
    <form action="/student" method="post">
<%--        <input type="hidden" name="actionClient" value="update" />--%>
<%--        <input type="hidden" name="studentId" value="${studentObj.id}" />--%>
        <p>Name: </p>
        <input type="text" name="nameStudent" value="${studentObj.name}"/>
        <p>Date of birth: </p>
        <input type="date" name="dateOfBirth" value="${studentObj.dateOfBirth}"/>
        <input type="submit" value="Update" />
    </form>
</body>
</html>
