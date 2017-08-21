<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: qixiang
  Date: 8/20/17
  Time: 06:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>update load test</title>
</head>
<body>

<form method="post" enctype="multipart/form-data" action="/course/administrator/">
    课程名称：<input type="text" name="name"/><br/>
    <%--教师名称：<input type="text" name="teacher_name" /><br/>--%>
    课程描述：<input type="file" name="attachment" accept="application/pdf,image/jpeg,image/png"/><br />
    <input type="submit" value="Upload">
</form>

</body>
</html>
