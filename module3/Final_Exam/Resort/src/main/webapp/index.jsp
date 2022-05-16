<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 15/11/2021
  Time: 9:59 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product Manager</title>
  <link rel="stylesheet" href="CSS.css">
</head>
<body>
<div id="header">
  <ul>
    <li><a href="#">Logo</a></li>
    <li id="name"></li>
  </ul>
</div>
<div id="menu">
  <ul>
    <li><a href="#">Home</a></li>
    <li><a href="/employees">Employee</a></li>
    <li><a href="/customers">Customer</a></li>
    <li><a href="/services">Service</a></li>
    <li><a href="/contracts">Contract</a>
      <ul>
        <li><a href="#">Content</a></li>
      </ul>
    </li>
    <li id="search"><input type="text" size="15"></li>
  </ul>
</div>
<div id="content" class="row">
  <div class="col-s-2 left">
    <ul>
      <li><a href="#">Item One</a></li>
      <li><a href="#">Item Two</a></li>
      <li><a href="#">Item Three</a></li>
    </ul>
  </div>
  <div class="col-s-9 content">
    <h1>WelCome</h1>
    <p>Paragraphs</p>
    <hr>
    <h2>Test</h2>
    <p>Paragraphs</p>
  </div>
</div>
<div class="foot">Footer text</div>
</body>
</html>
