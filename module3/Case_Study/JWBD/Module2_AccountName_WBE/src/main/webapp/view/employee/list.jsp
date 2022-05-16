<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 15/11/2021
  Time: 9:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employees?action=add">Add New Employee</a>
    </h2>
    <form action="/employees" method="get">
        <input type="hidden" name="action" value="search">
        <input name="name">
        <button type="submit">Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employees</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>ID card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position Id</th>
            <th>Education Degree Id</th>
            <th>Division Id</th>
            <th>User Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}" varStatus="status">
            <tr>
                <td>${employee.id}          </td>
                <td>${employee.name}        </td>
                <td>${employee.birthday}    </td>
                <td>${employee.idCard}      </td>
                <td>${employee.salary}      </td>
                <td>${employee.phone}       </td>
                <td>${employee.email}       </td>
                <td>${employee.address}     </td>
                <td>${employee.position_id} </td>
                <td>${employee.education_degree_id}</td>
                <td>${employee.division_id} </td>
                <td>${employee.userName}    </td>
                <td>
                    <a href="/employees?action=edit&id=${employee.id}">Edit</a>
                    <a href="/employees?action=delete&id=${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
