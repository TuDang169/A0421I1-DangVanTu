<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Linh
  Date: 12/3/2021
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Student</title>
</head>
<body>
    <h1>Create new student</h1>
    <form:form action="/student/create" method="post" modelAttribute="student">
        <table border="1">
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Subjects</td>
                <td><form:checkboxes items="${listSubjects}" path="subjects" /></td>
            </tr>
            <tr>
                <td><input type="reset" value="Reset"></td>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
