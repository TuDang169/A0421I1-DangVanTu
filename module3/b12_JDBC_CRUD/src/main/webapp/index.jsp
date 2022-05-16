<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student list</title>
</head>
<body>
<%--    <c:set var="x" value="Hello World!"/>--%>
<%--    <c:out value="${x}"/>--%>
<p>Search theo name</p>
<form action="/student" method="get">
    <input type="hidden" name="actionClient" value="search">
    <input name="name">
    <button type="submit">Tìm kiếm</button>
</form>
<p>Search kết hợp</p>
<form action="/student" method="get">
    <input type="hidden" name="actionClient" value="searchMix">
    <input name="name">
    <select name="gender">
        <option value="0">Female</option>
        <option value="1">Male</option>
    </select>
    <button type="submit">Tìm kiếm</button>
</form>
    <h2>Student List</h2>
    <p style="color: blue">${msg}</p>
    <table border="1">
        <tr>
            <th>No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th>Rank</th>
            <th>Gender</th>
            <th colspan="2">Action</th>
        </tr>
<%--        for (Student studentObj : studentListServlet)--%>
        <c:forEach var="studentObj" items="${studentListServlet}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${studentObj.id}"/></td>
                <td><c:out value="${studentObj.name}"/></td>
                <td><c:out value="${studentObj.dateOfBirth}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${studentObj.grade < 5}">
                            Bad
                        </c:when>
                        <c:when test="${studentObj.grade < 8}">
                            Good
                        </c:when>
                        <c:otherwise>
                            Excellent
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${studentObj.gender == 0}">
                        Female
                    </c:if>
                    <c:if test="${studentObj.gender == 1}">
                        Male
                    </c:if>
                </td>
                <td>
                    <a href="/student?actionClient=update&studentId=${studentObj.id}">
                        Update
                    </a>
                </td>
                <td>
                    <a href="/student?actionClient=delete&studentId=${studentObj.id}">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
