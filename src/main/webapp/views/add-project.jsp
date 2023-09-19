<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 18/09/2023
  Time: 05:46 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Agregar proyecto </title>
</head>
<body>
<h1> Nuevo proyecto </h1>

    <tag:form action="loginProfessor" method="post" modelAttribute="professorForm">
        <tag:button> Volver </tag:button>
    </tag:form>

    <tag:form action="addProject" method="post" modelAttribute="projectForm">
        Título: <tag:input path="title" />

        <br><br>

        Cantidad de estudiantes: <tag:input path="studentsQuantity" />

        <br><br>

        <label> Tipo: </label> <br>
        <tag:radiobutton path="state" value="FIN" label="Finalizado" /> <br>
        <tag:radiobutton path="state" value="DES" label="En Desarrollo" /> <br>

        <br><br>

        <tag:button> Registrar </tag:button>
    </tag:form>

</body>
</html>
