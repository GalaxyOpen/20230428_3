
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-28
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <style>
        #section a{
            display : block;
        }
    </style>

</head>
<body>
<%@include file="./component/header.jsp"%>
<%@include file="./component/nav.jsp"%>

<div id="section">
    <a href="/ajax-view01">ajax01</a>
    <a href="/ajax-view02">ajax02</a>
    <a href="/ajax-view03">ajax03</a>
    <a href="/ajax-view04">ajax04</a>
    <a href="/ajax-view05">ajax05</a>
    <a href="/ajax-view06">ajax06</a>
    <a href="/ajax-view07">ajax07</a>
    <a href="/ajax-view08">ajax08</a>
    <a href="/ajax-view09">ajax09</a>
    <a href="/ajax-view10">ajax10</a>


</div>

<%@include file="./component/footer.jsp"%>
</body>
</html>