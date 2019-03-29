<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
   <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>--%>
</head>
<body>
<h1>My library index page</h1>

<a href="${pageContext.request.contextPath}/book/list">List all books</a>

</body>
</html>
