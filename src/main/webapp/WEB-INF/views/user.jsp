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
        <%@include file="style.css" %>
    </style>
<body>

<div class="w3-container w3-amber w3-xlarge" align="center">
    <h1>My Library Server User Edit Page</h1>
</div>
<hr>

<div class="w3-container w3-xlarge">
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/logout">Logout</a>
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/">Return</a>
</div>
<hr/>

<c:if test="${existsError==true}">
    <div class="w3-panel w3-red w3-display-container">
    <span onclick="this.parentElement.style.display='none';"
          class="w3-button w3-large w3-display-topright">&times;</span>
        <p>This user name already exists in the database !</p>
    </div>
</c:if>

<c:if test="${passwordError==true}">
    <div class="w3-panel w3-red w3-display-container">
    <span onclick="this.parentElement.style.display='none';"
          class="w3-button w3-large w3-display-topright">&times;</span>
        <p>Input passwords must be identical and must have at least 4 characters  !</p>
    </div>
</c:if>

<div class="w3-container w3-large">
    <form:form method="post" modelAttribute="user">

        <span style='width: 20%; display: inline-block'>Name : </span>
        <form:input cssStyle="width: 30%" path="name"/>
        <form:errors path="name" cssClass="error" element="div"/><br><br>

        <form:hidden path="password"/>

        <span style='width: 20%; display: inline-block'>New password : </span>
        <input type="password" style="width: 30%" name="newPassword1"/><br><br>
        <span style='width: 20%; display: inline-block'>Repeat New password : </span>
        <input type="password" style="width: 30%" name="newPassword2"/><br><br>

        <c:if test="${isAdmin!=false}">
            <span style='width: 20%; display: inline-block; vertical-align: top'>Roles : </span>
            <form:select cssStyle="width: 30%" path="roles" multiple="true">
                <form:option value="0" label="--Select roles--"/>
                <form:options items="${roles}" itemLabel="role" itemValue="id"/>
            </form:select><br><br>
            <form:errors path="roles" cssClass="error" element="div"/>
            <span style='width: 20%; display: inline-block'>Active : </span>
            <form:checkbox cssStyle="width: 30%" path="active"/>
            <form:errors path="active" cssClass="error" element="div"/><br><br>
        </c:if>

        <c:if test="${isAdmin==false}">
            <form:hidden path="roles"/>
            <form:hidden path="active"/>
        </c:if>

        <hr>
        <button type="submit"
                class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge">
            Save
        </button>
    </form:form>
</div>


</body>
</html>
