<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Devon
  Date: 2020. 05. 09.
  Time: 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="../css/alap.css" />
    <link rel="stylesheet" href="../css/filmleiras.css" />
    <title>Film leírása</title>
</head>
<body>
<jsp:setProperty property="*" name="film"/>
<jsp:setProperty property="*" name="vetitesek"/>
<jsp:setProperty property="*" name="szineszek"/>

<div class="film">
    <div class="kepdiv">
        <img src="data:image/jpeg;base64,${film.kep}" />
    </div>
    <div class="adatok">
        <h1>${film.cim}</h1>
        <hr />
        <h2>Rendező:</h2>
        <h3>${film.rendezo}</h3>
        <hr />
        <h2>Korhatár:</h2>
        <h3>${film.korhatar}</h3>
        <hr />
        <h2>Színészek:</h2>
        <c:forEach var="item" items="${szineszek}">
            <h3>${item.nev}</h3>
        </c:forEach>
        <hr />
        <h2>Hossz:</h2>
        <h3>${film.hossz}</h3>
        <hr />
        <h2>Leírás:</h2>
        <h3>${film.leiras}</h3>
    </div>

<br class="clear" />
</div>
<div id="vetitesekspan"><h1 id="vetitesekcim" >Vetítések:</h1></div>
<div id="vetitesek">
    <c:forEach var="item" items="${vetitesek}">
        <div class="vetitesekkilso">
            <a href="/azonositas?vetitesId=${item.id}">
                <div class="vetites">
                        <h4>${item.datum}</h4>
                </div>
            </a>
        </div>
    </c:forEach>
    <br clear="clear" />
</div>
    <br clear="clear" />
</body>
</html>
