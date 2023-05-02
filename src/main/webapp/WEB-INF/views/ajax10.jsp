<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ajax01</title>
  <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
  <%--  jquery--%>
</head>
<body>
<%--ajax(Asyncoronous Javascript and XML
비동기 방식.
ex)물건을 클릭하면 장바구니에 자동으로 담기는 방식
ex)악시옥스(스프링 부트떄 함)--%>
<button onclick="ajax10()">함수호출</button>
<div id="result-area">

</div>
</body>
<script>
  const ajax10 = () => {
    const member ={
      "memberEmail" : "aaa@aaaa.com",
      "memberPassword":"1q2w3e",
      "memberName": "회원1"
    };
    $.ajax({
      type: "post",
      url: "/ajax10",

      // 자바스크립트 object를 Json으로 변환하는 함수
      data: JSON.stringify(member),

      // 서버에게 보내는 데이터의 타입을 지정
      contentType: "application/json",
      success: function(res) {
        console.log("요청성공", res);
        // member에 담긴 이름 접근하는 방법
        console.log("name",res.member.memberName);
        for(let i in res.memberList){
          console.log(res.memberList[i]);
        }
      },
      error: function () {
        console.log("요청실패");
      }
    });
  }
</script>
</html>
