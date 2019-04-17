<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Library</title>
    <style>
        <%@include file="w3.css" %>
    </style>
<body>

<div class="w3-container w3-amber w3-xlarge" align="center">
    <h1>My Library Server Admin Page</h1>
</div>
<hr>

<div class="w3-container w3-xlarge">
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/logout">Logout</a>
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/users/add">New User</a>
</div>
<hr/>

<div class="w3-container w3-large">
    <table class="w3-table-all">
        <thead>
        <tr class="w3-amber">
            <td>ID</td>
            <td>Name</td>
            <td>Active</td>
            <td>Roles</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.active}</td>

                <td>
                    <c:forEach items="${user.roles}" var="role">
                        ${role.role} <br>
                    </c:forEach>
                </td>

                <td><a href="${pageContext.request.contextPath}/users/edit/${user.id}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/users/delete/${user.id}"
                       onclick="return confirm ('Are you sure that you want to delete ?')">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
