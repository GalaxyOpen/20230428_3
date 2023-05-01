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


</head>
<body>
<%@include file="./component/header.jsp"%>
<%@include file="./component/nav.jsp"%>

<div id="section">
    <form action="/login" method="post">
        <input type="text" name="memberEmail" placeholder="이메일"> <br>
        <input type="text" name="memberPassword" placeholder="비밀번호"> <br>
        <input type="submit" value="로그인">
    </form>
</div>

<%@include file="./component/footer.jsp"%>
</body>
</html>