<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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

    <c:form action="loginProfessor" method="post" modelAttribute="professorForm">
        <c:button> Volver </c:button>
    </c:form>

    <c:form action="addArticle" method="post" modelAttribute="articleForm">
        Título: <tag:input path="title" />

        <br><br>

        <label> Revista: </label> <br>
        <spring:bind path="magazine">
            <tag:select id="magazineSelect" path="magazine" class="form-control">
                <option value=""> Selecciona una revista </option>
                <d:forEach items="${magazines}" var="magazine">
                    <option value="${magazine.title}"> ${magazine.title} </option>
                </d:forEach>
            </tag:select>
        </spring:bind>

        <br><br>

        <label> Estado: </label> <br>
        <tag:radiobutton path="state" value="ACP" label="Aceptado" /> <br>
        <tag:radiobutton path="state" value="REV" label="Revisión" /> <br>
        <tag:radiobutton path="state" value="DES" label="Desarrollo" /> <br>

        <br><br>

<%--        <tag:input type="hidden" name="professor" value="${professor}" />--%>
<%--        <tag:input type="hidden" path=""></tag:input>--%>
        <tag:button> Registrar </tag:button>
    </c:form>

    <c:form action="showAddMagazine" method="post" modelAttribute="articleForm">
        <c:button> Agregar revista </c:button>
    </c:form>
</body>
</html>
