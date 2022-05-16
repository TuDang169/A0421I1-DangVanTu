<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 12/12/2021
  Time: 2:20 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
    <h1>SETTING</h1>
    <form:form action="form" method="post" modelAttribute="email">
        <table border="1">
            <tr>
                <td>Language</td>
                <td><form:select path="language" items="${listLanguage}"></form:select></td>
            </tr>
            <tr>
                <td>Page size:</td>
                <td>Show <form:select path="size" items="${listSize}"></form:select> emails per page</td>
            </tr>
            <tr>
                <td>Spams Filter:</td>
                <td><form:checkbox path="filter"></form:checkbox> Enable spams filter</td>
            </tr>
            <tr>
                <td>Signature:</td>
                <td><form:textarea path="signature"></form:textarea></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
