<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/09/2023
  Time: 03:41 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Nuevo artículo </title>
</head>
<body>
<h1> Nuevo artículo </h1>

    <c:form action="addArticle" method="post" modelAttribute="articleForm">
        Título: <tag:input path="title" />

        <tag:select path="magazine">
                <tag:options items="${magazines}" itemValue="title"/>
        </tag:select>

        <label>Estado:</label>
        <tag:radiobutton path="state" value="ACP" label="Aceptado" />
        <tag:radiobutton path="state" value="REV" label="Revisión" />
        <tag:radiobutton path="state" value="DES" label="Desarrollo" />

        <button type="submit">Registrar</button>
    </c:form>
</body>
</html>
