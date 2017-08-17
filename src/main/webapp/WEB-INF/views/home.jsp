<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Account: qixiang
  Date: 8/14/17
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Welcome to TriCloud</title>
</head>
<body>
<a href="<c:url value="/account/" />">users</a>
<a href="<c:url value="/account/register/" />">register</a>
</body>
</html>
