<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/1
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/transfer" METHOD="post">
    <input type="text" placeholder="输入转账者账号" name="aname">
    <input type="text" placeholder="输入收款者账号" name="bname">
    <input type="text" placeholder="输入转账金额" name="price">
    <input type="submit" value="提交">
</form>
</body>
</html>
