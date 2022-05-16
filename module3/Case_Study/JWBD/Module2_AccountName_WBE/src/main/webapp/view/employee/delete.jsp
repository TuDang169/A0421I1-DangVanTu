<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 17/11/2021
  Time: 9:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Delete Employee</title>
</head>
<body>
<h1 align="center">Delete Employee</h1>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>

            <td>ID</td>
            <td>Name</td>
            <td>Birthday</td>
            <td>ID card</td>
            <td>Salary</td>
            <td>Phone</td>
            <td>Email</td>
            <td>Address</td>
            <td>Position Id</td>
            <td>Education Degree Id</td>
            <td>Division Id</td>
            <td>User Name</td>
        </tr>
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.birthday}</td>
            <td>${employee.idCard}</td>
            <td>${employee.salary}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.address}</td>
            <td>${employee.position_id}</td>
            <td>${employee.education_degree_id}</td>
            <td>${employee.division_id}</td>
            <td>${employee.userName}</td>
        </tr>
    </table>
    <tr>
        <td>
            <form action="/employees?action=delete&id=${employee.id}" method="post">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>

</div>

</body>
</html>
