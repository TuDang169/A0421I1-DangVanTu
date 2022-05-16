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
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="customers?action=customers">List All Customer</a>
    </h2>
</center>
<div align="center">
    <form action="/customers?action=add" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Type ID:</th>
                <td>
                    <select name="typeId">
                        <c:forEach items="${customerTypeList}" var="type">
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthDay" size="45"/>
                </td>
            </tr>
            <tr>
            <th>Customer Gender:</th>
            <td>
                <input type="radio" checked name="gender" value="true"/>Male
                <input type="radio"         name="gender" value="false"/>Female
            </td>
            </tr>
            <tr>
                <th>Customer Id Card:</th>
                <td>
                    <input type="text" name="idcard" id="idCard" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
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