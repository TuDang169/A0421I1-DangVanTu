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
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/products?action=products">List All Product</a>
    </h2>
</center>
<div align="center">
    <form action="/products?action=add" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Pride:</th>
                <td>
                    <input type="text" name="pride" id="pride" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Category:</th>
                <td>
                    <select name="categoryId">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
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