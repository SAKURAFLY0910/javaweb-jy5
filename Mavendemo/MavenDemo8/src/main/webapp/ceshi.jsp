<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/12
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span id="er"></span>
<button value="转换"></button>
</body>
<script src="WEB-INF/jquery-3.3.1.js"></script>
<script>
$(document).ready(function () {
    $("button").click(function () {
        var s="Users{id=27, username='MD5ceshi', password='0b4e7a0e5fe84ad35fb5f95b9ceeac79', email='123@1231', phone='111', question='111', answer='111', role=1, createTime=Mon Nov 26 17:05:28 CST 2018, updateTime=Tue Nov 27 00:55:21 CST 2018}";
        document.getElementById("er").innerHTML="shuju";
    });
});
</script>
</html>
