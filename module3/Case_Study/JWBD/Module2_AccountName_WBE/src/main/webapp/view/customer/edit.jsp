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
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=customers">List All Customers</a>
    </h2>
</center>
<div align="center">
    <form action="/customers?action=edit" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit customer
                </h2>
            </caption>
            <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            <tr>
                <th>Customer Type Id:</th>
                <td>
                    <select name="typeId">
                        <c:forEach items="${customerTypeList}" var="type">
                            <option value="${type.id}"${type.id==customer.typeId?"selected":""}>${type.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <input type="hidden" name="typeId" value="<c:out value='${customer.typeId}' />"/>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="text" name="birthday" size="45" value="<c:out value='${customer.birthDay}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="radio" ${customer.gender=="1"?"checked":""} name="gender" value="true" >Male
                    <input type="radio" ${customer.gender=="0"?"checked":""} name="gender" value="false">Female
                </td>
            </tr>
            <tr>
                <th>Customer ID Card:</th>
                <td>
                    <input type="text" name="idcard" size="45" value="<c:out value='${customer.idCard}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" size="45" value="<c:out value='${customer.phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" size="45" value="<c:out value='${customer.email}' />"/>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" size="45" value="<c:out value='${customer.address}' />"
                    />
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
