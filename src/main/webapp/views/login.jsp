<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17/09/2023
  Time: 10:27 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Login </title>
</head>
<body>
<h1> Login para Profesores </h1>

    <c:form action="loginProfessor" method="post" modelAttribute="professorForm">
        Nombre de usuario: <tag:input path="username" /><br><br>
        Contraseña: <tag:password path="password" /><br><br>
        <tag:button>Login</tag:button>

    </c:form>

</body>
</html>
