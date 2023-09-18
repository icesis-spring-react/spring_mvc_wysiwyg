<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 18/09/2023
  Time: 05:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Agregar Revista </title>
</head>
<body>
<h1> Nueva revista </h1>

    <tag:form action="showAddArticle" method="post" modelAttribute="articleForm">
        <tag:button> Volver </tag:button>
    </tag:form>

    <tag:form action="addMagazine" method="post" modelAttribute="magazineForm">
        Título: <tag:input path="title" />

        <br><br>

        ISBN: <tag:input path="isbn" />

        <br><br>

        <label> Tipo: </label> <br>
        <tag:radiobutton path="type" value="IDX" label="Indexada" /> <br>
        <tag:radiobutton path="type" value="NOIDX" label="No Indexada" /> <br>

        <br><br>

        <tag:button> Registrar </tag:button>
    </tag:form>

</body>
</html>
