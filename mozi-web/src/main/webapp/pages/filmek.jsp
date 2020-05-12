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
<header>
    <a href="/pages/filmek.jsp"><img src="/images/index.png" id="index" alt="Film összehasonlító"/></a>
</header>
<h1>Vetitett filmek</h1>

<form method="post" action="/pages/filmek.jsp">
    <input id="kereso" name="kulcsszo" type="text" placeholder="Filmcímrészlet" />
    <input class="gomb" type="submit" value="Keresés" />
</form>


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
