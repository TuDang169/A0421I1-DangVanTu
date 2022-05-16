<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 17/11/2021
  Time: 9:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/products?action=products">List All Product</a>
    </h2>
</center>
<div align="center">
    <form action="/products?action=edit" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit Product</h2>
            </caption>
            <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Price:</th>
                <td>
                    <input type="text" name="price" size="45" value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="45" value="<c:out value='${product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Color:</th>
                <td>
                    <input type="text" name="color" size="45" value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Product Category:</th>
                <td>
                    <select name="categoryId">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.id}"${category.id==product.categoryId?"selected":""}>${category.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
