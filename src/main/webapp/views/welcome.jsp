<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/09/2023
  Time: 01:32 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title> Bienvenido </title>

    <link rel="stylesheet" type="text/css" href="./css/styles.css" media="all">
</head>
<body>

    <h1> ¡Bienvenido, ${professor.username}! </h1>

    <h3> Acerca de usted: </h3>
    <ul>
        <li> Nombre completo: ${professor.fullName} </li>
        <li> Grado académico: ${professor.academicGrade} </li>
    </ul>

    <br>

    <h3>Artículos:</h3>
    <table class="articles-table">
        <thead>
        <tr>
            <th> Título </th>
            <th> Revista </th>
            <th> Categoría </th>
            <th> Estado </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${professor.articles}" var="article">
            <tr>
                <td>${article.title}</td>
                <td>${article.magazine.title}</td>
                <td>${article.magazine.type}</td>
                <td>${article.state}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>

    <h3>Proyectos terminales:</h3>
    <table class="projects-table">
        <thead>
        <tr>
            <th> Título </th>
            <th> Cantidad de alumnos </th>
            <th> Estado </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${professor.projects}" var="project">
            <tr>
                <td>${project.title}</td>
                <td>${project.studentsQuantity}</td>
                <td>${project.state}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
