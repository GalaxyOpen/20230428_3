
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
    <form action="/save" method="post">
        <input type="text" id="member_Email" name="memberEmail" placeholder="이메일" onblur="email_check()"> <br>
        <h2 id="email_text"></h2>
        <input type="text" name="memberPassword" placeholder="비밀번호"> <br>
        <input type="text" name="memberName" placeholder="이름"> <br>
        <input type="text" name="memberBirth" placeholder="생년월일(YYYYMMDD)"> <br>
        <input type="text" name="memberMobile" placeholder="전화번호"> <br>
        <input type="submit" value="회원가입">
    </form>
</div>

<%@include file="./component/footer.jsp"%>
</body>
<script>
    const email_check = () => {
        const memberEmail = document.getElementById("member_Email").value;
        const alert_message = document.getElementById("email_text");
        $.ajax({
            type: "post",
            url: "email_check",
            data: {
                "email_check": memberEmail
            },
            success: function(res) {
                    // console.log("요청성공",res)
                    // console.log(res.memberEmail)
                    alert_message.innerHTML="사용할 수 있는 이메일 주소입니다.";
                    alert_message.style.color ="green";
            },
            error: function(){
                // console.log("요청실패");
                alert_message.innerHTML="이미 사용중인 이메일입니다.";
                alert_message.style.color="red";
            }
        })
    }
</script>
</html>