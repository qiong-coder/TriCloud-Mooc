<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Account: qixiang
  Date: 8/15/17
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<c:forEach items="${accountList}" var="account">
    <li id="user_<c:out value="account.username"/>" >
        <div>
            username: <c:out value="${account.username}"/>
        </div>
        <div>
            password: <c:out value="${account.password}" />
        </div>
    </li>
</c:forEach>

</body>
</html>
