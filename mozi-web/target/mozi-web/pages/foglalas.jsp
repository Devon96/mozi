<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="hu.alkfejl.model.bean.Terem" %>
<%@ page import="hu.alkfejl.model.bean.Foglalas" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Foglálás</title>
    <link rel="stylesheet" href="../css/alap.css" />
    <link rel="stylesheet" href="../css/foglalas.css" />
</head>
<body>
<jsp:include page="../FoglalasController"/>

<h1>${sessionScope.foglalas.nev}</h1>
<h1>${requestScope.terem.nev}</h1>

<div class="main">
<div id="terem">
    <%
        Terem terem = (Terem) request.getAttribute("terem");
        ArrayList<Foglalas> szemelyFoglalasai = (ArrayList<Foglalas>) request.getAttribute("foglalasai");
        ArrayList<Foglalas> foglaltak = (ArrayList<Foglalas>) request.getAttribute("foglaltak");

        int oszlopokszama = terem.getOszlop();
        int sorokszama = terem.getSor();
        int szekszelesseg = 1000 / oszlopokszama;
        for(int i = 1; i <= sorokszama; i++){
            for(int j = 1; j <= oszlopokszama; j++){
                boolean szabad = true;
                for(Foglalas foglalas : szemelyFoglalasai){
                    if(foglalas.getSor() == i && foglalas.getOszlop() == j){
                        out.print("<div style='width: " + (szekszelesseg-4) + "px;height:" + (szekszelesseg-4) + "px;' class='UserFoglaltSzek'></div>");
                        szabad = false;
                        break;
                    }
                }
                for(Foglalas foglalas : foglaltak){
                    if(foglalas.getSor() == i && foglalas.getOszlop() == j){
                        out.print("<div style='width: " + (szekszelesseg-4) + "px;height:" + (szekszelesseg-4) + "px;' class='foglaltSzek'></div>");
                        szabad = false;
                        break;
                    }
                }
                if(szabad){
                    out.print("<a href='../Foglal?sor=" + i + "&oszlop=" + j + "'><div style='width: " + (szekszelesseg-4) + "px;height:" + (szekszelesseg-4) + "px;' class='szek'></div></a>");
                }
            }
            out.print("<br class='clear' />");
        }
    %>
    <br class="clear"/>
    </div>
<br class="clear"/>
</div>
<h1>Hellllllo</h1>
</body>
</html>
