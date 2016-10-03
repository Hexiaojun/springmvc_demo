<%--
  Created by IntelliJ IDEA.
  User: chenglei
  Date: 2016/10/3
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="<%=request.getContextPath()%>/stu/add" name="mainFrom">
    id: <input type="text" name="id">
    name: <input type="text" name="name">
    <input type="submit" value="submit">
</form>
</body>
</html>
