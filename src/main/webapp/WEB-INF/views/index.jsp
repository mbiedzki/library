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
    <h1>My Library Server Index Page</h1>
</div>
<hr>

<div class="w3-container w3-xlarge">
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/books/">Test -  all books in native JSON</a>
</div>
<hr/>

<c:if test="${param.out==true}">
    <div class="w3-panel w3-green w3-display-container w3-xlarge w3-center">
    <span onclick="this.parentElement.style.display='none';"
          class="w3-button w3-large w3-display-topright">&times;</span>
        <p>Succesfully loged out</p>
    </div>
</c:if>

<div class="w3-container w3-xlarge">
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/admin/">Admin panel</a>
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/user/">User panel</a>
    <a class="w3-button w3-xlarge w3-border w3-border-amber w3-round-xxlarge"
       href="${pageContext.request.contextPath}/logout">Logout</a>
</div>

</body>
</html>
