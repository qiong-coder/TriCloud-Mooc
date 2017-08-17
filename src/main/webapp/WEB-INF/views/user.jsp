<%--
  Created by IntelliJ IDEA.
  User: qixiang
  Date: 8/15/17
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User</title>
</head>
<body>

username: <c:out value="${account.username}" /><br/>
password: <c:out value="${account.password}" /><br/>

</body>
</html>
