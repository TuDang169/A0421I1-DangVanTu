<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/29/2021
  Time: 2:42 AM
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
<h1>Edit Student</h1>
<form action="/student?action=edit" method="post" >
    ID      <input type="text" name="id" value="${student.id}"><br>
    Name      <input type="text" name="name" value="${student.name}"><br>
    Birthday   <input type="date" name="birthday" value="${student.birthday}"><br>
    Class      <select name="classId">
                <option value="0">--Chọn lớp--</option>
                <c:forEach items="${classList}" var="class1">
                        <option value="${class1.id}"${class1.id==student.classId?"selected":""}>${class1.name}</option>
<%--                    <c:if test="${!class1.id==student.classId}">--%>
<%--                        <option value="${class1.id}">${class1.name}</option>--%>
<%--                    </c:if>--%>
                </c:forEach>
                </select><br>
    Point       <input type="text" name="point" value="${student.point}"><br>
    Gender      <input type="radio" ${student.gender=="1"?"checked":""} name="gender" value="1">Male
                 <input type="radio" name="gender"${student.gender=="0"?"checked":""} value="0">Female<br>
    Email        <input type="text" name="email" value="${student.email}"><br>
                <button type="submit">Save</button>
</form>
</body>
</html>
