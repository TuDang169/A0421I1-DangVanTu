<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 16/11/2021
  Time: 11:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="employees?action=employees">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form action="/employees?action=add" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card:</th>
                <td>
                    <input type="text" name="idcard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Position Id:</th>
                <td>
                    <input type="text" name="position_id" id="position_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Education Degree Id:</th>
                <td>
                    <input type="text" name="education_degree_id" id="education_degree_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Division Id:</th>
                <td>
                    <input type="text" name="division_id" id="division_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee User Name:</th>
                <td>
                    <input type="text" name="userName" id="userName" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>