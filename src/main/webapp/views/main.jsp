<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@는 import--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%--<%--%>
<%--    if(session.getAttribute("uid")==null)--%>
<%--        response.sendRedirect("/login");--%>
<%--%>--%>

  <img src="/img/ffsf.png"><br>
    <h1><%=(String) request.getAttribute("uname")%> 환영합니다.</h1>
    <h1>${uname}환영합니다.</h1><br>
<%--변수를 갖다쓰고싶을때는 =을 붙인다--%>
<%@ include file="todos.jsp"%>
<%@ include file="todolist.jsp"%>
<form method="get" action="/main?keyword=">
    <input type="text" name="keyword">
    <input type="submit" value="찾기">

</form>
</body>

</html>