<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<html>
<head>
    <title>Vetített filmek</title>
    <link rel="stylesheet" href="../css/alap.css" />
    <link rel="stylesheet" href="../css/filmek.css" />
</head>
<body>
<jsp:include page="../FilmekController"/>
<h1>Vetitett filmek</h1>

<c:forEach var="item" items="${requestScope.filmList}">
    <div class="elem">
        <a href="../Filmleiras?filmId=${item.id}">
            <img src="data:image/jpeg;base64,${item.kep}" />
            <div class="cim">${item.cim}</div>
        </a>
    </div>
</c:forEach>
<br class="clear" />
</body>
</html>
