<%--
  Created by IntelliJ IDEA.
  User: tú
  Date: 30/10/2021
  Time: 10:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
    <style>
      form{
        height:300px; width:230px;
        margin: 0;
        padding: 10px;
        border:1px #CCC solid;
      }
      input{
        padding:5px; margin:5px
      }
    </style>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form action="/result" method="post">
    <label>Product Description:</label><br/>
    <input type="text" name="description" placeholder="Description"><br/>
    <label> List Price:</label><br/>
    <input type="text" name="price" placeholder="PRICE" value="0"><br/>
    <label> Discount Percent:</label><br/>
    <input type="text" name="percent" placeholder="PERCENT" value="0"><br/>
    <input type="submit" name="submit" value="Result">
  </form>
  </body>
</html>
