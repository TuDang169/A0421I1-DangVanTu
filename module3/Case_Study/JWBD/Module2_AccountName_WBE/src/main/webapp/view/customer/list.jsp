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
    <title>Customer Management</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=add">Add New Customer</a>
    </h2>
    <form action="/customers" method="get">
        <input type="hidden" name="action" value="search">
        <input name="name">
        <button type="submit">Search</button>
    </form>
    <form action="/customers" method="get">
        <input type="hidden" name="action" value="searchMix">
        <input name="name">
        <select name="gender">
            <option value="true" >Male  </option>
            <option value="false">Female</option>
        </select>
        <button type="submit">Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customers</h2></caption>
        <tr>
            <th>ID</th>
            <th>type ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>ID card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td>${customer.id}          </td>
                <td>${customer.typeId}      </td>
                <td>${customer.name}        </td>
                <td>${customer.birthDay}    </td>
                <td>
                    <c:if test="${customer.gender}">
                        <sp>Male</sp>
                    </c:if>
                    <c:if test="${!customer.gender}">
                        <sp>Female</sp>
                    </c:if>
                </td>
                <td>${customer.idCard}      </td>
                <td>${customer.phone}       </td>
                <td>${customer.email}       </td>
                <td>${customer.address}     </td>
                <td>
                    <a href="/customers?action=edit&id=${customer.id}">Edit</a>
                    <a href="/customers?action=delete&id=${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
