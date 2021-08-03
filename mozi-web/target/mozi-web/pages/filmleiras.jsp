
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

<%@ include file="fragments/head.jspf" %>

<body>
<link rel="stylesheet" href="../css/filmleiras.css" />
<jsp:setProperty property="*" name="film"/>
<jsp:setProperty property="*" name="vetitesek"/>
<jsp:setProperty property="*" name="szineszek"/>

<%@ include file="./fragments/header.jspf" %>

<section class="container-fluid">

    <div class="row">


        <div class="col-12 col-md-4">
            <img class="poster" src="data:image/jpeg;base64,${film.kep}" />
        </div>
        <div class="col-12 col-md-8">
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


    </div>

</section>
<section>

    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <h1 class="appointments" >Vetítések:</h1>
            </div>
        </div>
    </div>

    <div class="container-fluid">

        <div class="row">

        <c:forEach var="item" items="${vetitesek}">
            <div class="col-6 col-sm-4 col-md-4 col-lg-4 col-xl-3">
                <a href="/azonositas?vetitesId=${item.id}">

                    <div class="time">
                        <h4>${item.datum}</h4>
                    </div>

                </a>
            </div>
        </c:forEach>

        </div>

    </div>


</section>

</body>
</html>
