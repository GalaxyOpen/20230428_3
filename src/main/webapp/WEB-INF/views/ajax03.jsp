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
<button onclick="ajax03()">함수호출</button>
</body>
<script>
  const ajax03 = () => {
    const var1 = "hello monday";
    $.ajax({
      type: "get",
      url: "/ajax03",
      data: {
        param1: var1,
        param2: "hi hi"
      },
      success: function(res) {
        console.log("요청성공",res)
      },
      error: function(){
        console.log("요청실패");
      }
    })
  }
</script>
</html>
