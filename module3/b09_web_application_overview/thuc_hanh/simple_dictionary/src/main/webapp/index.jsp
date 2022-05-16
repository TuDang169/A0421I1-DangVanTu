<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 29/10/2021
  Time: 3:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Simple Dictionary</title>
  <style type="text/css">
    form {
      height:80px; width:300px;
      margin:0;
      padding:10px;
      border:1px #CCC solid;
    }
    form input {
      padding:5px; margin:5px
    }
  </style>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate" method="post">
  <input type="text" name="txtSearch" placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
</form>
</body>
</html>
