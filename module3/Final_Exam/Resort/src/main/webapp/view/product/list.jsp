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
    <title>Product Management</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/products?action=add">Add New Customer</a>
    </h2>
    <form action="/products" method="get">
        <input type="hidden" name="action" value="search">
        <input name="name">
        <button type="submit">Search</button>
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Pride</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${productList}" varStatus="status">
            <tr>
                <td>${product.id}         </td>
                <td>${product.name}       </td>
                <td>${product.pride}      </td>
                <td>${product.quantity}   </td>
                <td>${product.color}      </td>
                <td>
                    <c:forEach items="${categoryList}" var="category">
                        <c:if test="${product.categoryId==category.id}">
                            <span>${category.name}</span>
                        </c:if>
                     </c:forEach>
                </td>
                <td>
                    <a href="/products?action=edit&id=${product.id}">Edit</a>
                    <a href="/products?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
