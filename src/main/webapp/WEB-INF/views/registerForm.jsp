<%--
  Created by IntelliJ IDEA.
  User: stupid-coder
  Date: 8/14/17
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TriCloud-Mooc</title>
</head>
<body>
    <h1>Register</h1>

    <sf:form method="POST" commandName="user" action="/register">
        First Name: <sf:input path="firstName" />
        <sf:errors path="firstName"/><br>
        Last Name:  <sf:input path="lastName" /><br>
        Username:   <sf:input path="username" /><br>
        Password:   <sf:password path="password" /><br>
        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
