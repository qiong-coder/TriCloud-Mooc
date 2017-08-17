<%--
  Created by IntelliJ IDEA.
  User: stupid-coder
  Date: 8/14/17
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>TriCloud-Mooc</title>
</head>
<body>
    <h1>Register</h1>

    <sf:form method="POST" modelAttribute="account">
        Username:   <sf:input path="username" /> <sf:errors path="username"/><br>
        Password:   <sf:password path="password" /> <sf:errors path="password"/><br>
        <input type="submit" value="Register" />
    </sf:form>

</body>
</html>
